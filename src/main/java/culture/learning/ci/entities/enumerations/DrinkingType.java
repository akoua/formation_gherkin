package culture.learning.ci.entities.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DrinkingType {
    BISSAP(true),
    GINGEMBRE(true),
    FRUIT_DE_PASSATION(true);

    private final boolean isAfrican;
}
