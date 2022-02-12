package characters;

import abstracts.Animal;
import abstracts.Item;
import exceptions.ImpossibleSituationException;
import interfaces.Itemize;
import interfaces.Walkable;
import items.Clothes;
import properties.Ingredients;
import properties.Mood;
import properties.Position;

public class Roo extends Animal implements Walkable {

    public Roo(String name, Mood mood, Ingredients preference, boolean hungry) {
        super(name, mood, preference, hungry);
    }

    public Item getNecessaryItem() {
        Item apron = new Clothes(1) {
            @Override
            public String toString() {
                return String.format("Передник Ру");
            }
        };
        return apron;
    }

    @Override
    public boolean haveEnoughItems() {
        Item necessaryItem = new Clothes(1);
        if (this.getItem(necessaryItem) != null) {
            Item backpackItem = (Item) this.getItem(necessaryItem);
            return backpackItem.getCount() > 2;
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
