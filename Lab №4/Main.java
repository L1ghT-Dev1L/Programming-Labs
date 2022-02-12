import abstracts.Animal;
import characters.*;
import exceptions.ImpossibleSituationException;
import items.Napkin;
import items.Sandwich;
import properties.*;

public class Main {

    public static void main(String[] args) {

        Kenga kenga = new Kenga("Кенга", Mood.PRODUCTIVE, Ingredients.TOMATO, false);
        Roo roo = new Roo("Ру", Mood.FINE, Ingredients.SALAD, false);
        Tiger tigra = new Tiger("Тигра", Mood.HAPPY, Ingredients.FISH_OIL, true);

        Animal[] charactersToWalk = {roo, tigra};

        System.out.printf("Хороший день для прогулки! Поэтому %s пришёл к %s, чтобы позвать его на прогулку.\n",
                tigra.getName(), roo.getName());
        tigra.greeting(roo);

        if (kenga.needToWork(roo, tigra)) {
            for (Animal character : charactersToWalk) {
                kenga.work(character);
            }
        } else {
            System.out.printf("Сегодня %s может отдохнуть", kenga.getName());
        }

        try {
            if (roo.readyToWalk() && tigra.readyToWalk()) {
                System.out.printf("%s и %s готовы гулять, значит можно отправиться в путь.\n", roo.getName(), tigra.getName());

            } else {
                if (!(roo.readyToWalk())) {
                    System.out.printf("%s голоден, значит нужно перекусить.\n", roo.getName());
                    Sandwich food = (Sandwich) roo.getItem(new Sandwich(1, (Ingredients) roo.getPreference()));
                    food.beUsed(roo);
                }
                if (!(tigra.readyToWalk())) {
                    System.out.printf("%s голоден, значит нужно перекусить.\n", tigra.getName());
                    Sandwich food = (Sandwich) tigra.getItem(new Sandwich(1, (Ingredients) tigra.getPreference()));
                    food.beUsed(tigra);
                    Napkin napkin = (Napkin) tigra.getItem(new Napkin(1));
                    napkin.beUsed(tigra);
                }

                System.out.println("Теперь можно отправляться в путь.");
            }
            roo.walk();
            tigra.walk();
        }
        catch (ImpossibleSituationException e) {
            if (roo.getHeroPosition() == Position.FALL) {
                System.out.printf("%s %s. %s помогла %s встать.\n", roo.getName(), roo.getHeroPosition().getDescription(),
                        kenga.getName(), roo.getName());
            }
            else if (roo.getHeroPosition() != Position.STAY) {
                roo.setHeroPosition(Position.STAY);
            }

            if (tigra.getHeroPosition() == Position.FALL) {
                System.out.printf("%s %s. %s помогла %s встать.\n", tigra.getName(), tigra.getHeroPosition().getDescription(),
                        kenga.getName(), tigra.getName());
            }
            else if (tigra.getHeroPosition() != Position.STAY) {
                tigra.setHeroPosition(Position.STAY);
            }

            if (!(roo.isHungry() && tigra.isHungry())) {
                System.out.printf("Ребята проголодались. Надо перекусить.\n");

                Sandwich rooFood = (Sandwich) roo.getItem(new Sandwich(1, (Ingredients) roo.getPreference()));
                rooFood.beUsed(roo);

                Sandwich tigraFood = (Sandwich) tigra.getItem(new Sandwich(1, (Ingredients) tigra.getPreference()));
                tigraFood.beUsed(tigra);
                Napkin napkin = (Napkin) tigra.getItem(new Napkin(1));
                napkin.beUsed(tigra);
                napkin.beUsed(roo);
            }

            System.out.println("Теперь можно отправляться в путь.");
            roo.walk();
            tigra.walk();
        }
    }
}
