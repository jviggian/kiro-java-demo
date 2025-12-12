package com.example.coffee;

public enum Addition {
    MILK("Milk"),
    SUGAR("Sugar"),
    CREAM("Cream"),
    VANILLA("Vanilla"),
    CARAMEL("Caramel");

    private final String displayName;

    Addition(String displayName) {
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
