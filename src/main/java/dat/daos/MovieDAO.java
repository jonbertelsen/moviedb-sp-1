package dat.daos;

import dat.dtos.MovieDTO;
import dat.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.stream.Collectors;

public class MovieDAO implements IDAO<MovieDTO, Integer> {

    private static EntityManagerFactory emf;
    private static MovieDAO instance;

    private MovieDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

    public static MovieDAO getInstance(EntityManagerFactory emf){
        if (instance == null){
            instance = new MovieDAO(emf);
        }
        return instance;
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        EntityManager em = emf.createEntityManager();

        Movie movie = em.find(Movie.class, movieDTO.getId());

        if (movie != null){
            return new MovieDTO(movie);
        }

        movie = new Movie(movieDTO);
        try {
            em.getTransaction().begin();

            // Handling existing genres
            if (movie.getGenres() != null) {
                movie.setGenres(movie.getGenres().stream().map(genre -> {
                    Genre existingGenre = em.find(Genre.class, genre.getId());
                    return existingGenre != null ? existingGenre : genre;
                }).collect(Collectors.toList()));
            }

            if (movie.getCredits() != null) {
                // Handling existing cast members
                if (movie.getCredits().getCast() != null) {
                    movie.getCredits().setCast(movie.getCredits().getCast().stream().map(castMember -> {
                        CastMember existingCastMember = em.find(CastMember.class, castMember.getId());
                        return existingCastMember != null ? existingCastMember : em.merge(castMember); // Merge to attach
                    }).collect(Collectors.toList()));
                }
                if (movie.getCredits().getCrew() != null) {
                    // Handling existing crew members
                    movie.getCredits().setCrew(movie.getCredits().getCrew().stream().map(crewMember -> {
                        CrewMember existingCrewMember = em.find(CrewMember.class, crewMember.getId());
                        return existingCrewMember != null ? existingCrewMember : em.merge(crewMember); // Merge to attach
                    }).collect(Collectors.toList()));
                }
            }

            if (movieDTO.getSpokenLanguages() != null){
                movie.setSpokenLanguages(movieDTO.getSpokenLanguages().stream().map(spokenLanguageDTO -> {
                    SpokenLanguage existingSpokenLanguage = em.find(SpokenLanguage.class, spokenLanguageDTO.getIso6391());
                    return existingSpokenLanguage != null ? existingSpokenLanguage : new SpokenLanguage(spokenLanguageDTO);
                }).collect(Collectors.toList()));
            }

            if (movieDTO.getProductionCompanies() != null){
                movie.setProductionCompanies(movieDTO.getProductionCompanies().stream().map(productionCompanyDTO -> {
                    ProductionCompany existingProductionCompany = em.find(ProductionCompany.class, productionCompanyDTO.getId());
                    return existingProductionCompany != null ? existingProductionCompany : new ProductionCompany(productionCompanyDTO);
                }).collect(Collectors.toList()));
            }

            if (movieDTO.getProductionCountries() != null){
                movie.setProductionCountries(movieDTO.getProductionCountries().stream().map(productionCountryDTO -> {
                    ProductionCountry existingProductionCountry = em.find(ProductionCountry.class, productionCountryDTO.getIso31661());
                    return existingProductionCountry != null ? existingProductionCountry : new ProductionCountry(productionCountryDTO);
                }).collect(Collectors.toList()));
            }

            em.persist(movie);
            em.getTransaction().commit();
            return new MovieDTO(movie);

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public MovieDTO update(MovieDTO movieDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            Movie existingMovie = em.find(Movie.class, movieDTO.getId());
            if (existingMovie == null) {
                throw new IllegalArgumentException("Movie with ID " + movieDTO.getId() + " not found.");
            }
            Movie updatedMovie = new Movie(movieDTO);
            em.getTransaction().begin();
            em.merge(updatedMovie);
            em.getTransaction().commit();
            return new MovieDTO(updatedMovie);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) {
            EntityManager em = emf.createEntityManager();
            try {
                Movie movie = em.find(Movie.class, id);
                if (movie != null) {
                    em.getTransaction().begin();
                    em.remove(movie);
                    em.getTransaction().commit();
                } else {
                    throw new IllegalArgumentException("Movie with ID " + id + " not found.");
                }
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw e;
            } finally {
                em.close();
            }
        }

    @Override
    public List<MovieDTO> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m", Movie.class);
            return query.getResultList().stream().map(MovieDTO::new).toList();
        }
    }

    @Override
    public MovieDTO getById(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Movie.class, id) != null ? new MovieDTO(em.find(Movie.class, id)) : null;
        }
    }
}
