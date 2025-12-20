package com.example.coffee;

/**
 * Represents the available grind types for coffee orders.
 */
public enum GrindType {
    /** Not applicable (for non-coffee beverages). */
    NONE("None"),
    /** Whole bean coffee, not ground. */
    WHOLE_BEAN("Whole Bean"),
    /** Coarse grind, suitable for French press. */
    COARSE("Coarse"),
    /** Medium grind, suitable for drip coffee. */
    MEDIUM("Medium"),
    /** Fine grind, suitable for espresso. */
    FINE("Fine"),
    /** Extra fine grind, suitable for Turkish coffee. */
    EXTRA_FINE("Extra Fine");

    private final String displayName;

    /**
     * Creates a grind type with the specified display name.
     * 
     * @param displayName the human-readable name for this grind type
     */
    GrindType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name for this grind type.
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
