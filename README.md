# String Calculator TDD Kata

A small Java implementation of the String Calculator kata, created to practise test-driven development. The tests document the supported behavior and the production code implements each rule.

## Supported behavior

- An empty string returns `0`.
- One or more numbers can be separated by commas or newlines.
- A single-character custom delimiter can be declared with `//<delimiter>\n`.
- Negative numbers are rejected and all negative values are included in the exception message.
- Values greater than `1000` are ignored without preventing later values from being added.

## Requirements

- Java 8 or newer
- Maven 3.x

## Run the tests

```bash
mvn test
```

This repository is an educational exercise rather than a production library. Build output and IDE-specific files are intentionally excluded from version control.
