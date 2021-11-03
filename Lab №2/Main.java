import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Eevee("Олег", 1);
        Pokemon p2 = new HoopaConfined("Иван", 1);
        Pokemon p3 = new Leafeon("Семён", 1);
        Pokemon p4 = new Zubat("Саша", 1);
        Pokemon p5 = new Golbat("Егор", 1);
        Pokemon p6 = new Crobat("Никита", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
