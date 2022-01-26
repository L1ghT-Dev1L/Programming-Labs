package Items;

import Abstracts.Animal;
import Abstracts.HygieneSupplies;

public class Soup extends HygieneSupplies {

    public Soup(int count) {
        super("Мыло", count);
    }

    public void beUsed(Animal hero) {
        System.out.printf("%s использует %s\n", hero.getName(), super.getName().toLowerCase());
        hero.usedItem(this);
    }

}
