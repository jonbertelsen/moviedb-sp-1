package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.entities.Credits;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditsDTO {
    @JsonProperty("cast")
    private List<CastMemberDTO> cast;
    @JsonProperty("crew")
    private List<CrewMemberDTO> crew;

    public CreditsDTO(Credits credits) {
        this.cast = credits.getCast() != null ? credits
                .getCast()
                .stream()
                .map(CastMemberDTO::new)
                .collect(Collectors.toList()) : null;
        this.crew = credits.getCrew() != null ? credits
                .getCrew()
                .stream()
                .map(CrewMemberDTO::new)
                .collect(Collectors.toList()) : null;
    }
}
