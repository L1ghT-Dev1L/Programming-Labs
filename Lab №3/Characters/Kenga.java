package ThirdLab.Characters;

import ThirdLab.Abstracts.Animal;
import ThirdLab.Abstracts.Item;
import ThirdLab.Interfaces.Countable;
import ThirdLab.Interfaces.Workable;
import ThirdLab.Abstracts.Food;
import ThirdLab.Items.Sandwich;
import ThirdLab.Items.Soup;
import ThirdLab.Properties.Ingredients;
import ThirdLab.Properties.Mood;

public class Kenga extends Animal implements Workable, Countable {

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
    public boolean haveEnoughThing() {
        if (getItem(necessaryThing()) != null) {
            return !(getItem(necessaryThing()).getCount() < 5);
        }
        return false;
    }

    @Override
    public void work(Animal... args) {
        if (!haveEnoughThing()) {
            Soup soup = new Soup(6);
            addItem(soup);
            System.out.printf("%s проверила количество предмета %s в наличии. Для уборки этого оказалось недостаточно, " +
                            "поэтому %s пополнила свои запасы. Теперь у %s есть %s в количестве %d штук.\n",
                    getName(), soup.getName().toLowerCase(), getName(), getName(),
                    soup.getName().toLowerCase(), soup.getCount());
        }
        for (Animal hero : args) {
            if (!(hero.haveEnoughThing())) {
                Item thingToAdd = hero.necessaryThing();
                thingToAdd.setCount(4);
                hero.addItem(thingToAdd);
                System.out.printf("У %s оказалось недостаточно предмета %s, поэтому %s начинает работать. ", hero.getName(),
                        thingToAdd.getName().toLowerCase(), getName());
                Soup kengaSoup = (Soup) getItem(necessaryThing());
                kengaSoup.beUsed(this);
                this.usedItem(getItem(necessaryThing()));
                System.out.printf("Теперь у %s " +
                                "в рюкзаке есть %s в количестве %d штук(и).\n", hero.getName(),
                        thingToAdd.getName().toLowerCase(), thingToAdd.getCount());
            }
            makeFood(hero, 2);
            System.out.printf("%s приготовила еду для %s. В рюкзак добавлен предмет %s. Теперь у %s их %d штук(и).\n",
                    this.getName(), hero.getName(), hero.getItem(new Sandwich(1)).toString(),
                    hero.getName(), hero.getItem(new Sandwich(1)).getCount());
        }
    }

}
