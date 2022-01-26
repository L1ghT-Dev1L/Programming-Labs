package Items;

import Abstracts.Item;

public class Clothes extends Item {

    public Clothes(int count) {
        super("Одежда", count);
    }

    @Override
    public String toString() {
        return super.getName();
    }

}
