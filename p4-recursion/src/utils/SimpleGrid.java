package utils;


public class SimpleGrid {
	public static LetterGrid createSimpleGridOne() {
		// create grid
		//  -------------
		//  | F | A | Z |
		//  -------------
		//  | G | I | D |
		//  -------------
		//  | Y | T | N |
		//  -------------
		
		LetterGrid grid = new LetterGrid(3,3);
		
		grid.setLetter(0, 0, 'F');
		grid.setLetter(0, 1, 'A');
		grid.setLetter(0, 2, 'Z');
		grid.setLetter(1, 0, 'G');
		grid.setLetter(1, 1, 'I');
		grid.setLetter(1, 2, 'D');
		grid.setLetter(2, 0, 'Y');
		grid.setLetter(2, 1, 'T');
		grid.setLetter(2, 2, 'N');
		
		return grid;
	}

}
