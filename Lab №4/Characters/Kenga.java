package Characters;

import Abstracts.Animal;
import Abstracts.Item;
import Exceptions.UnexpectedSituationException;
import Interfaces.Countable;
import Interfaces.Workable;
import Abstracts.Food;
import Items.Sandwich;
import Items.Soup;
import Properties.Cleanness;
import Properties.Ingredients;
import Properties.Mood;
import Properties.Position;

public class Kenga extends Animal implements Workable {

    public Kenga() {
        super("Кенга", Mood.PRODUCTIVE, null, false);
    }

    public Kenga(String name, Mood mood, Ingredients preference, boolean isHungry) {
        super(name, mood, preference, isHungry);
    }

    private boolean checkFood(Animal hero) {
        for (int i = 0; i < hero.getSize(); i++) {
            if (hero.getItem(i) instanceof Food) {
                return true;
            }
        }
        return false;
    }

    private void makeFood(Animal hero, int count) {
        if (checkFood(hero)) {
            for (int i = 0; i < hero.getSize(); i++) {
                if (hero.getItem(i) instanceof Food) {
                    int currCount = hero.getItem(i).getCount();
                    hero.getItem(i).setCount(currCount + count);
                    break;
                }
            }
        } else {
            Ingredients preference = hero.getPreference();
            Sandwich sandwich = new Sandwich(2, preference);
            hero.addItem(sandwich);
        }
    }

    public void checkSituation(Animal hero) throws UnexpectedSituationException {
        if(hero.gravityPosition.getPosition() == Position.FALL) {
            throw new UnexpectedSituationException(String.format("%s упал\n", hero.getName()));
        }
    }

    @Override
    public Item necessaryThing() {
        return new Soup(1);
    }

    @Override
    public boolean needToWork(Animal... args) {
        for (Animal hero : args) {
            if (!checkFood(hero)) {
                describeMood();
                System.out.printf("У %s недостаточно еды для прогулки. Надо приниматься за работу.\n", hero.getName());
                return true;
            }
        }
        describeMood();
        return super.getMood() == Mood.PRODUCTIVE;
    }

    @Override
    public void work(Animal... args) {

        Countable Thing = new Countable() {
            @Override
            public boolean haveEnoughThing(Animal hero) {
                if (hero.getItem(necessaryThing()) != null) {
                    return (hero.getItem(necessaryThing()).getCount() > 5);
                }
                return false;
            }
        };

        if (!(Thing.haveEnoughThing(this))) {
            Soup soup = new Soup(1);
            addItem(soup);
            System.out.printf("%s проверила количество предмета %s в наличии. Для уборки этого оказалось недостаточно, " +
                            "поэтому %s пополнила свои запасы. Теперь у %s есть %s в количестве %d штук.\n",
                    getName(), soup.getName().toLowerCase(), getName(), getName(),
                    soup.getName().toLowerCase(), soup.getCount());
        }

        for (Animal hero : args) {

            Countable enoughThing = new Countable() {
                @Override
                public boolean haveEnoughThing(Animal hero) {
                    if (hero.getItem(necessaryThing()) != null) {
                        return (hero.getItem(necessaryThing()).getCount() > 1);
                    }
                    return false;
                }
            };

            if (!(enoughThing.haveEnoughThing(hero))) {

                Item thingToAdd = hero.necessaryThing();
                thingToAdd.setCount(4);
                hero.addItem(thingToAdd);
                System.out.printf("У %s оказалось недостаточно предмета %s, поэтому %s начинает работать. ", hero.getName(),
                        thingToAdd.toString().toLowerCase(), getName());

                Soup kengaSoup = (Soup) getItem(necessaryThing());
                try {
                    kengaSoup.beUsed(this);
                }
                catch (NullPointerException e) {
                    System.out.printf("У %s закончилось мыло. Необходимо снова пополнить запасы.\n", getName());
                    Soup soup = new Soup(5);
                    addItem(soup);
                    System.out.printf("Теперь у %s снова достаточное количество предмета %s.\n", getName(),
                            soup.getName().toLowerCase());
                    soup.beUsed(this);
                }

                System.out.printf("Теперь у %s " +
                                "в рюкзаке есть %s в количестве %d штук(и).\n", hero.getName(),
                        thingToAdd.getName().toLowerCase(), thingToAdd.getCount());
            }

            makeFood(hero, 2);
            System.out.printf("%s приготовила еду для %s. В рюкзак добавлен предмет %s. Теперь у %s их %d штук(и).\n",
                    this.getName(), hero.getName(), hero.getItem(new Sandwich(1, hero.getPreference())).toString(),
                    hero.getName(), hero.getItem(new Sandwich(1, hero.getPreference())).getCount());
        }
    }

}
