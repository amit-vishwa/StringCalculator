package com.mycompany.stringcalculatortdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringCalculator {

    private static final int MAX_INCLUDED_VALUE = 1000;

    private StringCalculator() {
    }

    public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\\n";
        String values = numbers;
        if (numbers.startsWith("//")) {
            int declarationEnd = numbers.indexOf('\n');
            if (declarationEnd < 3) {
                throw new IllegalArgumentException("Invalid custom delimiter declaration");
            }
            delimiter = Pattern.quote(numbers.substring(2, declarationEnd));
            values = numbers.substring(declarationEnd + 1);
        }

        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String value : values.split(delimiter)) {
            if (value.isEmpty()) {
                continue;
            }
            int number = Integer.parseInt(value);
            if (number < 0) {
                negatives.add(number);
            } else if (number <= MAX_INCLUDED_VALUE) {
                sum += number;
            }
        }

        if (!negatives.isEmpty()) {
            String valuesText = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException("Negatives not allowed: " + valuesText);
        }
        return sum;
    }
}
