package dat.entities;

import dat.dtos.MovieDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "movies")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private Integer id;
    private String imdbId;
    private boolean adult;
    private String backdropPath;
    private int budget;
    private String homepage;
    private String originalLanguage;
    private String originalTitle;
    @Column(length = 1000)
    private String overview;
    private double popularity;
    private String posterPath;
    private String releaseDate;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double voteAverage;
    private int voteCount;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> originCountry;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    @Transient
    private List<SpokenLanguage> spokenLanguages;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    private List<ProductionCompany> productionCompanies;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    private List<ProductionCountry> productionCountries;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movie_id")
    private List<Genre> genres =  new ArrayList<>();;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "credits_id")

    private Credits credits;

    private void addGenre(Genre genre) {
        if (genre != null) {
            this.genres.add(genre);
            genre.getMovies().add(this);
        } else
            genres = new ArrayList<>();
    }

    public Movie(MovieDTO dto) {
        this.id = dto.getId();
        this.imdbId = dto.getImdbId();
        this.adult = dto.isAdult();
        this.backdropPath = dto.getBackdropPath();
        this.budget = dto.getBudget();
        this.homepage = dto.getHomepage();
        this.originalLanguage = dto.getOriginalLanguage();
        this.originalTitle = dto.getOriginalTitle();
        this.overview = dto.getOverview();
        this.popularity = dto.getPopularity();
        this.posterPath = dto.getPosterPath();
        this.releaseDate = dto.getReleaseDate();
        this.revenue = dto.getRevenue();
        this.runtime = dto.getRuntime();
        this.status = dto.getStatus();
        this.tagline = dto.getTagline();
        this.title = dto.getTitle();
        this.video = dto.isVideo();
        this.voteAverage = dto.getVoteAverage();
        this.voteCount = dto.getVoteCount();
        this.originCountry = dto.getOriginCountry();
        dto.getGenres().forEach(genreDTO -> addGenre(new Genre(genreDTO)));
        this.credits = dto.getCredits() != null ? new Credits(dto.getCredits()) : null;
        this.spokenLanguages = dto.getSpokenLanguages() != null ? dto
                .getSpokenLanguages()
                .stream()
                .map(SpokenLanguage::new)
                .collect(Collectors.toList()) : null;
        this.productionCompanies = dto.getProductionCompanies() != null ? dto
                .getProductionCompanies()
                .stream()
                .map(ProductionCompany::new)
                .collect(Collectors.toList()) : null;
        this.productionCountries = dto.getProductionCountries() != null ? dto
                .getProductionCountries()
                .stream()
                .map(ProductionCountry::new)
                .collect(Collectors.toList()) : null;

    }
}
