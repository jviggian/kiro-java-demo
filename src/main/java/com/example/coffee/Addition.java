package com.example.coffee;

/**
 * Represents the available additions that can be added to coffee orders.
 */
public enum Addition {
    /** Milk addition. */
    MILK("Milk"),
    /** Sugar addition. */
    SUGAR("Sugar"),
    /** Cream addition. */
    CREAM("Cream"),
    /** Vanilla flavoring addition. */
    VANILLA("Vanilla"),
    /** Caramel flavoring addition. */
    CARAMEL("Caramel");

    private final String displayName;

    /**
     * Creates an addition with the specified display name.
     * 
     * @param displayName the human-readable name for this addition
     */
    Addition(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name for this addition.
     * 
     * @return the human-readable name
     */
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
