package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {
    private int id;
    @JsonProperty("imdb_id")
    private String imdbId;
    private boolean adult;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    private int budget;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    private String overview;
    private double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("release_date")
    private String releaseDate;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;
    @JsonProperty("origin_country")
    private List<String> originCountry;
    @JsonProperty("spoken_languages")
    private List<SpokenLanguageDTO> spokenLanguages;
    @JsonProperty("production_companies")
    private List<ProductionCompanyDTO> productionCompanies;
    @JsonProperty("production_countries")
    private List<ProductionCountryDTO> productionCountries;
    @JsonProperty("genres")
    private List<GenreDTO> genres;
    @JsonProperty("credits")
    private CreditsDTO credits;

    public MovieDTO(dat.entities.Movie movie) {
        this.id = movie.getId();
        this.imdbId = movie.getImdbId();
        this.adult = movie.isAdult();
        this.backdropPath = movie.getBackdropPath();
        this.budget = movie.getBudget();
        this.homepage = movie.getHomepage();
        this.originalLanguage = movie.getOriginalLanguage();
        this.originalTitle = movie.getOriginalTitle();
        this.overview = movie.getOverview();
        this.popularity = movie.getPopularity();
        this.posterPath = movie.getPosterPath();
        this.releaseDate = movie.getReleaseDate();
        this.revenue = movie.getRevenue();
        this.runtime = movie.getRuntime();
        this.status = movie.getStatus();
        this.tagline = movie.getTagline();
        this.title = movie.getTitle();
        this.video = movie.isVideo();
        this.voteAverage = movie.getVoteAverage();
        this.voteCount = movie.getVoteCount();
        this.originCountry = movie.getOriginCountry();
        this.spokenLanguages = movie.getSpokenLanguages() != null ? movie
                .getSpokenLanguages()
                .stream()
                .map(SpokenLanguageDTO::new)
                .collect(java.util.stream.Collectors.toList()) : null;
        this.productionCompanies = movie.getProductionCompanies() != null ? movie
                .getProductionCompanies()
                .stream()
                .map(ProductionCompanyDTO::new)
                .collect(java.util.stream.Collectors.toList()) : null;
        this.productionCountries = movie.getProductionCountries() != null ? movie
                .getProductionCountries()
                .stream()
                .map(ProductionCountryDTO::new)
                .collect(java.util.stream.Collectors.toList()) : null;
        this.genres = movie.getGenres() != null ? movie
                .getGenres()
                .stream()
                .map(GenreDTO::new)
                .collect(java.util.stream.Collectors.toList()) : null;
        this.credits = movie.getCredits() != null ? new CreditsDTO(movie.getCredits()) : null;
    }
}
