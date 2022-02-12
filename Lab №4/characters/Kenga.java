package characters;

import abstracts.Animal;
import abstracts.Item;
import interfaces.Itemize;
import interfaces.Workable;
import items.Sandwich;
import items.Soup;
import properties.Ingredients;
import properties.Mood;

public class Kenga extends Animal implements Workable {

    public Kenga(String name, Mood mood, Ingredients preference, boolean hungry) {
        super(name, mood, preference, hungry);
    }

    private void makeFood(Animal hero) {
        Sandwich food = new Sandwich(2, (Ingredients) hero.getPreference());
        hero.addItem(food);
        System.out.printf("%s приготовила еду для %s. В рюкзак добавлен предмет %s. Теперь у %s их %d штук(и).\n",
                this.getName(), hero.getName(), hero.getItem(new Sandwich(1, (Ingredients) hero.getPreference())),
                hero.getName(), food.getCount());
    }

    private void cleaning(Animal hero) {
        if (!this.haveEnoughItems()) {
            this.addItem(new Soup(5));
        }
        if (!(hero.haveEnoughItems())) {

            System.out.printf("У %s оказалось недостаточно предмета %s, поэтому %s начинает работать. ", hero.getName(),
                    hero.getNecessaryItem().toString(), getName());

            Itemize item = hero.getNecessaryItem();
            Item itemToAdd = (Item) item;
            itemToAdd.setCount(5);
            hero.addItem(itemToAdd);

            System.out.printf("Теперь у %s " +
                            "в рюкзаке есть %s в количестве %d штук(и).\n", hero.getName(),
                    hero.getNecessaryItem().toString().toLowerCase(), itemToAdd.getCount());
        }
    }

    private void describeMood() {
        System.out.printf("Сегодня у %s %s настроение.\n", getName(), getMood().getDescription());
    }

    private boolean checkFood(Animal hero) {
        Sandwich food = new Sandwich(1, (Ingredients) hero.getPreference());
        return hero.haveItem(food);
    }

    @Override
    public boolean haveEnoughItems() {
        Item necessaryItem = new Soup(1);
        if (this.getItem(necessaryItem) != null) {
            Item backpackItem = (Item) this.getItem(necessaryItem);
            return backpackItem.getCount() >= 2;
        }
        return false;
    }

    public Itemize getNecessaryItem() {
        return new Soup(1);
    }

    @Override
    public boolean needToWork(Animal... args) {
        for (Animal hero : args) {
            if (!checkFood(hero)) {
                describeMood();
                System.out.printf("У %s недостаточно еды для прогулки.\n", hero.getName());
                return true;
            }
        }
        describeMood();
        return super.getMood() == Mood.PRODUCTIVE;
    }

    @Override
    public void work(Animal hero) {
        makeFood(hero);
        cleaning(hero);
    }

}
