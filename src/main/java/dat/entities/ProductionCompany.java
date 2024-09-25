package dat.entities;

import dat.dtos.ProductionCompanyDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "production_company")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionCompany {

    @Id
    private int id;
    private String logoPath;
    private String name;
    private String originCountry;

    public ProductionCompany(ProductionCompanyDTO dto) {
        this.id = dto.getId();
        this.logoPath = dto.getLogoPath();
        this.name = dto.getName();
        this.originCountry = dto.getOriginCountry();
    }
}
