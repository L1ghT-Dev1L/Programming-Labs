package ThirdLab.Abstracts;

public abstract class Food extends Item {

    public Food(String name, int count) {
        super(name, count);
    }

    public void makeNotHungry(Animal hero) {
        hero.setHungerFeel(false);
    }

    @Override
    public String toString() {
        return String.format("Еда %s", super.getName());
    }
}
