# Quick Start Guide

## Prerequisites
- Java 21 or higher installed
- No additional dependencies needed (Gradle Wrapper included)

## Build and Run

### 1. Build the Project
```bash
./gradlew build
```

### 2. Run Tests
```bash
./gradlew test
```

### 3. Run the Application
```bash
./gradlew run
```

## Using the Application

### Main Menu
When you start the application, you'll see:
```
=== Coffee Order System ===

What would you like to do?
1. Create new order
2. View all orders
3. Exit
Enter your choice (1-3):
```

### Creating an Order
1. Enter `1` to create a new order
2. Select size: `1` (Small), `2` (Medium), or `3` (Large)
3. Select grind type: `1` (Whole Bean), `2` (Coarse), `3` (Medium), `4` (Fine), or `5` (Extra Fine)
4. Select coffee type: `1` (Espresso), `2` (Arabica), `3` (Robusta), or `4` (Blend)
5. Select additions: Enter comma-separated numbers (e.g., `1,2,5`) or press Enter for none
   - `1` = Milk
   - `2` = Sugar
   - `3` = Cream
   - `4` = Vanilla
   - `5` = Caramel

### Viewing Orders
1. Enter `2` from the main menu
2. All orders will be displayed with their details

### Exiting
Enter `3` from the main menu to exit

## Testing

### Run All Tests
```bash
./gradlew test
```

### Generate Coverage Report
```bash
./gradlew jacocoTestReport
```
Report location: `build/reports/jacoco/test/html/index.html`

### Verify Coverage Threshold
```bash
./gradlew jacocoTestCoverageVerification
```

## Common Tasks

### Clean Build
```bash
./gradlew clean build
```

### Run with Logging
```bash
./gradlew run --info
```

### Run Specific Test Class
```bash
./gradlew test --tests CoffeeOrderTest
```

## Troubleshooting

### Issue: `java: command not found`
**Solution**: Install Java 21 or set JAVA_HOME environment variable

### Issue: Permission denied on gradlew
**Solution**: Make gradlew executable
```bash
chmod +x gradlew
```

### Issue: Tests failing
**Solution**: Check Java version
```bash
java -version  # Should be 21 or higher
```

## Project Structure
```
src/main/java/com/example/coffee/   # Source code
src/test/java/com/example/coffee/   # Test code
build.gradle                         # Build configuration
```

## Support
See README.md for detailed documentation and architecture information.
