package ThirdLab.Characters;

import ThirdLab.Abstracts.Animal;
import ThirdLab.Abstracts.Item;
import ThirdLab.Interfaces.Walkable;
import ThirdLab.Interfaces.Countable;
import ThirdLab.Items.Clothes;
import ThirdLab.Properties.Ingredients;
import ThirdLab.Properties.Mood;

public class Roo extends Animal implements Walkable, Countable {

    public Roo() {
        super("Ру", Mood.NORMAL, Ingredients.SALAD, false);
    }

    public Roo(String name, Mood mood, Ingredients pref, boolean isHungry) {
        super(name, mood, pref, isHungry);
    }

    @Override
    public Item necessaryThing() {
        return new Clothes(1);
    }

    @Override
    public boolean readyToWalk() {
        return !super.isHungry();
    }

    @Override
    public void walk() {
        System.out.printf("%s пошёл гулять.\n", super.getName());
    }

    @Override
    public boolean haveEnoughThing() {
        return contains(new Clothes(1));
    }
}
