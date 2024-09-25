package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.entities.ProductionCountry;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionCountryDTO {
    @JsonProperty("iso_3166_1")
    private String iso31661;
    private String name;

    public ProductionCountryDTO(ProductionCountry productionCountry) {
        this.iso31661 = productionCountry.getIso31661();
        this.name = productionCountry.getName();
    }
}
