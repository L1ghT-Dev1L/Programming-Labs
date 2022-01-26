import Characters.*;
import Exceptions.UnexpectedSituationException;
import Items.Napkin;
import Items.Sandwich;
import Properties.*;

public class Main {

    public static void main(String[] args) {

        Kenga kenga = new Kenga("Кенга", Mood.PRODUCTIVE, null, false);
        Roo roo = new Roo("Ру", Mood.FINE, Ingredients.SALAD, false);
        Tiger tigra = new Tiger("Тигра", Mood.HAPPY, Ingredients.FISH_OIL, true);

        System.out.printf("Хороший день для прогулки! Поэтому %s пришёл к %s, чтобы позвать его на прогулку.\n",
                tigra.getName(), roo.getName());
        tigra.greeting(roo);

        try {
            kenga.checkSituation(roo);
        }
        catch (UnexpectedSituationException situation) {
            System.out.println(kenga.getName() + " говорит: \"Тигра, деточка, осторожно!\"");
            System.out.printf("%s помогает встать %s.\n", kenga.getName(), roo.getName());
            System.out.println("Теперь " + roo.ears.description());
        }

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
                Sandwich food = (Sandwich) roo.getItem(new Sandwich(1, Ingredients.SALAD));
                roo.eat(food);
            }

            if (!(tigra.readyToWalk())) {
                System.out.printf("%s голоден, значит нужно перекусить.\n", tigra.getName());
                Sandwich food = (Sandwich) tigra.getItem(new Sandwich(1, Ingredients.FISH_OIL));
                tigra.eat(food);
                Napkin napkin = (Napkin) tigra.getItem(new Napkin(1));
                tigra.usedItem(napkin);
            }

            System.out.println("Теперь можно отправляться в путь.");
            roo.walk();
            tigra.walk();
        }

    }

}
