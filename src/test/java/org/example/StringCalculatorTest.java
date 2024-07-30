package org.example;

import static org.junit.Assert.*;

import org.example.calculatorDriver.Operation;
import org.example.calculatorDriver.StringCalculator;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testAddition() {
        assertEquals(6, StringCalculator.calculate("1,2,3", Operation.ADD));
    }

    @Test
    public void testSubtraction() {
        assertEquals(-6, StringCalculator.calculate("1,2,3", Operation.SUBTRACT));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, StringCalculator.calculate("1,2,3", Operation.MULTIPLY));
    }

    @Test
    public void testDivision() {
        assertEquals(2, StringCalculator.calculate("4,2", Operation.DIVIDE));
    }

    @Test
    public void testDivisionByZero() {
        try {
            StringCalculator.calculate("6,0", Operation.DIVIDE);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }

    @Test
    public void testNegativeNumbers() {
        try {
            StringCalculator.calculate("1,-2,3", Operation.ADD);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: -2", e.getMessage());
        }
    }

    @Test
    public void testMultipleNegativeNumbers() {
        try {
            StringCalculator.calculate("1,-2,-3", Operation.ADD);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: -2,-3", e.getMessage());
        }
    }
}