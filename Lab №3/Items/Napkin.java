package ThirdLab.Items;

import ThirdLab.Abstracts.Animal;
import ThirdLab.Abstracts.HygieneSupplies;

public class Napkin extends HygieneSupplies {

    public Napkin(int count) {
        super("Салфетки", count);
    }

    public void beUsed(Animal hero) {
        System.out.printf("%s использует салфетку\n", hero.getName());
        hero.usedItem(this);
    }

}
