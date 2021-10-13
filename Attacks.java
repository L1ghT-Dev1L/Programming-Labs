package com.company.SecondLab;
import ru.ifmo.se.pokemon.*;

class SeedBomb extends PhysicalMove{
    SeedBomb(){
        super(Type.GRASS, 80.0, 1.0);
    }
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }
    protected String describe() {
        return ("Использует Seed Bomb");
    }
}

class Facade extends PhysicalMove{
    Facade(){
        super(Type.NORMAL, 70.0, 1.0);
    }
    protected void applyOppDamage(Pokemon def, double damage) {
        if(def.getCondition() == Status.BURN || def.getCondition() == Status.POISON || def.getCondition() == Status.PARALYZE){
            def.setMod(Stat.HP, (int) (2 * Math.round(damage)));
        }
        else{
            def.setMod(Stat.HP, (int) Math.round(damage));
        }
    }
    protected String describe() {
        return ("Использует Facade");
    }
}

class ThunderPunch extends PhysicalMove{
    ThunderPunch(){
        super(Type.ELECTRIC, 75.0, 1.0);
    }
    protected void applyOppEffects(Pokemon def) {
        Effect ParrEff = new Effect().chance(0.1);
        if(ParrEff.success()) {Effect.paralyze(def);}
    }
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }
    protected String describe() {
        return ("Использует Thunder punch");
    }
}

class Psychic extends SpecialMove{
    Psychic(){
        super(Type.PSYCHIC, 90.0, 1.0);
    }
    protected void applyOppEffects(Pokemon def) {
        Effect LowSpDefense = new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, -1);
        if(LowSpDefense.success()) {def.addEffect(LowSpDefense);}
    }
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }
    protected String describe() {
        return ("Использует Psychic");
    }
}

class Confide extends StatusMove{
    Confide(){
        super(Type.NORMAL, 0.0, 0.0);
    }
    protected void applyOppEffects(Pokemon def) {
        Effect LowSpAttack = new Effect().chance(1.0).stat(Stat.SPECIAL_ATTACK, -1);
        if(LowSpAttack.success()) {def.addEffect(LowSpAttack);}
    }
    protected String describe() {
        return ("Использует Confide");
    }
}

class DoubleTeam extends StatusMove{
    DoubleTeam(){
        super(Type.NORMAL, 0.0, 0.0);
    }
    protected void applySelfEffects(Pokemon self) {
        Effect EvBuff = new Effect().chance(1.0).stat(Stat.EVASION, 1);
        if(EvBuff.success()) {self.addEffect(EvBuff);}
    }
    protected String describe() {
        return ("Использует Double Team");
    }
}

class Swagger extends StatusMove{
    Swagger(){
        super(Type.NORMAL, 0.0, 0.85);
    }
    protected void applyOppEffects(Pokemon def) {
        def.confuse();
    }
    protected void applySelfEffects(Pokemon self) {
        Effect AttackBuff = new Effect().chance(1.0).stat(Stat.ATTACK, 2);
        self.addEffect(AttackBuff);
    }
}

class WorkUp extends StatusMove{
    WorkUp(){
        super(Type.NORMAL, 0.0, 0.0);
    }
    protected void applySelfEffects(Pokemon self){
        Effect AttackBuff = new Effect().chance(1.0).stat(Stat.ATTACK, 1);
        Effect SpAttackBuff = new Effect().chance(1.0).stat(Stat.SPECIAL_ATTACK, 1);
        self.addEffect(AttackBuff);
        self.addEffect(SpAttackBuff);
    }
}

class Bite extends PhysicalMove{
    Bite(){
        super(Type.DARK, 60.0, 1.0);
    }
    protected void applyOppEffects(Pokemon def) {
        Effect flinching = new Effect().chance(0.3);
        if(flinching.success()) {Effect.flinch(def);}
    }
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }
}

class Smokescreen extends StatusMove{
    Smokescreen(){
        super(Type.NORMAL, 0.0, 0.0);
    }
    protected void applyOppEffects(Pokemon def) {
        Effect LowAcc = new Effect().chance(1.0).stat(Stat.ACCURACY, -1);
        if(LowAcc.success()) {def.addEffect(LowAcc);}
    }
}
