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

        class Apron extends Clothes {
            private final String description;

            Apron(int count, String description) {
                super(count);
                this.description = description;
            }

            @Override
            public String toString() {
                return description;
            }
        }

        return new Apron(1, "передник Ру");
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
