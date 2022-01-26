package Items;

import Abstracts.Animal;
import Abstracts.HygieneSupplies;

public class Napkin extends HygieneSupplies {

    public Napkin(int count) {
        super("Салфетки", count);
    }

    public void beUsed(Animal hero) {
        System.out.printf("%s использует салфетку\n", hero.getName());
        hero.usedItem(this);
    }

}
