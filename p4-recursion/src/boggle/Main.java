package boggle;

import static org.junit.Assert.assertTrue;
import utils.LetterGrid;
import utils.SimpleGrid;

public class Main {

	public static void main(String[] args) {
		
         	//  -------------
			//  | F | A | Z |
			//  -------------
			//  | G | I | D |
			//  -------------
			//  | Y | T | N |
			//  -------------
	     BoggleGame game = new BoggleGame(SimpleGrid.createSimpleGridOne());
		
		/*
		 * 	r must be true
		 */
		boolean r = game.findWord("FIND");
		if(r){
			System.out.println("Found");
		}else{
			System.out.println("NOT Found");
		}

		/*
		 * path is: (0,0)
					(1,1)
					(2,2)
					(1,2)	
		 */
		String path = game.findWordPath("FIND");
		System.out.println(path);
	}

}
