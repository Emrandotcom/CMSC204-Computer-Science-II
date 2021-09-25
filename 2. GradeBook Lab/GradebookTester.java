import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	private GradeBook gradeBook1;
	private GradeBook gradeBook2;

	@BeforeEach
	void setUp() throws Exception {
		gradeBook1 = new GradeBook(3);
		gradeBook2 = new GradeBook(4);

		gradeBook1.addScore(65.0);
		gradeBook1.addScore(75.0);
		gradeBook1.addScore(85.0);

		gradeBook2.addScore(70.0);
		gradeBook2.addScore(80.0);
		gradeBook2.addScore(90.0);
		gradeBook2.addScore(100.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook1 = null;
		gradeBook2 = null;
	}

	@Test
	void testAddScore() {

		String expectedResultsBook1 = "65.0 75.0 85.0";
		String actualResultsBook1 = gradeBook1.toString();

		String expectedResultsBook2 = "70.0 80.0 90.0 100.0";
		String actualResultsBook2 = gradeBook2.toString();

		int expectedBookSize1 = 3;
		int actualBookSize1 = gradeBook1.getScoreSize();
		int expectedBookSize2 = 4;
		int actualBookSize2 = gradeBook2.getScoreSize();

		assertTrue(expectedResultsBook1.equals(actualResultsBook1));
		assertTrue(expectedResultsBook2.equals(actualResultsBook2));
		assertTrue(expectedBookSize1 == actualBookSize1);
		assertTrue(expectedBookSize2 == actualBookSize2);

	}

	@Test
	void testSum() {
		double expectedSumBook1 = 225.0;
		double actualSum1 = gradeBook1.sum();

		double expectedSumBook2 = 340.0;
		double actualSum2 = gradeBook2.sum();

		assertTrue(expectedSumBook1 == actualSum1);
		assertTrue(expectedSumBook2 == actualSum2);
	}

	@Test
	void testMinimum() {
		double expectedMinBook1 = 65.0;
		double actualMinBook1 = gradeBook1.minimum();

		double expectedMinBook2 = 70.0;
		double actualMinBook2 = gradeBook2.minimum();

		assertTrue(expectedMinBook1 == actualMinBook1);
		assertTrue(expectedMinBook2 == actualMinBook2);
	}

	@Test
	void testFinalScore() {

		double expectedFinal1 = 160.0;
		double expectedFinal2 = 270.0;

		double actualFinalBook1 = gradeBook1.finalScore();
		double actualFinalBook2 = gradeBook2.finalScore();

		assertTrue(expectedFinal1 == actualFinalBook1);
		assertTrue(expectedFinal2 == actualFinalBook2);

	}

}
