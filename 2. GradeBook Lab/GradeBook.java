
/**
@author Emran Abbamacha
 */

import java.util.ArrayList;

public class GradeBook {
	private double[] scores;
	private int scoresSize;

	/**
	 * Constructs a gradebook with no scores and a given capacity.
	 * 
	 * @capacity the maximum number of scores in this gradebook
	 */
	public GradeBook(int capacity) {
		scores = new double[capacity];
		scoresSize = 0;
	} // end GradeBook

	/**
	 * Adds a score to this gradebook.
	 * 
	 * @param score the score to add
	 * @return true if the score was added, false if the gradebook is full
	 */
	public boolean addScore(double score) {
		if (scoresSize < scores.length) {
			scores[scoresSize] = score;
			scoresSize++;
			return true;
		} else
			return false;
	} // end addScore

	/**
	 * Computes the sum of the scores in this gradebook.
	 * 
	 * @return the sum of the scores
	 */
	public double sum() {
		double total = 0;
		for (int i = 0; i < scoresSize; i++) {
			total = total + scores[i];
		}
		return total;
	} // end sum

	/**
	 * Gets the minimum score in this gradebook.
	 * 
	 * @return the minimum score, or 0 if there are no scores.
	 */
	public double minimum() {
		double smallest = -99;

		if (scoresSize == 0) {
			return 0;
		} else {
			for (int i = 1; i < scoresSize; i++) {
				if (scores[i] < smallest) {
					smallest = scores[i];
				}
			}
		}

		return smallest;
	} // end minimum

	/**
	 * Gets the final score for this gradebook.
	 * 
	 * @return the sum of the scores, with the lowest score dropped if there are at
	 *         least two scores, or 0 if there are no scores.
	 */
	public double finalScore() {
		if (scoresSize == 0)
			return 0;
		else if (scoresSize == 1)
			return scores[0];
		else
			return sum() - minimum();
	} // end finalScore

	/**
	 * Gets the size of scores for this gradebook.
	 * 
	 * @return the size of the scores
	 */
	public int getScoresSize() {
		return scoresSize;
	} // end getScoresSize

	/**
	 * Print each score as a string with a space in between.
	 * 
	 * @return a string with each score in scores separated by space
	 */
	public String toString() {
		String scoreString = "";
		for (int i = 0; i < scoresSize; i++) {
			scoreString += scores[i] + " ";
		}
		return scoreString.trim();
	} // end toString

} // end GradeBook class
