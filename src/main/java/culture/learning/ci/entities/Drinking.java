package culture.learning.ci.entities;

import culture.learning.ci.entities.enumerations.DrinkingType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "drinking_id"))
public class Drinking extends Auditable implements IConsommable {

    @Enumerated(EnumType.STRING)
    private DrinkingType drinkingType;
    private String description;

}
