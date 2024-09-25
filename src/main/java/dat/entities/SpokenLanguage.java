package dat.entities;

import dat.dtos.SpokenLanguageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "spoken_languages")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpokenLanguage {

    @Id
    private String iso6391;
    private String englishName;
    private String name;

    public SpokenLanguage(SpokenLanguageDTO dto) {
        this.iso6391 = dto.getIso6391();
        this.englishName = dto.getEnglishName();
        this.name = dto.getName();
    }
}
