# Coffee Order System

A terminal-based Java application for managing coffee, soda, and Koolaid orders.

## Features

- Create beverage orders with customizable properties:
  - Size (Small, Medium, Large)
  - Grind type (Whole Bean, Coarse, Medium, Fine, Extra Fine, None)
  - Coffee types (Espresso, Arabica, Robusta, Blend)
  - Soda flavors (Pepsi, Coke, Sprite, Fanta, Dr Pepper, Mountain Dew)
  - Koolaid flavors (Peach, Kiwi, Fruit Punch, Raspberry)
  - Additions (Milk, Sugar, Cream, Vanilla, Caramel)
- View all orders
- Automatic handling of grind type for soda and Koolaid orders (set to None)
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
│   ├── BeverageType.java        # Sealed interface for beverage types
│   ├── CoffeeOrder.java        # Beverage order model
│   ├── CoffeeOrderTerminal.java # Terminal interface
│   ├── CoffeeType.java         # Enum for coffee types
│   ├── GrindType.java          # Enum for grind types
│   ├── KoolaidType.java        # Enum for Koolaid flavors
│   ├── OrderCollection.java    # Order management
│   ├── SodaType.java           # Enum for soda flavors
│   └── Size.java               # Enum for order sizes
└── test/java/com/example/coffee/
    ├── CoffeeOrderTest.java    # Tests for CoffeeOrder
    ├── CoffeeOrderTerminalTest.java # Tests for terminal interface
    ├── EnumTest.java           # Tests for all enums
    └── OrderCollectionTest.java # Tests for OrderCollection
```

## Usage

When you run the application, you'll see a menu with the following options:

1. **Create new order**: Follow the prompts to create a new beverage order
2. **View all orders**: Display all orders that have been created
3. **Exit**: Close the application

When creating an order you choose a beverage category (Coffee, Soda, or Koolaid).
Soda and Koolaid orders automatically have their grind type set to 'None'.

## Design

The application follows object-oriented design principles:

- **Sealed interface** (`BeverageType`) permitting `CoffeeType`, `SodaType`, and `KoolaidType`
- **Enums** for type-safe representation of fixed options
- **Immutable collections** to protect data integrity
- **Input validation** to ensure data quality
- **Separation of concerns** between model, collection management, and UI
- **Comprehensive error handling** for user input
