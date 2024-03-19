package culture.learning.ci.entities;

import culture.learning.ci.entities.dtos.CompositionIngredientDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "composition_id"))
public class Composition extends Auditable {
    private String description;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Drinking.class)
    private Drinking drinking;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "preparation")
    private List<CompositionIngredientDto> preparation;
}
