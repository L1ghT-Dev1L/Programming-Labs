package items;

import abstracts.Animal;
import abstracts.Item;
import exceptions.ImpossibleCountException;

public class Clothes extends Item {

    public Clothes(int count) {
        super("Одежда", count);
    }

    @Override
    public void beUsed(Animal hero) {
        System.out.printf("%s меняет одежду на чистую.\n", hero.getName());
        try {
            setCount(getCount() - 1);
        }
        catch (ImpossibleCountException e) {
            hero.removeItem(this);
        }
    }

}
