package dat.entities;

import dat.dtos.ProductionCountryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "production_country")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionCountry {

    @Id
    private String iso31661;
    private String name;

    public ProductionCountry(ProductionCountryDTO dto) {
        this.iso31661 = dto.getIso31661();
        this.name = dto.getName();
    }
}
