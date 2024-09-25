package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.entities.CastMember;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CastMemberDTO {
    @JsonIgnore
    private int id;
    @JsonProperty("id")
    private int castId;
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
    private String character;
    @JsonProperty("credit_id")
    private String creditId;
    @JsonProperty("order")
    private int order;

    public CastMemberDTO(CastMember castMember) {
        this.id = castMember.getId();
        this.castId = castMember.getCastId();
        this.adult = castMember.isAdult();
        this.gender = castMember.getGender();
        this.knownForDepartment = castMember.getKnownForDepartment();
        this.name = castMember.getName();
        this.originalName = castMember.getOriginalName();
        this.popularity = castMember.getPopularity();
        this.profilePath = castMember.getProfilePath();
        this.character = castMember.getCharacter();
        this.creditId = castMember.getCreditId();
        this.order = castMember.getOrderNo();
    }

}
