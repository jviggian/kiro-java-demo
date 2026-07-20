package com.example.coffee;

/**
 * Represents the available Koolaid flavors for orders.
 */
public enum KoolaidType implements BeverageType {
    /** Peach Koolaid flavor. */
    PEACH("Peach"),
    /** Kiwi Koolaid flavor. */
    KIWI("Kiwi"),
    /** Fruit Punch Koolaid flavor. */
    FRUIT_PUNCH("Fruit Punch"),
    /** Raspberry Koolaid flavor. */
    RASPBERRY("Raspberry");

    private final String displayName;

    /**
     * Creates a Koolaid type with the specified display name.
     *
     * @param displayName the human-readable name for this Koolaid flavor
     */
    KoolaidType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name for this Koolaid type.
     *
     * @return the human-readable name
     */
    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
