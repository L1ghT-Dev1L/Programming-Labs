package items;

import abstracts.Animal;
import abstracts.Item;
import properties.Cleanness;

public class Napkin extends Item {

    public Napkin(int count) {
        super("Салфетка", count);
    }

    @Override
    public void beUsed(Animal hero) {
        super.beUsed(hero);
        hero.ears.setStatus(Cleanness.CLEAN);
    }

    @Override
    public String toString() {
        return getName();
    }

}
