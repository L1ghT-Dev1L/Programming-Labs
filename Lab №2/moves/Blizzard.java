package moves;
import ru.ifmo.se.pokemon.*;

public class Blizzard extends SpecialMove{
    public Blizzard() { super(Type.ICE, 110, 0.7); }

    @Override
    protected void applyOppEffects(Pokemon def) {
        if(Math.random() < 0.1){
            Effect.freeze(def);
        }
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);
    }

    @Override
    protected String describe() { return "использует Blizzard"; }
}
