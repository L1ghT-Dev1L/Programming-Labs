package ThirdLab.Interfaces;

public interface Walkable {
    boolean readyToWalk();

    default void walk() {
        System.out.println("Кто-то пошёл гулять");
    }
}
