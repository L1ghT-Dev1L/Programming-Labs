package ThirdLab.Items;

import ThirdLab.Abstracts.Food;
import ThirdLab.Properties.Ingredients;

public class Sandwich extends Food {

    private final Ingredients mainIngredient;

    public Sandwich(int count, Ingredients mainIngredient) {
        super("Бутерброд", count);
        this.mainIngredient = mainIngredient;
    }

    public Sandwich(int count) {
        super("Бутерброд", count);
        mainIngredient = null;
    }

    @Override
    public String toString() {
        if (mainIngredient != null) {
            Ingredients mainIngredient = Enum.valueOf(Ingredients.class, this.mainIngredient.toString());
            return String.format("%s с главным ингредиентом %s", super.getName().toLowerCase(), mainIngredient.getPreference());
        }
        return String.format("просто %s", super.getName().toLowerCase());
    }

}
