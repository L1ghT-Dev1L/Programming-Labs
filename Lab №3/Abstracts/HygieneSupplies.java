package ThirdLab.Abstracts;

public abstract class HygieneSupplies extends Item {

    public HygieneSupplies(String name, int count) {
        super(name, count);
    }

    public abstract void beUsed(Animal hero);
}
