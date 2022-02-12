package abstracts;

import exceptions.ImpossibleCountException;
import exceptions.NullOrEmptyStringException;
import interfaces.Itemize;

import java.util.Objects;

public abstract class Item implements Itemize {

    private final String name;
    private int count;

    public Item(String name, int count) throws NullOrEmptyStringException, ImpossibleCountException {
        if (name != null && !name.equals("")) {
            this.name = name;
        }
        else {
            throw new NullOrEmptyStringException("Item's name can't be null or empty string");
        }

        if (count >= 1) {
            this.count = count;
        }
        else {
            throw new ImpossibleCountException("Item's count can't be negative or equals to zero");
        }
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int newCount) throws ImpossibleCountException {
        if(newCount >= 1) {
            this.count = newCount;
        }
        else {
            throw new ImpossibleCountException("Item's count can't be negative or equals to zero");
        }
    }

    public void beUsed(Animal hero) {
        System.out.printf("%s использует предмет %s.\n", hero.getName(), this.name.toLowerCase());
        try {
            setCount(getCount() - 1);
        }
        catch (ImpossibleCountException e) {
            hero.removeItem(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Предмет %s", name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        return name.equals(other.name);
    }

}
