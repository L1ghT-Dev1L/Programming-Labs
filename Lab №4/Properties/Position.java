package Properties;

public enum Position {
    FALL("упал"),
    STAY("стоит"),
    IN_AIR("в воздухе");

    private final String position;

    Position(String position) {
        this.position = position;
    }

    public String getDescription() {
        return this.position;
    }
}
