package Test2_2024;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

	@Test
	void twoPlusTwoShouldEqualFour() {
		SimpleCalculator calculator = new SimpleCalculator();
		assertEquals(4, calculator.add(2, 2));
	}
	
	@Test
	void twoPlusTwoIsEqualFour() {
		SimpleCalculator calculator = new SimpleCalculator();
		assertTrue(calculator.add(2, 2) == 4);
	}
	@Test
	void twoPlusTwoShouldEqualFour() {
		SimpleCalculator calculator = new SimpleCalculator();
		assertEquals(4, calculator.add(2, 2));
	}
}
