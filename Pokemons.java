package com.company.SecondLab;
import ru.ifmo.se.pokemon.*;

class Sigilyph extends Pokemon {
    Sigilyph(String name, int level){
        super(name, level);
        setType(Type.PSYCHIC, Type.FLYING);
        setStats(72, 58, 80, 103, 80, 97);
        setMove(new SeedBomb(), new Facade(), new DoubleTeam(), new Swagger());

    }
}

class Flareon extends Pokemon{
    Flareon(String name, int level){
        super(name, level);
        addType(Type.FIRE);
        setStats(65, 130, 60, 95, 110, 65);
        setMove(new ThunderPunch(), new Psychic(), new Confide(), new DoubleTeam());
    }
}

class Eevee extends Pokemon{
    Eevee(String name, int level){
        super(name, level);
        addType(Type.NORMAL);
        setStats(55, 55, 50, 45, 65, 55);
        setMove(new Confide(), new Psychic(), new DoubleTeam());
    }
}

class Charmander extends Pokemon{
    Charmander(String name, int level){
        super(name, level);
        addType(Type.FIRE);
        setStats(39, 52, 43, 60, 50, 65);
        setMove(new Confide(), new WorkUp());
    }
}

class Charmeleon extends Pokemon{
    Charmeleon(String name, int level){
        super(name, level);
        addType(Type.FIRE);
        setStats(58, 64, 58, 80, 65, 80);
        setMove(new Confide(), new WorkUp(), new Bite());
    }
}

class Charizard extends Pokemon{
    Charizard(String name, int level){
        super(name, level);
        setType(Type.FIRE, Type.FLYING);
        setStats(78, 84, 78, 109, 85, 100);
        setMove(new Confide(), new WorkUp(), new Bite(), new Smokescreen());
    }
}
