package dat.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import dat.dtos.CrewMemberDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "crew_member")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrewMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int crewId;
    private boolean adult;
    private int gender;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    private String name;
    @JsonProperty("original_name")
    private String originalName;
    private double popularity;
    private String profilePath;
    private String creditId;
    private String department;
    private String job;
    @ManyToMany(mappedBy = "crew")
    private List<Credits> credits;

    public CrewMember(CrewMemberDTO dto) {
        this.id = dto.getId();
        this.crewId = dto.getCrewId();
        this.adult = dto.isAdult();
        this.gender = dto.getGender();
        this.knownForDepartment = dto.getKnownForDepartment();
        this.name = dto.getName();
        this.originalName = dto.getOriginalName();
        this.popularity = dto.getPopularity();
        this.profilePath = dto.getProfilePath();
        this.creditId = dto.getCreditId();
        this.department = dto.getDepartment();
        this.job = dto.getJob();

    }
}
