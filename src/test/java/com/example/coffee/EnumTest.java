package com.example.coffee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class EnumTest {

    @Test
    @DisplayName("Size enum should have correct values")
    void sizeEnumShouldHaveCorrectValues() {
        assertEquals(3, Size.values().length);
        assertNotNull(Size.valueOf("SMALL"));
        assertNotNull(Size.valueOf("MEDIUM"));
        assertNotNull(Size.valueOf("LARGE"));
    }

    @Test
    @DisplayName("Size enum should have correct display names")
    void sizeEnumShouldHaveCorrectDisplayNames() {
        assertEquals("Small", Size.SMALL.getDisplayName());
        assertEquals("Medium", Size.MEDIUM.getDisplayName());
        assertEquals("Large", Size.LARGE.getDisplayName());
    }

    @Test
    @DisplayName("Size enum toString should return display name")
    void sizeEnumToStringShouldReturnDisplayName() {
        assertEquals("Small", Size.SMALL.toString());
        assertEquals("Medium", Size.MEDIUM.toString());
        assertEquals("Large", Size.LARGE.toString());
    }

    @Test
    @DisplayName("GrindType enum should have correct values")
    void grindTypeEnumShouldHaveCorrectValues() {
        assertEquals(5, GrindType.values().length);
        assertNotNull(GrindType.valueOf("WHOLE_BEAN"));
        assertNotNull(GrindType.valueOf("COARSE"));
        assertNotNull(GrindType.valueOf("MEDIUM"));
        assertNotNull(GrindType.valueOf("FINE"));
        assertNotNull(GrindType.valueOf("EXTRA_FINE"));
    }

    @Test
    @DisplayName("GrindType enum should have correct display names")
    void grindTypeEnumShouldHaveCorrectDisplayNames() {
        assertEquals("Whole Bean", GrindType.WHOLE_BEAN.getDisplayName());
        assertEquals("Coarse", GrindType.COARSE.getDisplayName());
        assertEquals("Medium", GrindType.MEDIUM.getDisplayName());
        assertEquals("Fine", GrindType.FINE.getDisplayName());
        assertEquals("Extra Fine", GrindType.EXTRA_FINE.getDisplayName());
    }

    @Test
    @DisplayName("GrindType enum toString should return display name")
    void grindTypeEnumToStringShouldReturnDisplayName() {
        assertEquals("Whole Bean", GrindType.WHOLE_BEAN.toString());
        assertEquals("Coarse", GrindType.COARSE.toString());
        assertEquals("Medium", GrindType.MEDIUM.toString());
        assertEquals("Fine", GrindType.FINE.toString());
        assertEquals("Extra Fine", GrindType.EXTRA_FINE.toString());
    }

    @Test
    @DisplayName("CoffeeType enum should have correct values")
    void coffeeTypeEnumShouldHaveCorrectValues() {
        assertEquals(4, CoffeeType.values().length);
        assertNotNull(CoffeeType.valueOf("ESPRESSO"));
        assertNotNull(CoffeeType.valueOf("ARABICA"));
        assertNotNull(CoffeeType.valueOf("ROBUSTA"));
        assertNotNull(CoffeeType.valueOf("BLEND"));
    }

    @Test
    @DisplayName("CoffeeType enum should have correct display names")
    void coffeeTypeEnumShouldHaveCorrectDisplayNames() {
        assertEquals("Espresso", CoffeeType.ESPRESSO.getDisplayName());
        assertEquals("Arabica", CoffeeType.ARABICA.getDisplayName());
        assertEquals("Robusta", CoffeeType.ROBUSTA.getDisplayName());
        assertEquals("Blend", CoffeeType.BLEND.getDisplayName());
    }

    @Test
    @DisplayName("CoffeeType enum toString should return display name")
    void coffeeTypeEnumToStringShouldReturnDisplayName() {
        assertEquals("Espresso", CoffeeType.ESPRESSO.toString());
        assertEquals("Arabica", CoffeeType.ARABICA.toString());
        assertEquals("Robusta", CoffeeType.ROBUSTA.toString());
        assertEquals("Blend", CoffeeType.BLEND.toString());
    }

    @Test
    @DisplayName("Addition enum should have correct values")
    void additionEnumShouldHaveCorrectValues() {
        assertEquals(5, Addition.values().length);
        assertNotNull(Addition.valueOf("MILK"));
        assertNotNull(Addition.valueOf("SUGAR"));
        assertNotNull(Addition.valueOf("CREAM"));
        assertNotNull(Addition.valueOf("VANILLA"));
        assertNotNull(Addition.valueOf("CARAMEL"));
    }

    @Test
    @DisplayName("Addition enum should have correct display names")
    void additionEnumShouldHaveCorrectDisplayNames() {
        assertEquals("Milk", Addition.MILK.getDisplayName());
        assertEquals("Sugar", Addition.SUGAR.getDisplayName());
        assertEquals("Cream", Addition.CREAM.getDisplayName());
        assertEquals("Vanilla", Addition.VANILLA.getDisplayName());
        assertEquals("Caramel", Addition.CARAMEL.getDisplayName());
    }

    @Test
    @DisplayName("Addition enum toString should return display name")
    void additionEnumToStringShouldReturnDisplayName() {
        assertEquals("Milk", Addition.MILK.toString());
        assertEquals("Sugar", Addition.SUGAR.toString());
        assertEquals("Cream", Addition.CREAM.toString());
        assertEquals("Vanilla", Addition.VANILLA.toString());
        assertEquals("Caramel", Addition.CARAMEL.toString());
    }
}
