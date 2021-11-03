package pokemons;
import moves.*;
import ru.ifmo.se.pokemon.*;

public class Crobat extends Pokemon {
    public Crobat(String name, int level) {
        super(name, level);
        setType(Type.POISON, Type.FLYING);
        setStats(85, 90, 80, 70, 80, 130);
        setMove(new Rest(), new DoubleTeam(), new WorkUp(), new Blizzard());
    }
}
