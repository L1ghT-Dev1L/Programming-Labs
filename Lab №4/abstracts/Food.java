package abstracts;

import exceptions.ImpossibleCountException;

public abstract class Food extends Item {

    public Food(String name, int count) {
        super(name, count);
    }

    @Override
    public void beUsed(Animal hero) {
        System.out.printf("%s съедает %s.\n", hero.getName(), super.getName().toLowerCase());
        hero.setHungerFeel(false);
        try {
            super.setCount(super.getCount() - 1);
        }
        catch (ImpossibleCountException e) {
            hero.removeItem(this);
        }
    }

}
