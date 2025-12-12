package com.example.coffee;

/**
 * Represents the available sizes for coffee orders.
 */
public enum Size {
    /** Small size coffee order. */
    SMALL("Small"),
    /** Medium size coffee order. */
    MEDIUM("Medium"),
    /** Large size coffee order. */
    LARGE("Large");

    private final String displayName;

    /**
     * Creates a size with the specified display name.
     * 
     * @param displayName the human-readable name for this size
     */
    Size(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name for this size.
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
