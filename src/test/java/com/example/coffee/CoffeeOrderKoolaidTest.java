package com.example.coffee;

import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CoffeeOrder with KoolaidType beverages.
 * Tests the creation and properties of Koolaid orders.
 */
class CoffeeOrderKoolaidTest {

    @Test
    void testCreateKoolaidOrder() {
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM,
            GrindType.NONE,
            KoolaidType.PEACH,
            Set.of()
        );
        
        assertNotNull(order);
        assertEquals(Size.MEDIUM, order.getSize());
        assertEquals(GrindType.NONE, order.getGrindType());
        assertEquals(KoolaidType.PEACH, order.getBeverageType());
        assertTrue(order.getAdditions().isEmpty());
    }

    @Test
    void testKoolaidOrderWithAllFlavors() {
        // Test Peach
        CoffeeOrder peachOrder = new CoffeeOrder(Size.SMALL, GrindType.NONE, KoolaidType.PEACH, Set.of());
        assertEquals(KoolaidType.PEACH, peachOrder.getBeverageType());
        
        // Test Kiwi
        CoffeeOrder kiwiOrder = new CoffeeOrder(Size.SMALL, GrindType.NONE, KoolaidType.KIWI, Set.of());
        assertEquals(KoolaidType.KIWI, kiwiOrder.getBeverageType());
        
        // Test Fruit Punch
        CoffeeOrder fruitPunchOrder = new CoffeeOrder(Size.SMALL, GrindType.NONE, KoolaidType.FRUIT_PUNCH, Set.of());
        assertEquals(KoolaidType.FRUIT_PUNCH, fruitPunchOrder.getBeverageType());
        
        // Test Raspberry
        CoffeeOrder raspberryOrder = new CoffeeOrder(Size.SMALL, GrindType.NONE, KoolaidType.RASPBERRY, Set.of());
        assertEquals(KoolaidType.RASPBERRY, raspberryOrder.getBeverageType());
    }

    @Test
    void testKoolaidOrderWithAdditions() {
        Set<Addition> additions = new HashSet<>();
        additions.add(Addition.SUGAR);
        additions.add(Addition.VANILLA);
        
        CoffeeOrder order = new CoffeeOrder(
            Size.LARGE,
            GrindType.NONE,
            KoolaidType.RASPBERRY,
            additions
        );
        
        assertEquals(2, order.getAdditions().size());
        assertTrue(order.getAdditions().contains(Addition.SUGAR));
        assertTrue(order.getAdditions().contains(Addition.VANILLA));
    }

    @Test
    void testKoolaidOrderWithAllSizes() {
        CoffeeOrder smallOrder = new CoffeeOrder(Size.SMALL, GrindType.NONE, KoolaidType.KIWI, Set.of());
        assertEquals(Size.SMALL, smallOrder.getSize());
        
        CoffeeOrder mediumOrder = new CoffeeOrder(Size.MEDIUM, GrindType.NONE, KoolaidType.KIWI, Set.of());
        assertEquals(Size.MEDIUM, mediumOrder.getSize());
        
        CoffeeOrder largeOrder = new CoffeeOrder(Size.LARGE, GrindType.NONE, KoolaidType.KIWI, Set.of());
        assertEquals(Size.LARGE, largeOrder.getSize());
    }

    @Test
    void testKoolaidOrderToString() {
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM,
            GrindType.NONE,
            KoolaidType.FRUIT_PUNCH,
            Set.of(Addition.SUGAR)
        );
        
        String orderString = order.toString();
        assertNotNull(orderString);
        assertTrue(orderString.contains("MEDIUM"));
        assertTrue(orderString.contains("Fruit Punch"));
        assertTrue(orderString.contains("NONE"));
    }

    @Test
    void testKoolaidOrderImmutability() {
        Set<Addition> additions = new HashSet<>();
        additions.add(Addition.MILK);
        
        CoffeeOrder order = new CoffeeOrder(
            Size.SMALL,
            GrindType.NONE,
            KoolaidType.PEACH,
            additions
        );
        
        // Try to modify the original set
        additions.add(Addition.CREAM);
        
        // Order should still have only one addition
        assertEquals(1, order.getAdditions().size());
        assertTrue(order.getAdditions().contains(Addition.MILK));
        assertFalse(order.getAdditions().contains(Addition.CREAM));
    }

    @Test
    void testKoolaidOrderWithNoAdditions() {
        CoffeeOrder order = new CoffeeOrder(
            Size.LARGE,
            GrindType.NONE,
            KoolaidType.RASPBERRY,
            Set.of()
        );
        
        assertNotNull(order.getAdditions());
        assertTrue(order.getAdditions().isEmpty());
        assertEquals(0, order.getAdditions().size());
    }

    @Test
    void testKoolaidOrderWithAllAdditions() {
        Set<Addition> allAdditions = new HashSet<>();
        for (Addition addition : Addition.values()) {
            allAdditions.add(addition);
        }
        
        CoffeeOrder order = new CoffeeOrder(
            Size.MEDIUM,
            GrindType.NONE,
            KoolaidType.KIWI,
            allAdditions
        );
        
        assertEquals(Addition.values().length, order.getAdditions().size());
        for (Addition addition : Addition.values()) {
            assertTrue(order.getAdditions().contains(addition));
        }
    }

    @Test
    void testKoolaidOrderBeverageTypeIsBeverageType() {
        CoffeeOrder order = new CoffeeOrder(
            Size.SMALL,
            GrindType.NONE,
            KoolaidType.PEACH,
            Set.of()
        );
        
        assertTrue(order.getBeverageType() instanceof BeverageType);
        assertTrue(order.getBeverageType() instanceof KoolaidType);
    }

    @Test
    void testMultipleKoolaidOrdersAreIndependent() {
        CoffeeOrder order1 = new CoffeeOrder(
            Size.SMALL,
            GrindType.NONE,
            KoolaidType.PEACH,
            Set.of(Addition.SUGAR)
        );
        
        CoffeeOrder order2 = new CoffeeOrder(
            Size.LARGE,
            GrindType.NONE,
            KoolaidType.RASPBERRY,
            Set.of(Addition.VANILLA)
        );
        
        assertNotEquals(order1.getSize(), order2.getSize());
        assertNotEquals(order1.getBeverageType(), order2.getBeverageType());
        assertNotEquals(order1.getAdditions(), order2.getAdditions());
    }

    @Test
    void testKoolaidOrderGrindTypeShouldBeNone() {
        // Following the pattern that non-coffee beverages should have GrindType.NONE
        for (KoolaidType type : KoolaidType.values()) {
            CoffeeOrder order = new CoffeeOrder(
                Size.MEDIUM,
                GrindType.NONE,
                type,
                Set.of()
            );
            
            assertEquals(GrindType.NONE, order.getGrindType(),
                "Koolaid orders should have grind type NONE");
        }
    }
}
