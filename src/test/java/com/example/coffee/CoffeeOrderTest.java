package com.example.coffee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderTest {

    @Test
    @DisplayName("Should create coffee order with all required fields")
    void shouldCreateCoffeeOrderWithAllFields() {
        Set<Addition> additions = new HashSet<>();
        additions.add(Addition.MILK);
        additions.add(Addition.SUGAR);

        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM, 
            GrindType.COARSE, 
            CoffeeType.ARABICA, 
            additions
        );

        assertNotNull(order.getOrderId());
        assertEquals(Size.MEDIUM, order.getSize());
        assertEquals(GrindType.COARSE, order.getGrindType());
        assertEquals(CoffeeType.ARABICA, order.getCoffeeType());
        assertEquals(2, order.getAdditions().size());
        assertTrue(order.getAdditions().contains(Addition.MILK));
        assertTrue(order.getAdditions().contains(Addition.SUGAR));
    }

    @Test
    @DisplayName("Should create coffee order with no additions")
    void shouldCreateCoffeeOrderWithNoAdditions() {
        CoffeeOrder order = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            new HashSet<>()
        );

        assertNotNull(order.getOrderId());
        assertTrue(order.getAdditions().isEmpty());
    }

    @Test
    @DisplayName("Should create coffee order with null additions set")
    void shouldCreateCoffeeOrderWithNullAdditions() {
        CoffeeOrder order = new CoffeeOrder(
            Size.LARGE, 
            GrindType.MEDIUM, 
            CoffeeType.BLEND, 
            null
        );

        assertNotNull(order.getOrderId());
        assertNotNull(order.getAdditions());
        assertTrue(order.getAdditions().isEmpty());
    }

    @Test
    @DisplayName("Should throw exception when size is null")
    void shouldThrowExceptionWhenSizeIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new CoffeeOrder(null, GrindType.COARSE, CoffeeType.ARABICA, new HashSet<>());
        });
    }

    @Test
    @DisplayName("Should throw exception when grind type is null")
    void shouldThrowExceptionWhenGrindTypeIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new CoffeeOrder(Size.MEDIUM, null, CoffeeType.ARABICA, new HashSet<>());
        });
    }

    @Test
    @DisplayName("Should throw exception when coffee type is null")
    void shouldThrowExceptionWhenCoffeeTypeIsNull() {
        assertThrows(NullPointerException.class, () -> {
            new CoffeeOrder(Size.MEDIUM, GrindType.COARSE, null, new HashSet<>());
        });
    }

    @Test
    @DisplayName("Should generate unique order IDs")
    void shouldGenerateUniqueOrderIds() {
        CoffeeOrder order1 = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            new HashSet<>()
        );
        CoffeeOrder order2 = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            new HashSet<>()
        );

        assertNotEquals(order1.getOrderId(), order2.getOrderId());
    }

    @Test
    @DisplayName("Should return immutable additions set")
    void shouldReturnImmutableAdditionsSet() {
        Set<Addition> additions = new HashSet<>();
        additions.add(Addition.MILK);
        
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM, 
            GrindType.COARSE, 
            CoffeeType.ARABICA, 
            additions
        );

        Set<Addition> retrievedAdditions = order.getAdditions();
        assertThrows(UnsupportedOperationException.class, () -> {
            retrievedAdditions.add(Addition.SUGAR);
        });
    }

    @Test
    @DisplayName("Should not modify original additions set after order creation")
    void shouldNotModifyOriginalAdditionsSet() {
        Set<Addition> additions = new HashSet<>();
        additions.add(Addition.MILK);
        
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM, 
            GrindType.COARSE, 
            CoffeeType.ARABICA, 
            additions
        );

        additions.add(Addition.SUGAR);
        assertEquals(1, order.getAdditions().size());
        assertFalse(order.getAdditions().contains(Addition.SUGAR));
    }

    @Test
    @DisplayName("Should implement equals based on order ID")
    void shouldImplementEqualsBasedOnOrderId() {
        CoffeeOrder order1 = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            new HashSet<>()
        );
        CoffeeOrder order2 = new CoffeeOrder(
            Size.LARGE, 
            GrindType.COARSE, 
            CoffeeType.BLEND, 
            new HashSet<>()
        );

        assertEquals(order1, order1);
        assertNotEquals(order1, order2);
        assertNotEquals(order1, null);
        assertNotEquals(order1, new Object());
    }

    @Test
    @DisplayName("Should implement hashCode based on order ID")
    void shouldImplementHashCodeBasedOnOrderId() {
        CoffeeOrder order = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            new HashSet<>()
        );

        int hashCode1 = order.hashCode();
        int hashCode2 = order.hashCode();
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    @DisplayName("Should generate string representation with all fields")
    void shouldGenerateStringRepresentationWithAllFields() {
        Set<Addition> additions = new HashSet<>();
        additions.add(Addition.MILK);
        additions.add(Addition.SUGAR);

        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM, 
            GrindType.COARSE, 
            CoffeeType.ARABICA, 
            additions
        );

        String orderString = order.toString();
        assertTrue(orderString.contains("Order ID:"));
        assertTrue(orderString.contains("Size: Medium"));
        assertTrue(orderString.contains("Grind Type: Coarse"));
        assertTrue(orderString.contains("Coffee Type: Arabica"));
        assertTrue(orderString.contains("Additions:"));
        assertTrue(orderString.contains("Milk") || orderString.contains("Sugar"));
    }

    @Test
    @DisplayName("Should generate string representation with no additions")
    void shouldGenerateStringRepresentationWithNoAdditions() {
        CoffeeOrder order = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            new HashSet<>()
        );

        String orderString = order.toString();
        assertTrue(orderString.contains("Additions: None"));
    }

    @ParameterizedTest
    @EnumSource(Size.class)
    @DisplayName("Should accept all size values")
    void shouldAcceptAllSizeValues(Size size) {
        CoffeeOrder order = new CoffeeOrder(
            size, 
            GrindType.MEDIUM, 
            CoffeeType.ARABICA, 
            new HashSet<>()
        );
        assertEquals(size, order.getSize());
    }

    @ParameterizedTest
    @EnumSource(GrindType.class)
    @DisplayName("Should accept all grind type values")
    void shouldAcceptAllGrindTypeValues(GrindType grindType) {
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM, 
            grindType, 
            CoffeeType.ARABICA, 
            new HashSet<>()
        );
        assertEquals(grindType, order.getGrindType());
    }

    @ParameterizedTest
    @EnumSource(CoffeeType.class)
    @DisplayName("Should accept all coffee type values")
    void shouldAcceptAllCoffeeTypeValues(CoffeeType coffeeType) {
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM, 
            GrindType.MEDIUM, 
            coffeeType, 
            new HashSet<>()
        );
        assertEquals(coffeeType, order.getCoffeeType());
    }

    @Test
    @DisplayName("Should handle all addition types")
    void shouldHandleAllAdditionTypes() {
        Set<Addition> additions = new HashSet<>();
        additions.add(Addition.MILK);
        additions.add(Addition.SUGAR);
        additions.add(Addition.CREAM);
        additions.add(Addition.VANILLA);
        additions.add(Addition.CARAMEL);

        CoffeeOrder order = new CoffeeOrder(
            Size.LARGE, 
            GrindType.COARSE, 
            CoffeeType.BLEND, 
            additions
        );

        assertEquals(5, order.getAdditions().size());
        assertTrue(order.getAdditions().containsAll(additions));
    }

    @Test
    @DisplayName("Should create soda order with NONE grind type")
    void shouldCreateSodaOrderWithNoneGrindType() {
        CoffeeOrder order = new CoffeeOrder(
            Size.LARGE,
            GrindType.NONE,
            SodaType.PEPSI,
            new HashSet<>()
        );

        assertNotNull(order.getOrderId());
        assertEquals(Size.LARGE, order.getSize());
        assertEquals(GrindType.NONE, order.getGrindType());
        assertEquals(SodaType.PEPSI, order.getBeverageType());
        assertTrue(order.getBeverageType() instanceof SodaType);
    }

    @Test
    @DisplayName("Should create soda order and exclude NONE grind type from string representation")
    void shouldExcludeNoneGrindTypeFromStringRepresentation() {
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM,
            GrindType.NONE,
            SodaType.COKE,
            new HashSet<>()
        );

        String orderString = order.toString();
        assertTrue(orderString.contains("Order ID:"));
        assertTrue(orderString.contains("Size: Medium"));
        assertFalse(orderString.contains("Grind Type: None"));
        assertTrue(orderString.contains("Soda Type: Coke"));
    }

    @ParameterizedTest
    @EnumSource(SodaType.class)
    @DisplayName("Should accept all soda type values")
    void shouldAcceptAllSodaTypeValues(SodaType sodaType) {
        CoffeeOrder order = new CoffeeOrder(
            Size.LARGE,
            GrindType.NONE,
            sodaType,
            new HashSet<>()
        );
        assertEquals(sodaType, order.getBeverageType());
        assertTrue(order.getBeverageType() instanceof SodaType);
    }
}
