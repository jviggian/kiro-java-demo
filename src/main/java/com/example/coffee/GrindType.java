package com.example.coffee;

public enum GrindType {
    WHOLE_BEAN("Whole Bean"),
    COARSE("Coarse"),
    MEDIUM("Medium"),
    FINE("Fine"),
    EXTRA_FINE("Extra Fine");

    private final String displayName;

    GrindType(String displayName) {
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
