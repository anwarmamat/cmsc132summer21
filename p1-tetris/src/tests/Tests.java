package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import model.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tests{
	final int ROWS = 22, COLS = 10;
	
	@Test
	public void testMoveDown() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(6);  // S
		
		// first piece appearance
		assertTrue(correctResults("data/pubStartS.txt", game.toString()));

		process(Action.MOVEDOWN, game, 4);
		assertTrue(correctResults("data/pubTestMoveDown.txt", game.toString()));
	}
	
	@Test
	public void testMoveRight() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(3);  // T
		
		// first piece appearance
		assertTrue(correctResults("data/pubStartT.txt", game.toString()));

		process(Action.MOVERIGHT, game, 3);
		assertTrue(correctResults("data/pubTestMoveRight.txt", game.toString()));
	}
	
	@Test
	public void testMoveLeft() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(4);  // J
		
		// first piece appearance
		assertTrue(correctResults("data/pubStartJ.txt", game.toString()));

		process(Action.MOVELFT, game, 2);
		assertTrue(correctResults("data/pubTestMoveLeft.txt", game.toString()));
	}
	
	@Test
	public void testFall() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(1);  // I
		
		// first piece appearance
		assertTrue(correctResults("data/pubStartI.txt", game.toString()));

		process(Action.FALL, game, 4);
		assertTrue(correctResults("data/pubTestFall.txt", game.toString()));
	}
	
	@Test
	public void simpleIRotate() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(1);
		
		//initial placement
		assertTrue(correctResults("data/pubStartI.txt", game.toString()));

		//rotates 4 times and checks
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubIRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubIRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubIRotate3.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubIRotate4.txt", game.toString()));
	}
	
	@Test
	public void simpleORotate() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(2);
		
		//initial placement
		assertTrue(correctResults("data/pubStartO.txt", game.toString()));

		//rotates 4 times and checks
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubStartO.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubStartO.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubStartO.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubStartO.txt", game.toString()));
	}

	@Test
	public void simpleTRotate() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(3);
		
		//rotate which should not work
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubStartT.txt", game.toString()));

		//rotates should work. Does 4 of them
		//move down so rotation is possible
		game.processCell(Action.MOVEDOWN);
		assertTrue(correctResults("data/pubTRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubTRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubTRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubTRotate3.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubTRotate0.txt", game.toString()));
	}

	@Test
	public void simpleJRotate() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(4);
		
		//initial placement
		assertTrue(correctResults("data/pubStartJ.txt", game.toString()));

		//does four rotates to check
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubJRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubJRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubJRotate3.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubJRotate0.txt", game.toString()));
	}

	@Test
	public void simpleLRotate() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(5);
		
		//initial placement
		assertTrue(correctResults("data/pubStartL.txt", game.toString()));
		
		//does four rotates to check
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubLRotate1.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubLRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubLRotate3.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubLRotate0.txt", game.toString()));
	}

	@Test
	public void simpleSRotate() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(6);

		//rotate which should not work
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubStartS.txt", game.toString()));

		//rotates should work, rotates 4 times
		//move down first to allow rotation
		game.processCell(Action.MOVEDOWN);
		assertTrue(correctResults("data/pubSRotate0.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubSRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubSRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubSRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubSRotate0.txt", game.toString()));
	}

	@Test
	public void simpleZRotate() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(7);

		//rotate which should not work
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubStartZ.txt", game.toString()));

		//rotates should work, rotates 4 times
		//move down first to allow rotation
		game.processCell(Action.MOVEDOWN);
		assertTrue(correctResults("data/pubZRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubZRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubZRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubZRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(correctResults("data/pubZRotate0.txt", game.toString()));
	}
	
	@Test
	public void testGame0() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(7);
		process(Action.MOVERIGHT, game, 3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		process(Action.MOVELFT, game, 5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		process(Action.MOVELFT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		process(Action.MOVEDOWN, game, 3);
		game.processCell(Action.ROTATE);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		process(Action.MOVELFT, game, 2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(7);
		process(Action.MOVELFT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(4);
		process(Action.MOVERIGHT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVERIGHT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 2);
		process(Action.ROTATE, game, 2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		process(Action.MOVERIGHT, game, 2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		process(Action.MOVERIGHT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		game.processCell(Action.FALL);
		
		assertTrue(correctResults("data/pubTestGame0.txt", game.toString()));
	}

	@Test
	public void testGame1() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 6);
		game.processCell(Action.ROTATE);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		process(Action.MOVEDOWN, game, 3);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(7);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(2);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 3);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(5);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.ROTATE);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.MOVERIGHT);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(4);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.MOVELFT);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(1);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(5);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(2);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(2);
		game.processCell(Action.MOVEDOWN);
		
		assertTrue(correctResults("data/pubTestGame1.txt", game.toString()));
	}

	@Test
	public void testGame2() {
		Tetris game = new Tetris(COLS, ROWS);
		game.nextAnimationStep(1);
		process(Action.MOVELFT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(4);
		process(Action.MOVERIGHT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		process(Action.MOVELFT, game, 5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 2);
		process(Action.MOVERIGHT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.MOVERIGHT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		process(Action.MOVERIGHT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVELFT);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(7);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		game.processCell(Action.FALL);
		game.nextAnimationStep(4);
		game.processCell(Action.FALL);
		game.processCell(Action.FALL);
		game.nextAnimationStep(7);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.FALL);
		
		assertTrue(correctResults("data/pubTestGame2.txt", game.toString()));
	}
	
	/**
	 * Performs processCell on the game with the given action, N times
	 * @param action
	 * @param game
	 * @param N
	 */
	private void process(Action action, Game game, int N) {
		for (int i = 0; i < N; i++) {
			game.processCell(action);
		}
	}
	





	

	
	/**
	 * Reads the encoded instructions of the in file and plays the game accordingly
	 * To create in files for loading, call writeToFile with append set to true in
	 * nextAnimationStep and processCell.  Then play the game to log events.
	 * @param filename
	 * @param game
	 */
	private void loadGame(String filename, Game game) {
		try {
            BufferedReader fin = new BufferedReader(new FileReader(filename));
           
            String line;
            while ((line = fin.readLine()) != null) {
                switch(line) {
                case "ML": game.processCell(Action.MOVELFT);
                	break;
                case "MD": game.processCell(Action.MOVEDOWN);
                	break;
                case "MR": game.processCell(Action.MOVERIGHT);
                	break;
                case "R": game.processCell(Action.ROTATE);
                	break;
                case "F": game.processCell(Action.FALL);
                	break;
                default: game.nextAnimationStep(Integer.parseInt(line));
                	break;
                }
            }
            fin.close();
            
        }catch (IOException e) {
            System.out.println("File opening failed.");
        } 
	}

	public static boolean correctResults(String filename, String results) {
		String officialResults="";
        try {
            BufferedReader fin = new BufferedReader(new FileReader(filename));
           
            String line;
            while ((line = fin.readLine()) != null) {
                officialResults += line + "\n";
            }
            fin.close();
            
        }catch (IOException e) {
            System.out.println("File opening failed.");
            return false;
        } 
        
        if (results.equals(officialResults)) {
            return true;
        }
        
        return false;
    }
	
	/**
	 * Writes content to a file called filename
	 * @param filename
	 * @param content
	 */
	public static void writeToFile(String filename, String content, boolean append) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
					filename, append));
			bufferedWriter.write(content);
			
			bufferedWriter.close(); 
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
