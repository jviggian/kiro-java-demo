package com.example.coffee;

import java.util.*;

/**
 * Terminal interface for creating and managing coffee orders.
 * Provides an interactive command-line interface for users to place orders.
 */
public class CoffeeOrderTerminal {
    private final Scanner scanner;
    private final OrderCollection orderCollection;

    /**
     * Creates a new coffee order terminal with default scanner and order collection.
     */
    public CoffeeOrderTerminal() {
        this.scanner = new Scanner(System.in);
        this.orderCollection = new OrderCollection();
    }

    /**
     * Creates a new coffee order terminal with specified scanner and order collection.
     * 
     * @param scanner the scanner to use for reading input
     * @param orderCollection the collection to manage orders
     */
    public CoffeeOrderTerminal(Scanner scanner, OrderCollection orderCollection) {
        this.scanner = scanner;
        this.orderCollection = orderCollection;
    }

    /**
     * Starts the interactive terminal interface.
     * Displays menu and processes user commands until exit is selected.
     */
    public void start() {
        System.out.println("Welcome to the Coffee Order System!");
        
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1" -> createNewOrder();
                case "2" -> viewAllOrders();
                case "3" -> {
                    System.out.println("Thank you for using the Coffee Order System!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Create New Order");
        System.out.println("2. View All Orders");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createNewOrder() {
        System.out.println("\n=== Create New Order ===");
        
        Size size = selectSize();
        if (size == null) return;
        
        BeverageType beverageType = selectBeverageType();
        if (beverageType == null) return;
        
        GrindType grindType;
        if (beverageType instanceof SodaType || beverageType instanceof KoolaidType) {
            grindType = GrindType.NONE;
            System.out.println("Grind type automatically set to 'None' for non-coffee orders.");
        } else {
            grindType = selectGrindType();
            if (grindType == null) return;
        }
        
        Set<Addition> additions = selectAdditions();
        
        CoffeeOrder order = new CoffeeOrder(size, grindType, beverageType, additions);
        orderCollection.addOrder(order);
        
        System.out.println("\nOrder created successfully!");
        System.out.println(order);
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
                System.out.println("Invalid choice. Please enter a number between 1 and " + sizes.length);
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
                System.out.println("Invalid choice. Please enter a number between 1 and " + grindTypes.length);
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
            System.out.println("3. Koolaid");
            System.out.print("Enter choice (1-3): ");
            
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                return switch (choice) {
                    case 1 -> selectCoffeeType();
                    case 2 -> selectSodaType();
                    case 3 -> selectKoolaidType();
                    default -> {
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        yield null;
                    }
                };
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

    private KoolaidType selectKoolaidType() {
        while (true) {
            System.out.println("\nSelect Koolaid type:");
            KoolaidType[] koolaidTypes = KoolaidType.values();
            for (int i = 0; i < koolaidTypes.length; i++) {
                System.out.println((i + 1) + ". " + koolaidTypes[i].getDisplayName());
            }
            System.out.print("Enter choice (1-" + koolaidTypes.length + "): ");
            
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= koolaidTypes.length) {
                    return koolaidTypes[choice - 1];
                }
                System.out.println("Invalid choice. Please enter a number between 1 and " + 
                                 koolaidTypes.length);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private Set<Addition> selectAdditions() {
        Set<Addition> selectedAdditions = new HashSet<>();
        
        System.out.println("\nSelect additions (enter numbers separated by commas, or press Enter for none):");
        Addition[] additions = Addition.values();
        for (int i = 0; i < additions.length; i++) {
            System.out.println((i + 1) + ". " + additions[i].getDisplayName());
        }
        System.out.print("Enter choices: ");
        
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return selectedAdditions;
        }
        
        String[] choices = input.split(",");
        for (String choiceStr : choices) {
            try {
                int choice = Integer.parseInt(choiceStr.trim());
                if (choice >= 1 && choice <= additions.length) {
                    selectedAdditions.add(additions[choice - 1]);
                } else {
                    System.out.println("Skipping invalid choice: " + choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid input: " + choiceStr);
            }
        }
        
        return selectedAdditions;
    }

    private void viewAllOrders() {
        System.out.println("\n=== All Orders ===");
        List<CoffeeOrder> orders = orderCollection.getAllOrders();
        
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("\nOrder #" + (i + 1) + ":");
            System.out.println(orders.get(i));
        }
    }

    /**
     * Main method to run the coffee order terminal.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        CoffeeOrderTerminal terminal = new CoffeeOrderTerminal();
        terminal.start();
    }
}
