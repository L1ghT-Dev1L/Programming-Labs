package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Golbat extends Pokemon {
    public Golbat(String name, int level) {
        super(name, level);
        setType(Type.POISON, Type.FLYING);
        setStats(75, 80, 70, 65, 75, 90);
        setMove(new Rest(), new DoubleTeam(), new WorkUp());
    }
}
