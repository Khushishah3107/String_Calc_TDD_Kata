package org.example.calculatorDriver;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int calculate(String numbers, Operation operation) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] nums = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int result;

        // Initialize result differently for each operation
        switch (operation) {
            case ADD:
            case SUBTRACT:
                result = 0;
                break;
            case MULTIPLY:
            case DIVIDE:
                result = Integer.parseInt(nums[0]);
                break;
            default:
                throw new UnsupportedOperationException("Operation not supported");
        }

        // Skip the first number for multiplication and division
        int startIndex = (operation == Operation.MULTIPLY || operation == Operation.DIVIDE) ? 1 : 0;

        for (int i = startIndex; i < nums.length; i++) {
            int number = Integer.parseInt(nums[i]);
            if (number < 0) {
                negatives.add(number);
            } else {
                switch (operation) {
                    case ADD:
                        result += number;
                        break;
                    case SUBTRACT:
                        result -= number;
                        break;
                    case MULTIPLY:
                        result *= number;
                        break;
                    case DIVIDE:
                        if (number == 0) {
                            throw new IllegalArgumentException("Division by zero is not allowed.");
                        }
                        result /= number;
                        break;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives.toString().replaceAll("[\\[\\] ]", ""));
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println("Sum of '1,2,3' is: " + calculate("1,2,3", Operation.ADD));
        System.out.println("Difference of '1,2,3' is: " + calculate("1,2,3", Operation.SUBTRACT));
        System.out.println("Product of '1,2,3' is: " + calculate("1,2,3", Operation.MULTIPLY));
        System.out.println("Quotient of '4,2' is: " + calculate("4,2", Operation.DIVIDE));

        try {
            calculate("1,-2,3", Operation.ADD);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            calculate("1,-2,-3", Operation.ADD);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
