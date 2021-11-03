package pokemons;
import moves.*;
import ru.ifmo.se.pokemon.*;

public class HoopaConfined extends Pokemon {
    public HoopaConfined(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC, Type.GHOST);
        setStats(80, 110, 60, 150, 130, 70);
        setMove(new Rest(), new DefenseCurl(), new Flamethrower(), new Thunderbolt());
    }
}