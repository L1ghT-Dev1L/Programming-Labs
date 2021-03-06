package characters;

import abstracts.Animal;
import abstracts.Item;
import exceptions.ImpossibleSituationException;
import interfaces.Itemize;
import interfaces.Walkable;
import items.Napkin;
import properties.Cleanness;
import properties.Ingredients;
import properties.Mood;
import properties.Position;

public class Tiger extends Animal implements Walkable {

    public Tiger(String name, Mood mood, Ingredients preference, boolean hungry) {
        super(name, mood, preference, hungry);
    }

    private void jump(Animal otherHero) {
        this.setHeroPosition(Position.IN_AIR);
        System.out.printf("%s подпрыгнул от радости, но при приземлении задел %s.\n", super.getName(), otherHero.getName());
        this.setHeroPosition(Position.STAY);
        otherHero.setHeroPosition(Position.FALL);
        otherHero.ears.setStatus(Cleanness.DIRTY);
    }

    public void greeting(Animal otherHero) {
        System.out.printf("%s поприветствовал %s.\n", super.getName(), otherHero.getName());
        jump(otherHero);
    }

    public Item getNecessaryItem() {
        return new Napkin(1);
    }

    @Override
    public boolean haveEnoughItems() {
        Item necessaryItem = new Napkin(1);
        if (this.getItem(necessaryItem) != null) {
            Item backpackItem = (Item) this.getItem(necessaryItem);
            return backpackItem.getCount() > 3;
        }
        return false;
    }

    @Override
    public boolean readyToWalk()  throws ImpossibleSituationException{
        if (this.getHeroPosition() != Position.STAY) {
            throw new ImpossibleSituationException(String.format("%s не может ходить, если не находится в положении стоя.\n", getName()));
        }
        return isHungry();
    }

    @Override
    public void walk() {
        System.out.printf("%s пошёл гулять.\n", super.getName());
    }

}
