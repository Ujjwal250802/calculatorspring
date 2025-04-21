package com.example.calculator;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorApplicationTests {

	private final CalculatorService service = new CalculatorService();

	@Test
	void testAddition() {
		assertEquals(5, service.calculate(2, 3, "+"));
	}

	@Test
	void testSubtraction() {
		assertEquals(1, service.calculate(4, 3, "-"));
	}

	@Test
	void testMultiplication() {
		assertEquals(20, service.calculate(4, 5, "*"));
	}

	@Test
	void testDivision() {
		assertEquals(2.5, service.calculate(5, 2, "/"));
	}

	@Test
	void testDivisionByZero() {
		assertEquals(0, service.calculate(5, 0, "/"));
	}

	@Test
	void testInvalidOperator() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(2, 2, "%");
		});
	}
}
