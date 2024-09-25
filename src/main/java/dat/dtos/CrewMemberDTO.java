package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.entities.CrewMember;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrewMemberDTO {
    @JsonIgnore
    private int id;
    @JsonProperty("id")
    private int crewId;
    private boolean adult;
    private int gender;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    private String name;
    @JsonProperty("original_name")
    private String originalName;
    private double popularity;
    @JsonProperty("profile_path")
    private String profilePath;
    @JsonProperty("credit_id")
    private String creditId;
    private String department;
    private String job;

    public CrewMemberDTO(CrewMember crewMember) {
        this.id = crewMember.getId();
        this.crewId = crewMember.getCrewId();
        this.adult = crewMember.isAdult();
        this.gender = crewMember.getGender();
        this.knownForDepartment = crewMember.getKnownForDepartment();
        this.name = crewMember.getName();
        this.originalName = crewMember.getOriginalName();
        this.popularity = crewMember.getPopularity();
        this.profilePath = crewMember.getProfilePath();
        this.creditId = crewMember.getCreditId();
        this.department = crewMember.getDepartment();
        this.job = crewMember.getJob();
    }
}
