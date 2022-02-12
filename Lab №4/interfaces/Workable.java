package interfaces;

import abstracts.Animal;

public interface Workable {
    boolean needToWork(Animal... args);
    void work(Animal other);
}
