package culture.learning.ci.entities.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValueUnit {
    LITER(true, false, false),
    GRAM(false, true, false),
    METER(false, false, true);

    private final boolean isCapacity;
    private final boolean isMass;
    private final boolean isLength;

}
