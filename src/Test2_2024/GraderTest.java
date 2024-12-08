package Test2_2024;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraderTest {

	@Test
	void fiftyNineShouldReturnF() {
		Grader grader = new Grader();
		assertEquals('F', grader.determineLetterGrader(59));
	}

	@Test
	void eightySHouldReturnB() {
		Grader grader = new Grader();
		assertEquals('B', grader.determineLetterGrader(80));
	}

	@Test
	void negativeOneSouldReturnIllegalArgumentException() {
		Grader grader = new Grader();
		assertThrows(IllegalArgumentException.class,
		() -> {
			grader.determineLetterGrader(-1);
		});

	}

}

