package Characters;

import Abstracts.Animal;
import Abstracts.Item;
import Interfaces.Walkable;
import Items.Clothes;
import Properties.Ingredients;
import Properties.Mood;

public class Roo extends Animal implements Walkable {

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

}
