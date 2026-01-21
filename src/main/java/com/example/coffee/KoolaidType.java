package com.example.coffee;

public enum KoolaidType implements BeverageType {
    PEACH("Peach"),
    KIWI("Kiwi"),
    FRUIT_PUNCH("Fruit Punch"),
    RASPBERRY("Raspberry");

    private final String displayName;

    KoolaidType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
