# Coffee Order System

A terminal-based Java application for managing coffee orders.

## Features

- Create coffee orders with customizable properties:
  - Size (Small, Medium, Large)
  - Grind type (Whole Bean, Coarse, Medium, Fine, Extra Fine)
  - Coffee type (Espresso, Arabica, Robusta, Blend)
  - Additions (Milk, Sugar, Cream, Vanilla, Caramel)
- View all orders
- Comprehensive unit tests with high coverage

## Requirements

- Java 21 or higher
- Gradle 8.5 or higher (included via Gradle Wrapper)

## Building the Project

```bash
./gradlew build
```

## Running the Application

```bash
./gradlew run
```

Or after building:

```bash
java -jar build/libs/coffee-order-system-1.0.0.jar
```

## Running Tests

```bash
./gradlew test
```

## Test Coverage

Generate test coverage report:

```bash
./gradlew jacocoTestReport
```

View the coverage report at: `build/reports/jacoco/test/html/index.html`

Verify coverage meets minimum threshold (90%):

```bash
./gradlew jacocoTestCoverageVerification
```

## Project Structure

```
src/
├── main/java/com/example/coffee/
│   ├── Addition.java           # Enum for order additions
│   ├── CoffeeOrder.java        # Coffee order model
│   ├── CoffeeOrderTerminal.java # Terminal interface
│   ├── CoffeeType.java         # Enum for coffee types
│   ├── GrindType.java          # Enum for grind types
│   ├── OrderCollection.java    # Order management
│   └── Size.java               # Enum for order sizes
└── test/java/com/example/coffee/
    ├── CoffeeOrderTest.java    # Tests for CoffeeOrder
    ├── CoffeeOrderTerminalTest.java # Tests for terminal interface
    ├── EnumTest.java           # Tests for all enums
    └── OrderCollectionTest.java # Tests for OrderCollection
```

## Usage

When you run the application, you'll see a menu with the following options:

1. **Create new order**: Follow the prompts to create a new coffee order
2. **View all orders**: Display all orders that have been created
3. **Exit**: Close the application

### Example Session

```
=== Coffee Order System ===

What would you like to do?
1. Create new order
2. View all orders
3. Exit
Enter your choice (1-3): 1

=== Create New Order ===

Select size:
1. Small
2. Medium
3. Large
Enter choice (1-3): 2

Select grind type:
1. Whole Bean
2. Coarse
3. Medium
4. Fine
5. Extra Fine
Enter choice (1-5): 3

Select coffee type:
1. Espresso
2. Arabica
3. Robusta
4. Blend
Enter choice (1-4): 2

Select additions (comma-separated, or press Enter for none):
1. Milk
2. Sugar
3. Cream
4. Vanilla
5. Caramel
Enter choices (e.g., 1,3,5): 1,2

✓ Order created successfully!
Order ID: 550e8400-e29b-41d4-a716-446655440000
```

## Design

The application follows object-oriented design principles:

- **Enums** for type-safe representation of fixed options
- **Immutable collections** to protect data integrity
- **Input validation** to ensure data quality
- **Separation of concerns** between model, collection management, and UI
- **Comprehensive error handling** for user input
