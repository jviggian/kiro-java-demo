package com.example.coffee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Interactive terminal application for managing coffee orders.
 * Provides a menu-driven interface for creating and viewing orders.
 */
public class CoffeeOrderTerminal {
    private final OrderCollection orderCollection;
    private final Scanner scanner;

    /**
     * Creates a new terminal with default dependencies.
     */
    public CoffeeOrderTerminal() {
        this.orderCollection = new OrderCollection();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates a new terminal with provided dependencies for testing.
     * 
     * @param orderCollection the order collection to use
     * @param scanner the scanner for input
     */
    public CoffeeOrderTerminal(OrderCollection orderCollection, Scanner scanner) {
        this.orderCollection = orderCollection;
        this.scanner = scanner;
    }

    /**
     * Main entry point for the coffee order terminal application.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal();
        terminal.run();
    }

    /**
     * Runs the main application loop, displaying menus and handling user input.
     */
    public void run() {
        System.out.println("=== Coffee Order System ===");
        
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            
            running = switch (choice) {
                case "1" -> {
                    createNewOrder();
                    yield true;
                }
                case "2" -> {
                    viewOrders();
                    yield true;
                }
                case "3" -> {
                    System.out.println("Thank you for using the Coffee Order System!");
                    yield false;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.\n");
                    yield true;
                }
            };
        }
        
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Create new order");
        System.out.println("2. View all orders");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
    }

    private void createNewOrder() {
        System.out.println("\n=== Create New Order ===");
        
        Size size = selectSize();
        if (size == null) return;
        
        BeverageType beverageType = selectBeverageType();
        if (beverageType == null) return;
        
        GrindType grindType;
        if (beverageType instanceof SodaType) {
            grindType = GrindType.NONE;
            System.out.println("Grind type automatically set to 'None' for soda orders.");
        } else {
            grindType = selectGrindType();
            if (grindType == null) return;
        }
        
        Set<Addition> additions = selectAdditions();
        
        CoffeeOrder order = new CoffeeOrder(size, grindType, beverageType, additions);
        orderCollection.addOrder(order);
        
        System.out.println("\n✓ Order created successfully!");
        System.out.println("Order ID: " + order.getOrderId());
    }

    private Size selectSize() {
        while (true) {
            System.out.println("\nSelect size:");
            Size[] sizes = Size.values();
            for (int i = 0; i < sizes.length; i++) {
                System.out.println((i + 1) + ". " + sizes[i].getDisplayName());
            }
            System.out.print("Enter choice (1-" + sizes.length + "): ");
            
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= sizes.length) {
                    return sizes[choice - 1];
                }
                System.out.println("Invalid choice. Please enter a number between 1 and " + 
                                 sizes.length);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private GrindType selectGrindType() {
        while (true) {
            System.out.println("\nSelect grind type:");
            GrindType[] grindTypes = GrindType.values();
            for (int i = 0; i < grindTypes.length; i++) {
                System.out.println((i + 1) + ". " + grindTypes[i].getDisplayName());
            }
            System.out.print("Enter choice (1-" + grindTypes.length + "): ");
            
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= grindTypes.length) {
                    return grindTypes[choice - 1];
                }
                System.out.println("Invalid choice. Please enter a number between 1 and " + 
                                 grindTypes.length);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private BeverageType selectBeverageType() {
        while (true) {
            System.out.println("\nSelect beverage category:");
            System.out.println("1. Coffee");
            System.out.println("2. Soda");
            System.out.print("Enter choice (1-2): ");
            
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice == 1) {
                    return selectCoffeeType();
                } else if (choice == 2) {
                    return selectSodaType();
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private CoffeeType selectCoffeeType() {
        while (true) {
            System.out.println("\nSelect coffee type:");
            CoffeeType[] coffeeTypes = CoffeeType.values();
            for (int i = 0; i < coffeeTypes.length; i++) {
                System.out.println((i + 1) + ". " + coffeeTypes[i].getDisplayName());
            }
            System.out.print("Enter choice (1-" + coffeeTypes.length + "): ");
            
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= coffeeTypes.length) {
                    return coffeeTypes[choice - 1];
                }
                System.out.println("Invalid choice. Please enter a number between 1 and " + 
                                 coffeeTypes.length);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private SodaType selectSodaType() {
        while (true) {
            System.out.println("\nSelect soda type:");
            SodaType[] sodaTypes = SodaType.values();
            for (int i = 0; i < sodaTypes.length; i++) {
                System.out.println((i + 1) + ". " + sodaTypes[i].getDisplayName());
            }
            System.out.print("Enter choice (1-" + sodaTypes.length + "): ");
            
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= sodaTypes.length) {
                    return sodaTypes[choice - 1];
                }
                System.out.println("Invalid choice. Please enter a number between 1 and " + 
                                 sodaTypes.length);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private Set<Addition> selectAdditions() {
        Set<Addition> selectedAdditions = new HashSet<>();
        
        System.out.println("\nSelect additions (comma-separated, or press Enter for none):");
        Addition[] additions = Addition.values();
        for (int i = 0; i < additions.length; i++) {
            System.out.println((i + 1) + ". " + additions[i].getDisplayName());
        }
        System.out.print("Enter choices (e.g., 1,3,5): ");
        
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return selectedAdditions;
        }
        
        String[] choices = input.split(",");
        for (String choice : choices) {
            try {
                int index = Integer.parseInt(choice.trim());
                if (index >= 1 && index <= additions.length) {
                    selectedAdditions.add(additions[index - 1]);
                } else {
                    System.out.println("Warning: Skipping invalid choice: " + choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Warning: Skipping invalid input: " + choice);
            }
        }
        
        return selectedAdditions;
    }

    private void viewOrders() {
        System.out.println("\n=== All Orders ===");
        
        if (orderCollection.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        
        System.out.println("Total orders: " + orderCollection.getOrderCount());
        System.out.println();
        
        for (CoffeeOrder order : orderCollection.getAllOrders()) {
            System.out.println(order);
        }
    }

    /**
     * Gets the order collection used by this terminal.
     * 
     * @return the order collection
     */
    public OrderCollection getOrderCollection() {
        return orderCollection;
    }
}
