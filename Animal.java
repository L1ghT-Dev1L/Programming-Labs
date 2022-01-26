package Abstracts;

import Exceptions.ImpossibleCountException;
import Properties.Ingredients;
import Properties.Mood;
import Properties.Cleanness;
import Properties.Position;

import java.util.*;

public abstract class Animal {

    private final String name;
    private Mood mood;
    private Ingredients preference;
    private boolean hungry;
    private ArrayList<Item> backpack = new ArrayList<>();
    public Ears ears = new Ears(Cleanness.CLEAN);
    public GravityPosition gravityPosition = new GravityPosition(Position.STAY);

    public Animal(String name, Mood mood, Ingredients preference, boolean hungry) {
        this.name = name;
        this.mood = mood;
        this.preference = preference;
        this.hungry = hungry;
    }

    public class Ears {
        private Cleanness status;

        Ears(Cleanness status) {
            this.status = status;
        }

        public String description() {
            return String.format("у %s " + status.getDescription() + " уши.\n", name);
        }

        public void setStatus(Cleanness status) {
            this.status = status;
        }
    }

    public static class GravityPosition {
        private final Position position;

        GravityPosition(Position position) {
            this.position = position;
        }
        public Position getPosition() {
            return position;
        }
    }

    public void changeGravityPosition(Position position) {
        gravityPosition = new GravityPosition(position);
    }

    public String getName() {
        return name;
    }

    public void describeMood() {
        Mood feel = Enum.valueOf(Mood.class, this.mood.toString());
        System.out.printf("Сегодня у %s %s настроение\n", this.name, feel.getDescription());
    }

    public Mood getMood() {
        return mood;
    }

    public Ingredients getPreference() {
        return preference;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void eat(Food food) {
        System.out.printf("%s съедает один %s.\n", this.getName(), food.toString());
        food.makeNotHungry(this);
        usedItem(food);
    }

    public void usedItem(Item item) {
        int currCount = item.getCount();
        try {
            item.setCount(currCount - 1);
        }
        catch (ImpossibleCountException e) {
            this.backpack.remove(item);
        }
    }

    public void setHungerFeel(boolean hungerFeel) {
        this.hungry = hungerFeel;
    }

    public void addItem(Item thing) throws ImpossibleCountException {
        backpack.add(thing);
    }

    public void addItem(String name, int count, String description) {

        class BackpackItem extends Item {
            private final String description;

            BackpackItem(String name, int count, String description) {
                super(name, count);
                this.description = description;
            }

            String getDescription() {
                return description;
            }
        }

        BackpackItem newItem = new BackpackItem(name, count, description);
        backpack.add(newItem);

    }

    public Item getItem(int index) {
        return backpack.get(index);
    }

    public int getSize() {
        return backpack.size();
    }

    public Item getItem(Item item) {
        for (int i = 0; i < getSize(); i++) {
            if (backpack.get(i).equals(item)) {
                return backpack.get(i);
            }
        }
        return null;
    }

    public boolean contains(Item item) {
        for (int i = 0; i < this.getSize(); i++) {
            if (getItem(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void greeting(Animal otherHero) {
        System.out.printf("%s поприветствовал %s!\n", this.getName(), otherHero.getName());
    }

    abstract public Item necessaryThing();

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mood, preference, hungry, backpack);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Animal other = (Animal) otherObject;
        return name.equals(other.name) && mood == other.mood
                && preference == other.preference && hungry == other.hungry;
    }

}
