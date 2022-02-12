package Characters;

import Abstracts.Animal;
import Abstracts.Item;
import Interfaces.Walkable;
import Items.Napkin;
import Properties.Cleanness;
import Properties.Ingredients;
import Properties.Mood;
import Properties.Position;

public class Tiger extends Animal implements Walkable {

    public Tiger() {
        super("Тигра", Mood.NORMAL, Ingredients.FISH_OIL, false);
    }

    public Tiger(String name, Mood mood, Ingredients preference, boolean isHungry) {
        super(name, mood, preference, isHungry);
    }

    @Override
    public void greeting(Animal hero) {
        super.greeting(hero);
        jump(hero);
    }

    public void jump(Animal hero) {
        System.out.printf("%s подпрыгнул от радости! Однако при приземлении он задел %s.\n", getName(), hero.getName());
        hero.ears.setStatus(Cleanness.DIRTY);
        hero.changeGravityPosition(Position.FALL);
        System.out.println(hero.getName() + " " + hero.gravityPosition.getPosition().getDescription());
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
    public void walk() {
        System.out.printf("%s пошёл гулять.\n", super.getName());
    }
}
