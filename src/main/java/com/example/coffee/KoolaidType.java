package com.example.coffee;

/**
 * Represents the available Koolaid flavors for orders.
 */
public enum KoolaidType implements BeverageType {
    /** Peach Koolaid. */
    PEACH("Peach"),
    /** Kiwi Koolaid. */
    KIWI("Kiwi"),
    /** Fruit Punch Koolaid. */
    FRUIT_PUNCH("Fruit Punch"),
    /** Raspberry Koolaid. */
    RASPBERRY("Raspberry");

    private final String displayName;

    KoolaidType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
