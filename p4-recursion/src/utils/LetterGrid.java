package utils;
import java.util.Random;

/**
 * This class represents a grid of letters for Boggle Game
 * 
 * @author UMD CS Dept
 *  
 */
public class LetterGrid {

	char[][] table;
	private final static String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rand;
	
	private int numRows;
	private int numCols;
	
	/**
	 * Constructor
	 * 
	 * @param nrows
	 * @param ncols
	 */
	public LetterGrid(int nrows, int ncols) {
		table = new char[nrows][ncols];
		rand = new Random();
		
		numRows = nrows;
		numCols = ncols;
	}
	
	/**
	 * Get the letter at specified row and column
	 * 
	 * @param row
	 * @param col
	 * @return the letter at (row,col)
	 */
	public char getLetter(int row, int col) {
		return table[row][col];
	}
	
	/**
	 * Set the letter at specified row and column
	 * 
	 * @param row
	 * @param col
	 * @param c
	 */
	public void setLetter(int row, int col, char c) {
		table[row][col] = c;
	}
	
	/**
	 * Assign a random letter at specified row and column
	 * 
	 * @param row
	 * @param col
	 */
	void assignRandomLetter(int row, int col) {
		table[row][col] = alphabets.charAt(rand.nextInt(alphabets.length()));
	}
	
	/**
	 * Get the number of rows
	 * 
	 * @return the number of rows
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * Get the number of columns
	 * 
	 * @return the number of columns
	 */
	public int getNumCols() {
		return numCols;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int r = 0; r < table.length; r++) {
			for (int c = 0; c < table[r].length; c++) {
				str.append(table[r][c] + " ");
			}
			str.append("\n");
		}
		
		return str.toString();
	}
}
