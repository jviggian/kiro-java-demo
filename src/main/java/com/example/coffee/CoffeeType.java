package com.example.coffee;

/**
 * Represents the available coffee types for orders.
 */
public enum CoffeeType implements BeverageType {
    /** Espresso coffee type. */
    ESPRESSO("Espresso"),
    /** Arabica coffee beans. */
    ARABICA("Arabica"),
    /** Robusta coffee beans. */
    ROBUSTA("Robusta"),
    /** Coffee blend. */
    BLEND("Blend");

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
    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
