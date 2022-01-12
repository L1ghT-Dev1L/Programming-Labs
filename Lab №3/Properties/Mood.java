package ThirdLab.Properties;

public enum Mood {
    BAD("плохое"),
    SAD("печальное"),
    FUNNY("весёлое"),
    PRODUCTIVE("хозяйственное"),
    HAPPY("счастливое"),
    FINE("хорошее"),
    NORMAL("обычное");

    private String mood;

    Mood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return this.mood;
    }

}
