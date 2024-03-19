package culture.learning.ci.entities.dtos;

import culture.learning.ci.entities.Ingredient;
import culture.learning.ci.entities.enumerations.ValueUnit;

/**
 * The quantity of ingredient which need to prepare the drinking or food
 *
 * @param description how to prepare
 * @param ingredient  {@link Ingredient}
 * @param value       the value of ingredient
 * @param valueUnit   the measure unit
 */
public record CompositionIngredientDto(String description, Ingredient ingredient, Double value, ValueUnit valueUnit,
                                       boolean isPrivate) {
}
