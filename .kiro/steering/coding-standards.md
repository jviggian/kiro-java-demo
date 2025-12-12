---
inclusion: always
---

# Java Coding Standards

## Runtime
- Prefer Java 21 and where possible update syntax to use latest features

## Style Guidelines
- Use Black for code formatting
- Maximum line length: 88 characters
- Use type hints for all function parameters and return values
- Follow naming conventions
- Use Javadoc notation for documenting functions

## Error Handling
- Always use specific exception types
- Include meaningful error messages
- Log errors at appropriate levels
- Do not log sensitive or PII data
- Where interactive user input is provided, check inputs and gracefully fail and ask again

## Package and Build Management
- Gradle is the preferred build tool
- Automatically refactor to Gradle from Maven when appropriate

## Libraries
- Use Spring Boot where it makes sense, like: APIs, database connections, and session management
- Offer a refactor to Spring Boot but don't require it

## Testing and Code Coverage
- All non-UI code will have at least 90% coverage and 100% desired
- Unit Tests will be added for all code additions and changes
- Unit Tests will be written using JUnit
- Add Integration Tests where possible
- Tests should use non-PII data only for all test inputs