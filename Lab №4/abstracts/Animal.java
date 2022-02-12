package abstracts;

import exceptions.NullOrEmptyStringException;
import interfaces.Describable;
import interfaces.Itemize;
import properties.Cleanness;
import properties.Mood;
import properties.Ingredients;
import properties.Position;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Animal {

    private final String name;
    private boolean hungry;
    private final Describable mood;
    private final Describable preference;
    private ArrayList<Itemize> backpack = new ArrayList<>();
    private final GravityPosition heroPosition = new GravityPosition(Position.STAY);
    public Ears ears = new Ears(Cleanness.CLEAN);

    public Animal(String name, Mood mood, Ingredients preference, boolean hungry) {

        if (name != null && !name.equals("")) {
            this.name = name;
        }
        else {
            throw new NullOrEmptyStringException("Animal's name can't be null or empty string");
        }

        if (mood != null) {
            this.mood = mood;
        }
        else {
            throw new NullPointerException("Mood can't be null");
        }

        if (preference != null) {
            this.preference = preference;
        }
        else {
            throw new NullPointerException("Preference can't be null");
        }

        this.hungry = hungry;
    }

    private static class GravityPosition {

        private Describable position;

        private GravityPosition(Position position) {
            if (position != null) {
                this.position = position;
            }
            else {
                throw new NullPointerException("Position can't be null");
            }
        }

        private Describable getPosition() {
            return position;
        }

        public void setPosition(Position newPosition) throws NullPointerException {
            if (newPosition != null) {
                position = newPosition;
            }
            else {
                throw new NullPointerException("Position can't be null");
            }
        }
    }

    public class Ears implements Describable {

        private Describable status;

        public Ears(Cleanness status) throws NullPointerException {
            if (status != null) {
                this.status = status;
            }
            else {
                throw new NullPointerException("Cleanness status of ears can't be null");
            }
        }

        public Describable getStatus() {
            return status;
        }

        public void setStatus(Cleanness newStatus) throws NullPointerException {
            if (newStatus != null) {
                this.status = newStatus;
            }
            else {
                throw new NullPointerException("Cleanness status of ears can't be null");
            }
        }

        public String getDescription() {
            return String.format("У %s " + status.getDescription() + " уши.\n", name);
        }
    }

    public String getName() {
        return name;
    }

    public Describable getMood() {
        return mood;
    }

    public Describable getPreference() {
        return preference;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungerFeel(boolean hungry) {
        this.hungry = hungry;
    }

    public void addItem(Item newItem) throws NullPointerException {
        if (newItem != null) {
            backpack.add(newItem);
        }
        else {
            throw new NullPointerException("Item can't be null");
        }
    }

    public void removeItem(Item itemToRemove) throws NullPointerException {
        if (itemToRemove != null) {
            backpack.remove(itemToRemove);
        }
        else {
            throw new NullPointerException("Item to remove can't be null");
        }
    }

    public Itemize getItem(Itemize necessaryItem) {
        for (Itemize item : backpack) {
            if (necessaryItem.equals(item)) {
                return item;
            }
        }
        return null;
    }

    public abstract Itemize getNecessaryItem();

    public boolean haveItem(Itemize item) {
        if (item != null) {
            for (Itemize backpackItem : backpack) {
                if (item.equals(backpackItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setHeroPosition(Position newPosition) {
        try {
            heroPosition.setPosition(newPosition);
        }
        catch (NullPointerException e) {
            heroPosition.setPosition(Position.STAY);
        }
    }

    public Describable getHeroPosition() {
        return heroPosition.getPosition();
    }

    public abstract boolean haveEnoughItems();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mood, hungry, preference, heroPosition.getPosition(), backpack);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal other = (Animal) obj;
        return name.equals(other.name) && hungry == other.hungry && mood == other.mood
                && preference == other.preference && heroPosition.getPosition() == other.heroPosition.getPosition();
    }

}
