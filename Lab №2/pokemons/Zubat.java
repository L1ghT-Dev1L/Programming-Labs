package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Zubat extends Pokemon {
    public Zubat(String name, int level) {
        super(name, level);
        setType(Type.POISON, Type.FLYING);
        setStats(40, 45, 35, 30, 40, 55);
        setMove(new Rest(), new DoubleTeam());
    }
}
