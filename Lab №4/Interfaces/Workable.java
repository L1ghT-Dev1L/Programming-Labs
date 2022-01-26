package Interfaces;

import Abstracts.Animal;

public interface Workable {
    boolean needToWork(Animal... args);

    void work(Animal... args);
}
