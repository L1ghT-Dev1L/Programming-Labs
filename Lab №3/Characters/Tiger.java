package ThirdLab.Characters;

import ThirdLab.Abstracts.Animal;
import ThirdLab.Abstracts.Item;
import ThirdLab.Interfaces.Countable;
import ThirdLab.Interfaces.Walkable;
import ThirdLab.Items.Napkin;
import ThirdLab.Properties.Ingredients;
import ThirdLab.Properties.Mood;

public class Tiger extends Animal implements Walkable, Countable {

    public Tiger() {
        super("Тигра", Mood.NORMAL, Ingredients.FISH_OIL, false);
    }

    public Tiger(String name, Mood mood, Ingredients preference, boolean isHungry) {
        super(name, mood, preference, isHungry);
    }

    @Override
    public Item necessaryThing() {
        return new Napkin(1);
    }

    @Override
    public boolean readyToWalk() {
        return !super.isHungry();
    }

    @Override
    public boolean haveEnoughThing() {
        if (getItem(necessaryThing()) != null) {
            return !(getItem(necessaryThing()).getCount() < 4);
        }
        return false;
    }

    @Override
    public void walk() {
        System.out.printf("%s пошёл гулять.\n", super.getName());
    }
}
