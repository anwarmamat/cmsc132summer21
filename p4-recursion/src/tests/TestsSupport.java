package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import utils.LetterGrid;

public class TestsSupport {

	public static LetterGrid loadGrid(String fileName) throws IOException {
		
		ArrayList<char[]> rows = new ArrayList<char[]>();
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		while(line != null) {
			char[] letters = line.replaceAll("\\s+", "").toCharArray();
			rows.add(letters);
			
			line = reader.readLine();
		}
		reader.close();
		
		int size = rows.get(0).length;
		LetterGrid grid = new LetterGrid(size,size);
		for (int r = 0; r < rows.size(); r++) {
			char[] letters = rows.get(r);
			for (int c = 0; c < letters.length; c++) {
				grid.setLetter(r, c, letters[c]);
			}
		}
		
		return grid;
	}
	
}
