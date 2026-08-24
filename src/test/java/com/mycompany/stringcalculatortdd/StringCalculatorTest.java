package com.mycompany.stringcalculatortdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void shouldReturnZeroForNullInput() {
        assertEquals(0, StringCalculator.add(null));
    }

    @Test
    public void shouldReturnNumberForNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void shouldReturnSumForMultipleNumbers() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void shouldAcceptNewLines() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void shouldSupportADeclaredDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        assertEquals(6, StringCalculator.add("//.\n1.2.3"));
    }

    @Test
    public void shouldReportAllNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> StringCalculator.add("-1,-2,3"));

        assertEquals("Negatives not allowed: -1,-2", exception.getMessage());
    }

    @Test
    public void shouldIgnoreEveryNumberGreaterThanOneThousand() {
        assertEquals(5, StringCalculator.add("2,1001,3"));
    }

    @Test
    public void shouldIncludeOneThousand() {
        assertEquals(1002, StringCalculator.add("1000,2"));
    }

    @Test
    public void shouldRejectMalformedDelimiterDeclaration() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//\n1,2"));
    }
}
