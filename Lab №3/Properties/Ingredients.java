package ThirdLab.Properties;

public enum Ingredients {
    SALAD("салат"),
    HAM("ветчина"),
    FISH_OIL("рыбий жир"),
    TOMATO("помидор"),
    CHEESE("сыр"),
    SAUCE("соус");

    private String preference;

    Ingredients(String preference) {
        this.preference = preference;
    }

    public String getPreference() {
        return this.preference;
    }
}
