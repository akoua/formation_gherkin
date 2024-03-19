package culture.learning.ci.service;

import culture.learning.ci.entities.IConsommable;
import culture.learning.ci.entities.Ingredient;

import java.util.List;

public interface IComposition<T extends IConsommable> {

    T mix(List<? extends Ingredient> ingredients);

    T pound(List<? extends Ingredient> ingredients);

    T crush(List<? extends Ingredient> ingredients);

}
