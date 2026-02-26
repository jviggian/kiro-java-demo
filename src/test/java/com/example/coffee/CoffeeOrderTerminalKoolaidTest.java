package com.example.coffee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CoffeeOrderTerminal Koolaid functionality.
 * Tests the integration of Koolaid selection in the order terminal.
 */
class CoffeeOrderTerminalKoolaidTest {

    private OrderCollection orderCollection;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        orderCollection = new OrderCollection();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSelectKoolaidFromBeverageMenu() {
        String input = "1\n" +  // Create new order
                       "1\n" +  // Size: Small
                       "3\n" +  // Beverage: Koolaid
                       "1\n" +  // Koolaid: Peach
                       "\n" +   // No additions
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        assertEquals(1, orderCollection.getAllOrders().size());
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertTrue(order.getBeverageType() instanceof KoolaidType);
        assertEquals(KoolaidType.PEACH, order.getBeverageType());
        assertEquals(GrindType.NONE, order.getGrindType());
    }

    @Test
    void testSelectAllKoolaidFlavors() {
        // Test Peach
        testKoolaidFlavor("1", KoolaidType.PEACH);
        
        // Test Kiwi
        orderCollection = new OrderCollection();
        testKoolaidFlavor("2", KoolaidType.KIWI);
        
        // Test Fruit Punch
        orderCollection = new OrderCollection();
        testKoolaidFlavor("3", KoolaidType.FRUIT_PUNCH);
        
        // Test Raspberry
        orderCollection = new OrderCollection();
        testKoolaidFlavor("4", KoolaidType.RASPBERRY);
    }

    private void testKoolaidFlavor(String flavorChoice, KoolaidType expectedFlavor) {
        String input = "1\n" +  // Create new order
                       "1\n" +  // Size: Small
                       "3\n" +  // Beverage: Koolaid
                       flavorChoice + "\n" +  // Koolaid flavor
                       "\n" +   // No additions
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        assertEquals(1, orderCollection.getAllOrders().size());
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(expectedFlavor, order.getBeverageType());
    }

    @Test
    void testKoolaidGrindTypeAutomaticallySetToNone() {
        String input = "1\n" +  // Create new order
                       "2\n" +  // Size: Medium
                       "3\n" +  // Beverage: Koolaid
                       "2\n" +  // Koolaid: Kiwi
                       "\n" +   // No additions
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Grind type automatically set to 'None' for non-coffee orders."));
        
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(GrindType.NONE, order.getGrindType());
    }

    @Test
    void testKoolaidWithMultipleSizes() {
        // Test Small Koolaid
        testKoolaidWithSize("1", Size.SMALL);
        
        // Test Medium Koolaid
        orderCollection = new OrderCollection();
        testKoolaidWithSize("2", Size.MEDIUM);
        
        // Test Large Koolaid
        orderCollection = new OrderCollection();
        testKoolaidWithSize("3", Size.LARGE);
    }

    private void testKoolaidWithSize(String sizeChoice, Size expectedSize) {
        String input = "1\n" +  // Create new order
                       sizeChoice + "\n" +  // Size
                       "3\n" +  // Beverage: Koolaid
                       "1\n" +  // Koolaid: Peach
                       "\n" +   // No additions
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(expectedSize, order.getSize());
        assertTrue(order.getBeverageType() instanceof KoolaidType);
    }

    @Test
    void testKoolaidWithAdditions() {
        String input = "1\n" +  // Create new order
                       "2\n" +  // Size: Medium
                       "3\n" +  // Beverage: Koolaid
                       "3\n" +  // Koolaid: Fruit Punch
                       "1,3\n" + // Additions: Milk and Cream
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(KoolaidType.FRUIT_PUNCH, order.getBeverageType());
        assertEquals(2, order.getAdditions().size());
        assertTrue(order.getAdditions().contains(Addition.MILK));
        assertTrue(order.getAdditions().contains(Addition.CREAM));
    }

    @Test
    void testMultipleKoolaidOrders() {
        String input = "1\n" +  // Create order 1
                       "1\n" +  // Size: Small
                       "3\n" +  // Beverage: Koolaid
                       "1\n" +  // Koolaid: Peach
                       "\n" +   // No additions
                       "1\n" +  // Create order 2
                       "3\n" +  // Size: Large
                       "3\n" +  // Beverage: Koolaid
                       "4\n" +  // Koolaid: Raspberry
                       "2\n" +  // Addition: Sugar
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        assertEquals(2, orderCollection.getAllOrders().size());
        
        CoffeeOrder order1 = orderCollection.getAllOrders().get(0);
        assertEquals(KoolaidType.PEACH, order1.getBeverageType());
        assertEquals(Size.SMALL, order1.getSize());
        
        CoffeeOrder order2 = orderCollection.getAllOrders().get(1);
        assertEquals(KoolaidType.RASPBERRY, order2.getBeverageType());
        assertEquals(Size.LARGE, order2.getSize());
    }

    @Test
    void testInvalidKoolaidChoiceThenValid() {
        String input = "1\n" +  // Create new order
                       "1\n" +  // Size: Small
                       "3\n" +  // Beverage: Koolaid
                       "99\n" + // Invalid Koolaid choice
                       "2\n" +  // Valid choice: Kiwi
                       "\n" +   // No additions
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid choice"));
        
        assertEquals(1, orderCollection.getAllOrders().size());
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(KoolaidType.KIWI, order.getBeverageType());
    }

    @Test
    void testKoolaidMenuDisplaysCorrectOptions() {
        String input = "1\n" +  // Create new order
                       "1\n" +  // Size: Small
                       "3\n" +  // Beverage: Koolaid
                       "1\n" +  // Koolaid: Peach
                       "\n" +   // No additions
                       "3\n";   // Exit
        
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(scanner, orderCollection);
        
        terminal.start();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Select Koolaid type:"));
        assertTrue(output.contains("1. Peach"));
        assertTrue(output.contains("2. Kiwi"));
        assertTrue(output.contains("3. Fruit Punch"));
        assertTrue(output.contains("4. Raspberry"));
    }
}
