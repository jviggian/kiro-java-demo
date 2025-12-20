package com.example.coffee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderTerminalTest {

    private OrderCollection orderCollection;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        orderCollection = new OrderCollection();
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Should create terminal with default constructor")
    void shouldCreateTerminalWithDefaultConstructor() {
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal();
        assertNotNull(terminal);
        assertNotNull(terminal.getOrderCollection());
    }

    @Test
    @DisplayName("Should create terminal with provided dependencies")
    void shouldCreateTerminalWithProvidedDependencies() {
        Scanner scanner = new Scanner("3\n");
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        assertNotNull(terminal);
        assertEquals(orderCollection, terminal.getOrderCollection());
    }

    @Test
    @DisplayName("Should exit when option 3 is selected")
    void shouldExitWhenOption3IsSelected() {
        String input = "3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Thank you for using the Coffee Order System!"));
    }

    @Test
    @DisplayName("Should handle invalid menu choice")
    void shouldHandleInvalidMenuChoice() {
        String input = "invalid\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid choice"));
    }

    @Test
    @DisplayName("Should create new order with valid inputs")
    void shouldCreateNewOrderWithValidInputs() {
        // Input: Main menu option 1, Size 1, Beverage category 1 (Coffee), Coffee type 1, Grind type 1, No additions, Exit
        String input = "1\n1\n1\n1\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        assertEquals(1, orderCollection.getOrderCount());
        String output = outputStream.toString();
        assertTrue(output.contains("Order created successfully"));
    }

    @Test
    @DisplayName("Should create order with multiple additions")
    void shouldCreateOrderWithMultipleAdditions() {
        // Input: Create order, Size 2, Beverage category 1 (Coffee), Coffee type 3, Grind type 2, Additions 1,2,3, Exit
        String input = "1\n2\n1\n3\n2\n1,2,3\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        assertEquals(1, orderCollection.getOrderCount());
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(3, order.getAdditions().size());
    }

    @Test
    @DisplayName("Should create order with no additions")
    void shouldCreateOrderWithNoAdditions() {
        // Input: Create order, Size 1, Beverage category 1 (Coffee), Coffee type 1, Grind type 1, No additions, Exit
        String input = "1\n1\n1\n1\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        assertEquals(1, orderCollection.getOrderCount());
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertTrue(order.getAdditions().isEmpty());
    }

    @Test
    @DisplayName("Should handle invalid size input and retry")
    void shouldHandleInvalidSizeInputAndRetry() {
        // Input: Create order, invalid size, retry with valid size 1, rest valid, Exit
        String input = "1\ninvalid\n99\n1\n1\n1\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid input") || output.contains("Invalid choice"));
        assertEquals(1, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should handle invalid grind type input and retry")
    void shouldHandleInvalidGrindTypeInputAndRetry() {
        // Input: Create order, Size 1, Beverage category 1 (Coffee), Coffee type 1, invalid grind, valid grind 1, Exit
        String input = "1\n1\n1\n1\ninvalid\n100\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid input") || output.contains("Invalid choice"));
        assertEquals(1, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should handle invalid coffee type input and retry")
    void shouldHandleInvalidCoffeeTypeInputAndRetry() {
        // Input: Create order, Size 1, Beverage category 1 (Coffee), invalid coffee type, retry, valid coffee type 1, Exit
        String input = "1\n1\n1\ninvalid\n0\n1\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid input") || output.contains("Invalid choice"));
        assertEquals(1, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should handle invalid additions input gracefully")
    void shouldHandleInvalidAdditionsInputGracefully() {
        // Input: Create order, Size 1, Beverage category 1 (Coffee), Coffee type 1, Grind type 1, additions with invalid entries, Exit
        String input = "1\n1\n1\n1\n1\n1,invalid,99,2\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        assertEquals(1, orderCollection.getOrderCount());
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(2, order.getAdditions().size());
        String output = outputStream.toString();
        assertTrue(output.contains("Warning"));
    }

    @Test
    @DisplayName("Should view orders when collection is empty")
    void shouldViewOrdersWhenCollectionIsEmpty() {
        String input = "2\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("No orders found"));
    }

    @Test
    @DisplayName("Should view orders when collection has orders")
    void shouldViewOrdersWhenCollectionHasOrders() {
        CoffeeOrder order = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            null
        );
        orderCollection.addOrder(order);
        
        String input = "2\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Total orders: 1"));
        assertTrue(output.contains("Order ID:"));
    }

    @Test
    @DisplayName("Should create multiple orders")
    void shouldCreateMultipleOrders() {
        // Create two orders: first coffee, second soda
        String input = "1\n1\n1\n1\n1\n\n1\n2\n2\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        assertEquals(2, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should display menu options")
    void shouldDisplayMenuOptions() {
        String input = "3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("What would you like to do?"));
        assertTrue(output.contains("1. Create new order"));
        assertTrue(output.contains("2. View all orders"));
        assertTrue(output.contains("3. Exit"));
    }

    @Test
    @DisplayName("Should handle all size options")
    void shouldHandleAllSizeOptions() {
        for (int i = 1; i <= Size.values().length; i++) {
            OrderCollection collection = new OrderCollection();
            // Create order with size i, coffee category, coffee type 1, grind type 1
            String input = String.format("1\n%d\n1\n1\n1\n\n3\n", i);
            Scanner scanner = new Scanner(input);
            CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(collection, scanner);
            
            terminal.run();
            
            assertEquals(1, collection.getOrderCount());
        }
    }

    @Test
    @DisplayName("Should handle all grind type options")
    void shouldHandleAllGrindTypeOptions() {
        for (int i = 1; i <= GrindType.values().length; i++) {
            OrderCollection collection = new OrderCollection();
            // Create order with size 1, coffee category, coffee type 1, grind type i
            String input = String.format("1\n1\n1\n1\n%d\n\n3\n", i);
            Scanner scanner = new Scanner(input);
            CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(collection, scanner);
            
            terminal.run();
            
            assertEquals(1, collection.getOrderCount());
        }
    }

    @Test
    @DisplayName("Should handle all coffee type options")
    void shouldHandleAllCoffeeTypeOptions() {
        for (int i = 1; i <= CoffeeType.values().length; i++) {
            OrderCollection collection = new OrderCollection();
            // Create order with size 1, coffee category, coffee type i, grind type 1
            String input = String.format("1\n1\n1\n%d\n1\n\n3\n", i);
            Scanner scanner = new Scanner(input);
            CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(collection, scanner);
            
            terminal.run();
            
            assertEquals(1, collection.getOrderCount());
        }
    }

    @Test
    @DisplayName("Should handle all soda type options")
    void shouldHandleAllSodaTypeOptions() {
        for (int i = 1; i <= SodaType.values().length; i++) {
            OrderCollection collection = new OrderCollection();
            // Create order with size 1, soda category (2), soda type i, no additions
            String input = String.format("1\n1\n2\n%d\n\n3\n", i);
            Scanner scanner = new Scanner(input);
            CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(collection, scanner);
            
            terminal.run();
            
            assertEquals(1, collection.getOrderCount());
            CoffeeOrder order = collection.getAllOrders().get(0);
            assertTrue(order.getBeverageType() instanceof SodaType);
            assertEquals(GrindType.NONE, order.getGrindType());
        }
    }

    @Test
    @DisplayName("Should display order ID after creation")
    void shouldDisplayOrderIdAfterCreation() {
        String input = "1\n1\n1\n1\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Order ID:"));
        assertFalse(orderCollection.isEmpty());
    }

    @Test
    @DisplayName("Should automatically set grind type to NONE for soda orders")
    void shouldAutomaticallySetGrindTypeToNoneForSodaOrders() {
        // Create a soda order: size 1, soda category (2), soda type 1, no additions
        String input = "1\n1\n2\n1\n\n3\n";
        Scanner scanner = new Scanner(input);
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal(orderCollection, scanner);
        
        terminal.run();
        
        assertEquals(1, orderCollection.getOrderCount());
        CoffeeOrder order = orderCollection.getAllOrders().get(0);
        assertEquals(GrindType.NONE, order.getGrindType());
        assertTrue(order.getBeverageType() instanceof SodaType);
        String output = outputStream.toString();
        assertTrue(output.contains("Grind type automatically set to 'None' for soda orders"));
    }
}
