package dat.entities;

import dat.dtos.CastMemberDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cast_member")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CastMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int castId;
    private boolean adult;
    private int gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private double popularity;
    private String profilePath;
    private String character;
    private String creditId;
    private int orderNo;
    @ManyToMany(mappedBy = "cast")
    private List<Credits> credits;

    public CastMember(CastMemberDTO dto) {
        this.id = dto.getId();
        this.castId = dto.getCastId();
        this.adult = dto.isAdult();
        this.gender = dto.getGender();
        this.knownForDepartment = dto.getKnownForDepartment();
        this.name = dto.getName();
        this.originalName = dto.getOriginalName();
        this.popularity = dto.getPopularity();
        this.profilePath = dto.getProfilePath();
        this.character = dto.getCharacter();
        this.creditId = dto.getCreditId();
        this.orderNo = dto.getOrder();
    }
}

