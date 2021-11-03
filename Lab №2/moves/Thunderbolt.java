package moves;
import ru.ifmo.se.pokemon.*;

public class Thunderbolt extends SpecialMove{
    public Thunderbolt() { super(Type.ELECTRIC, 90.0, 1.0); }

    @Override
    protected void applyOppEffects(Pokemon def) {
        if(Math.random() < 0.1){
            Effect.paralyze(def);
        }
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);
    }

    @Override
    protected String describe() { return "использует Thunderbolt"; }
}
