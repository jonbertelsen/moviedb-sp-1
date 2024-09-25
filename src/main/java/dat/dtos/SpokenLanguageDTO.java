package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.entities.SpokenLanguage;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpokenLanguageDTO {
    @JsonProperty("english_name")
    private String englishName;
    @JsonProperty("iso_639_1")
    private String iso6391;
    private String name;

    public SpokenLanguageDTO(SpokenLanguage spokenLanguage) {
        this.englishName = spokenLanguage.getEnglishName();
        this.iso6391 = spokenLanguage.getIso6391();
        this.name = spokenLanguage.getName();
    }
}
