package ThirdLab.Items;

import ThirdLab.Abstracts.Food;
import ThirdLab.Properties.Ingredients;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sandwich other = (Sandwich) obj;
        return super.getName().equals(other.getName()) && this.mainIngredient == other.mainIngredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), mainIngredient);
    }
}

