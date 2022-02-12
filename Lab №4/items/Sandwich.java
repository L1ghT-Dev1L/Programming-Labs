package items;

import abstracts.Food;
import interfaces.Describable;
import properties.Ingredients;

import java.util.Objects;

public class Sandwich extends Food {

    private final Describable mainIngredient;

    public Sandwich(int count, Ingredients mainIngredient) throws NullPointerException {
        super("Бутерброд", count);
        if (mainIngredient != null) {
            this.mainIngredient = mainIngredient;
        }
        else {
            throw new NullPointerException("Main ingredient in sandwich can't be null");
        }
    }

    @Override
    public String toString() {
        return String.format("%s с главным ингредиентом %s", super.getName(), mainIngredient.getDescription());
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
        return Objects.hash(getName(), getCount(), mainIngredient);
    }
}