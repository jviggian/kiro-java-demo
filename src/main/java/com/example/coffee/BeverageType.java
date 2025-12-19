package com.example.coffee;

/**
 * Represents a type of beverage that can be ordered.
 * This is a sealed interface that permits only CoffeeType and SodaType implementations.
 */
public sealed interface BeverageType permits CoffeeType, SodaType {
    /**
     * Gets the display name for this beverage type.
     * 
     * @return the human-readable name
     */
    String getDisplayName();
}
