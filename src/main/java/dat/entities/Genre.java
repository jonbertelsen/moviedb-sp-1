package dat.entities;

import dat.dtos.GenreDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

    @Id
    private int id;
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies = new ArrayList<>();

    public Genre(GenreDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }
}
