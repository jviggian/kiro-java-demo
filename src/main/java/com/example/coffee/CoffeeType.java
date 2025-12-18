package com.example.coffee;

/**
 * Represents the available coffee types and soda flavors for orders.
 */
public enum CoffeeType {
    /** Espresso coffee type. */
    ESPRESSO("Espresso"),
    /** Arabica coffee beans. */
    ARABICA("Arabica"),
    /** Robusta coffee beans. */
    ROBUSTA("Robusta"),
    /** Coffee blend. */
    BLEND("Blend"),
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
     * Creates a coffee type with the specified display name.
     * 
     * @param displayName the human-readable name for this coffee type
     */
    CoffeeType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name for this coffee type.
     * 
     * @return the human-readable name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Determines if this is a soda type.
     * 
     * @return true if this is a soda, false if it's a coffee type
     */
    public boolean isSoda() {
        return this == PEPSI || this == COKE || this == SPRITE || 
               this == FANTA || this == DR_PEPPER || this == MOUNTAIN_DEW;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
