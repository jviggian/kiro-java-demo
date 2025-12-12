package com.example.coffee;

public enum CoffeeType {
    ESPRESSO("Espresso"),
    ARABICA("Arabica"),
    ROBUSTA("Robusta"),
    BLEND("Blend");

    private final String displayName;

    CoffeeType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
