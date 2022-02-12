package Properties;

public enum Cleanness {
    CLEAN("чистые"),
    DIRTY("грязные");

    private final String status;

    Cleanness(String status) {
        this.status = status;
    }

    public String getDescription() {
        return this.status;
    }
}
