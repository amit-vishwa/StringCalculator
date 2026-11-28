# String Calculator TDD Kata

A small Java kata demonstrating test-driven development and regression tests for interacting parsing rules. The public entry point is `StringCalculator.add(String)` in [`StringCalculator.java`](src/main/java/com/mycompany/stringcalculatortdd/StringCalculator.java).

## Quick start

Prerequisites: a JDK and Maven installed on your PATH. The build has been verified with Java 17 and Maven 3.10.0. The POM sets Java 8 source/target compatibility; this is not evidence of execution on a Java 8 runtime.

```bash
git clone https://github.com/amit-vishwa/StringCalculator.git
cd StringCalculator
mvn --batch-mode --no-transfer-progress verify
```

A successful run executes the current 13 tests and packages `target/StringCalculatorTDD-1.0-SNAPSHOT.jar`. This is a library-style kata: use the static method from Java code or run the tests to exercise it; the JAR has no command-line entry point.

## Calculator rules

- `null` and an empty string return `0`.
- Commas and newlines separate numbers by default.
- A custom delimiter is declared as `//<delimiter>` followed by a newline. The delimiter is interpreted literally, including regex characters such as `.` and `|`, and replaces the default separators.
- Negative numbers cause an `IllegalArgumentException`. Its message lists all negatives in input order.
- Values greater than `1000` are ignored. Exactly `1000` is included, and parsing continues after ignored values.
- An incomplete custom-delimiter declaration is rejected with `IllegalArgumentException`.

Operands are parsed as Java `int` values, and the sum is also an `int`.

## Usage examples

In these Java string literals, `\n` represents a newline:

```java
import com.mycompany.stringcalculatortdd.StringCalculator;

// Call these expressions from a Java method, such as a test.
StringCalculator.add("");                         // 0
StringCalculator.add(null);                       // 0
StringCalculator.add("1\n2,3");                   // 6
StringCalculator.add("1000,2");                   // 1002
StringCalculator.add("2,1001,3,1002,1000");        // 1005
StringCalculator.add("//|\n2|1001|3|1002|1000");   // 1005
```

For `StringCalculator.add("//|\n-1|1001|2|-3|1000")`, the exception message is `Negatives not allowed: -1,-3`. Ignoring `1001` does not suppress negative-number validation.

## Tests and build output

Run only the tests:

```bash
mvn --batch-mode --no-transfer-progress test
```

Run the full verification and package the JAR:

```bash
mvn --batch-mode --no-transfer-progress verify
```

[`StringCalculatorTest.java`](src/test/java/com/mycompany/stringcalculatortdd/StringCalculatorTest.java) covers empty/null input, ordinary sums, mixed separators, literal custom delimiters, negative aggregation, the inclusive `1000` boundary, ignored values and malformed declarations. The interaction tests additionally combine repeated ignored values, literal pipe delimiters and negative aggregation. See [PR #3](https://github.com/amit-vishwa/StringCalculator/pull/3) for that focused addition.

Maven writes test reports to `target/surefire-reports/`. If verification fails, inspect those reports before committing. The repository currently has no GitHub Actions workflow; the validation above is local Maven verification. Generated output and IDE-specific files are excluded from version control.
