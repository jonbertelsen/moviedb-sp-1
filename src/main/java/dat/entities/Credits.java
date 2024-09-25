package dat.entities;

import dat.dtos.CreditsDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "credits")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cast_id")
    private List<CastMember> cast;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "crew_id")
    private List<CrewMember> crew;

    @OneToOne(mappedBy = "credits")
    private Movie movie;

    public Credits(CreditsDTO dto) {
        if (dto.getCast() != null) {
            this.cast = dto
                    .getCast()
                    .stream()
                    .map(CastMember::new)
                    .collect(Collectors.toList());
        } else {
            this.cast = null;
        }

        if (dto.getCrew() != null) {
            this.crew = dto
                    .getCrew()
                    .stream()
                    .map(CrewMember::new)
                    .collect(Collectors.toList());
        } else {
            this.crew = null;
        }
    }
}
