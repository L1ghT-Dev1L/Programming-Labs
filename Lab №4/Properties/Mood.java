package Properties;

public enum Mood {
    BAD("плохое"),
    SAD("печальное"),
    FUNNY("весёлое"),
    PRODUCTIVE("хозяйственное"),
    HAPPY("счастливое"),
    FINE("хорошее"),
    NORMAL("обычное");

    private final String mood;

    Mood(String mood) {
        this.mood = mood;
    }

    public String getDescription() {
        return this.mood;
    }

}
