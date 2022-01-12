package ThirdLab.Interfaces;

import ThirdLab.Abstracts.Animal;

public interface Workable {
    boolean needToWork(Animal... args);

    void work(Animal... args);
}
