package moves;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon self) {
        Effect resting = new Effect().turns(2).chance(1.0);
        int hp = (int) self.getStat(Stat.HP);
        self.setMod(Stat.HP, hp);
        resting.sleep(self);
    }

    @Override
    protected String describe() {
        return "использует Rest";
    }
}
