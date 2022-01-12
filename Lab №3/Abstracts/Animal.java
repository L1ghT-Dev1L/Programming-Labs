package ThirdLab.Abstracts;

import ThirdLab.Interfaces.Countable;
import ThirdLab.Properties.Ingredients;
import ThirdLab.Properties.Mood;

import java.util.*;

public abstract class Animal implements Countable {

    private final String name;
    private Mood mood;
    private Ingredients preference;
    private boolean hungry;
    private List<Item> backpack = new ArrayList<>();

    public Animal(String name, Mood mood, Ingredients preference, boolean hungry) {
        this.name = name;
        this.mood = mood;
        this.preference = preference;
        this.hungry = hungry;
    }

    public String getName() {
        return name;
    }

    public void describeMood() {
        Mood feel = Enum.valueOf(Mood.class, this.mood.toString());
        System.out.printf("Сегодня у %s %s настроение\n", this.name, feel.getMood());
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
        if (currCount == 1) {
            backpack.remove(item);
        } else {
            item.setCount(currCount - 1);
        }
    }

    public void setHungerFeel(boolean hungerFeel) {
        this.hungry = hungerFeel;
    }

    public void addItem(Item thing) {
        backpack.add(thing);
    }

    public Item getItem(int index) {
        return backpack.get(index);
    }

    public int getSize() {
        return backpack.size();
    }

    public Item getItem(Item item) {
        for (int i = 0; i < getSize(); i++) {
            if (getItem(i).equals(item)) {
                return getItem(i);
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
