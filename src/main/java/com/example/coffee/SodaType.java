package com.example.coffee;

/**
 * Represents the available soda flavors for orders.
 */
public enum SodaType implements BeverageType {
    /** Pepsi soda. */
    PEPSI("Pepsi"),
    /** Coke soda. */
    COKE("Coke"),
    /** Sprite soda. */
    SPRITE("Sprite"),
    /** Fanta soda. */
    FANTA("Fanta"),
    /** Dr Pepper soda. */
    DR_PEPPER("Dr Pepper"),
    /** Mountain Dew soda. */
    MOUNTAIN_DEW("Mountain Dew");

    private final String displayName;

    /**
     * Creates a soda type with the specified display name.
     * 
     * @param displayName the human-readable name for this soda type
     */
    SodaType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name for this soda type.
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
