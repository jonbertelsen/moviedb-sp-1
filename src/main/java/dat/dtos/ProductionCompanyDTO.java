package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.entities.ProductionCompany;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionCompanyDTO {
    private int id;
    @JsonProperty("logo_path")
    private String logoPath;
    private String name;
    @JsonProperty("origin_country")
    private String originCountry;

    public ProductionCompanyDTO(ProductionCompany productionCompany) {
        this.id = productionCompany.getId();
        this.logoPath = productionCompany.getLogoPath();
        this.name = productionCompany.getName();
        this.originCountry = productionCompany.getOriginCountry();
    }
}
