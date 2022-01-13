package ThirdLab;

import ThirdLab.Characters.*;
import ThirdLab.Items.Napkin;
import ThirdLab.Items.Sandwich;
import ThirdLab.Properties.*;

public class Main {

    public static void main(String[] args) {

        Kenga kenga = new Kenga("Кенга", Mood.PRODUCTIVE, null, false);
        Roo roo = new Roo("Ру", Mood.FINE, Ingredients.SALAD, false);
        Tiger tigra = new Tiger("Тигра", Mood.NORMAL, Ingredients.FISH_OIL, true);

        if (kenga.needToWork(roo, tigra)) {
            kenga.work(roo, tigra);
        } else {
            System.out.printf("Сегодня %s может отдохнуть", kenga.getName());
        }

        if (roo.readyToWalk() && tigra.readyToWalk()) {
            System.out.printf("%s и %s готовы гулять, значит можно отправиться в путь.\n", roo.getName(), tigra.getName());
            roo.walk();
            tigra.walk();
        } else {
            if (!(roo.readyToWalk())) {
                System.out.printf("%s голоден, значит нужно перекусить.\n", roo.getName());
                Sandwich food = (Sandwich) roo.getItem(new Sandwich(1, roo.getPreference()));
                roo.eat(food);
            }
            if (!(tigra.readyToWalk())) {
                System.out.printf("%s голоден, значит нужно перекусить.\n", tigra.getName());
                Sandwich food = (Sandwich) tigra.getItem(new Sandwich(1, tigra.getPreference()));
                tigra.eat(food);
                Napkin napkin = (Napkin) tigra.getItem(new Napkin(1));
                tigra.usedItem(napkin);
                napkin.beUsed(tigra);
            }
            System.out.println("Теперь можно отправляться в путь.");
            roo.walk();
            tigra.walk();
        }

    }

}

