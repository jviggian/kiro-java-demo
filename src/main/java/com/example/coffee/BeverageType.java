package com.example.coffee;

public sealed interface BeverageType permits CoffeeType, SodaType, KoolaidType {
    String getDisplayName();
}
