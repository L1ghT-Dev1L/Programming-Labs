package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Leafeon extends Pokemon {
    public Leafeon(String name, int level) {
        super(name, level);
        addType(Type.GRASS);
        setStats(65, 110, 130, 60, 65, 95);
        setMove(new Facade(), new Rest(), new Confide(), new Thunderbolt());
    }
}
