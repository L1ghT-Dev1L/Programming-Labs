package properties;

import interfaces.Describable;

public enum Position implements Describable {
    FALL("упал"),
    STAY("стоит"),
    SIT("идит"),
    IN_AIR("в воздухе");

    private final String position;

    Position(String position) {
        this.position = position;
    }

    public String getDescription() {
        return this.position;
    }
}
