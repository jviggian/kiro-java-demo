package com.example.coffee;

/**
 * Represents the available Koolaid flavors for orders.
 */
public enum KoolaidType implements BeverageType {
    /** Peach flavored Koolaid. */
    PEACH("Peach"),
    /** Kiwi flavored Koolaid. */
    KIWI("Kiwi"),
    /** Fruit punch flavored Koolaid. */
    FRUIT_PUNCH("Fruit Punch"),
    /** Raspberry flavored Koolaid. */
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
     * Gets the display name for this Koolaid flavor.
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
