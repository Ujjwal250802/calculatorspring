package com.example.calculator;  // Package name for organizing related classes

import com.example.calculator.service.CalculatorService; // Importing the CalculatorService class
import org.junit.jupiter.api.Test;                       // Importing the JUnit 5 Test annotation
import static org.junit.jupiter.api.Assertions.*;        // Importing assertion methods from JUnit
import com.example.calculator.controller.HealthCheckController;

// Test class to verify the functionality of CalculatorService
public class CalculatorApplicationTests {
	@Test
	public void testHealthEndpoint() {
		HealthCheckController controller = new HealthCheckController();
		assertEquals("Service is up and running!", controller.health());
	}

	// Creating an instance of the CalculatorService to use in test methods
	private final CalculatorService service = new CalculatorService();

	// Test method for addition operation
	@Test
	void testAddition() {
		// Verifies that 2 + 3 equals 5
		assertEquals(5, service.calculate(2, 3, "+"));
	}

	// Test method for subtraction operation
	@Test
	void testSubtraction() {
		// Verifies that 4 - 3 equals 1
		assertEquals(1, service.calculate(4, 3, "-"));
	}

	// Test method for multiplication operation
	@Test
	void testMultiplication() {
		// Verifies that 4 * 5 equals 20
		assertEquals(20, service.calculate(4, 5, "*"));
	}

	// Test method for division operation
	@Test
	void testDivision() {
		// Verifies that 5 / 2 equals 2.5
		assertEquals(2.5, service.calculate(5, 2, "/"));
	}

	// Test method for division by zero
	@Test
	void testDivisionByZero() {
		// Verifies that dividing by zero returns 0 (based on CalculatorService implementation)
		assertEquals(0, service.calculate(5, 0, "/"));
	}

	// Test method for invalid operator input
	@Test
	void testInvalidOperator() {
		// Verifies that using an invalid operator (%) throws an IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(2, 2, "%");
		});
	}
}
