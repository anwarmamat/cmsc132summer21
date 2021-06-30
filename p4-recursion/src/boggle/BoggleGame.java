package boggle;

import java.util.Stack;

import utils.LetterGrid;

public class BoggleGame {
	
	/**
	 * The grid that contains all the letters. @see boggle.LetterGrid
	 */
	LetterGrid grid;
	
	/**
	 * The stack that stores the path when you search the word path
	 */
	Stack<String> path;
	
	/**
	 * A boolean array to mark any location (row,col) as visited
	 */
	boolean[][] visited;
	
	public BoggleGame(LetterGrid g) {
		grid = g;
	}
	
	/**
	 * implement your method here (you may write helper method)
	 * @param word
	 * @return true if "word" can be found in grid, false otherwise
	 */
	public boolean findWord(String word) {
		//TODO
	}
	
	
	/**
	 * @param word
	 * @return the path (cell index) of each letter
	 */
	public String findWordPath(String word) {
		//TODO
	}
	
	/**
	 * Determines the frequency of a word on the Boggle board. For simplicity,
	 * assume palindromes count twice.
	 * @param word
	 * @return the number of occurrences of the "word" in the grid
	 */
	public int frequency(String word) {
		//TODO
	}
}
