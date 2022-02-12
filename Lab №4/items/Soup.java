package items;

import abstracts.Animal;
import abstracts.Food;
import abstracts.Item;
import exceptions.ImpossibleCountException;
import exceptions.ImpossibleSituationException;

public class Soup extends Item {

    public Soup(int count) {
        super("Мыло", count);
    }

    private String clear(Item item) throws ImpossibleSituationException {
        if (item instanceof Food) {
            throw new ImpossibleSituationException("Использовать мыло для еды невозможно");
        }
        else {
            return String.format("использует %s для очистки %s.\n", super.getName(), item.getName());
        }
    }

    public void beUsed(Animal hero, Item item) {
        try {
            System.out.printf("%s " + clear(item), hero.getName());
        }
        catch (ImpossibleSituationException e) {
            System.out.println("Для чего использовать мыло вместе с едой?");
        }

        try {
            setCount(getCount() - 1);
        }
        catch (ImpossibleCountException e) {
            hero.removeItem(this);
        }
    }

}
