package interfaces;

import exceptions.ImpossibleSituationException;

public interface Walkable {
    boolean readyToWalk() throws ImpossibleSituationException;
    void walk();
}
