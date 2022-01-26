package Properties;

public enum Ingredients {
    SALAD("салат"),
    HAM("ветчина"),
    FISH_OIL("рыбий жир"),
    TOMATO("помидор"),
    CHEESE("сыр"),
    SAUCE("соус");

    private final String preference;

    Ingredients(String preference) {
        this.preference = preference;
    }

    public String getDescription() {
        return this.preference;
    }
}
