package culture.learning.ci.entities;

import culture.learning.ci.entities.enumerations.ValueUnit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ingredient_id"))
public class Ingredient extends Auditable {

    private String item;
    private String description;
    private Double value;
    @Enumerated(EnumType.STRING)
    private ValueUnit valueUnit;
    private Double price;
}
