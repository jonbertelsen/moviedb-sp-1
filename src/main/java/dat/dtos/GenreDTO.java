package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dat.entities.Genre;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDTO {
    private int id;
    private String name;

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
    }
}
