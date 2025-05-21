package com.calculator;

import org.junit.Test;

import com.calculator.SimpleCalculator;

import static org.junit.Assert.*;

public class SimpleCalculatorTest {
	@Test
	public void testAdd() {
		assertEquals(15, SimpleCalculator.add(10, 5));
		assertEquals(0, SimpleCalculator.add(0, 0));
		assertEquals(-5, SimpleCalculator.add(-10, 5));
	}

	@Test
	public void testSubstract() {
		assertEquals(5, SimpleCalculator.substract(10, 5));
		assertEquals(0, SimpleCalculator.substract(0, 0));
		assertEquals(-15, SimpleCalculator.substract(-10, 5));
	}

	@Test
	public void testMultiply() {
		assertEquals(50, SimpleCalculator.multiply(10, 5));
		assertEquals(0, SimpleCalculator.multiply(0, 5));
		assertEquals(-50, SimpleCalculator.multiply(-10, 5));
	}

	@Test()
	public void testDivide() {
		assertEquals(2.0, SimpleCalculator.divide(10, 5), 0.001);
		assertEquals(-2.0, SimpleCalculator.divide(-10, 5), 0.001);
		assertEquals(-1.0, SimpleCalculator.divide(10, -10), 0.001);
		assertEquals(1.0, SimpleCalculator.divide(-10, -10), 0.001);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		SimpleCalculator.divide(10, 0);
	}
}
