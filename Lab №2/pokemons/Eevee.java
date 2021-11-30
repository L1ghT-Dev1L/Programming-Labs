package pokemons;
import moves.*;
import ru.ifmo.se.pokemon.*;

public class Eevee extends Pokemon {
    public Eevee(String name, int level) {
        super(name, level);
        addType(Type.NORMAL);
        setStats(55, 55, 50, 45, 65, 55);
        setMove(new Facade(), new Rest(), new Confide());
    }
}
