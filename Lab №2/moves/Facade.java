package moves;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        Status def_stat = def.getCondition();
        if (def_stat == Status.BURN || def_stat == Status.POISON || def_stat == Status.PARALYZE) {
            super.applyOppDamage(def, 2 * damage);
        } else {
            super.applyOppDamage(def, damage);
        }
    }

    @Override
    protected String describe() {
        return ("Использует Facade");
    }
}
