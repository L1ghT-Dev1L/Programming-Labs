package properties;

import interfaces.Describable;

public enum Cleanness implements Describable {
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