package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.io.IOException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Ignore;
import org.junit.Test;
import imageblocks.ImageBlocks;
import utils.Picture;
import utils.LetterGrid;
import utils.SimpleGrid;
import boggle.BoggleGame;

public class Tests{
	
	@Test
	public void testBoggleOne() throws IOException {
		
		BoggleGame game = new BoggleGame(SimpleGrid.createSimpleGridOne());
		
		// these should be true
		assertTrue(game.findWord("FIND"));
		assertTrue(game.findWord("AID"));
		assertTrue(game.findWord("FIT"));
		
		// notice that the following should be false
		String path = game.findWordPath("ADA");
		assertFalse(game.findWord("ADA"));
	}
	
	@Test
	public void testBoggleTwo() throws IOException {
		
		BoggleGame game = new BoggleGame(SimpleGrid.createSimpleGridOne());
		
		// these should be true
		String path = game.findWordPath("FIND");
		assertTrue(path.replaceAll("\\s+", "").equals("(0,0)(1,1)(2,2)(1,2)"));
	}
	
	@Test 
	public void testIB1() {
		 String fileName = "images/1_0.png";
		 Picture p = new Picture(fileName);
	     ImageBlocks block = new ImageBlocks(p);
		 int c = block.countConnectedBlocks();
		 assertEquals(c,1);
	}

	@Test
	public void testIB2() {
		 String fileName = "images/1_1.png";
		 Picture p = new Picture(fileName);
	    	 ImageBlocks block = new ImageBlocks(p);
		 int c = block.countConnectedBlocks();
		 assertEquals(c,1);
	}
	
	@Test
	public void testIB3() {
		 String fileName = "images/1_2.png";
		 Picture p = new Picture(fileName);
	    	 ImageBlocks block = new ImageBlocks(p);
		 int c = block.countConnectedBlocks();
		 assertEquals(c,1);
	}
	
	@Test
	public void testIB4() {
		 String fileName = "images/1_3.png";
		 Picture p = new Picture(fileName);
	    	 ImageBlocks block = new ImageBlocks(p);
		 int c = block.countConnectedBlocks();
		 assertEquals(c,3);
	}
	
	@Test
	public void testIB5() {
		 String fileName = "images/2.png";
		 Picture p = new Picture(fileName);
	    	 ImageBlocks block = new ImageBlocks(p);
		 int c = block.countConnectedBlocks();
		 assertEquals(c,2);
	}
	
	@Test
	public void testIB6() {
		 String fileName = "images/3_1.png";
		 Picture p = new Picture(fileName);
	    	 ImageBlocks block = new ImageBlocks(p);
		 int c = block.countConnectedBlocks();
		 assertEquals(c,4);
	}
	
	@Test
	public void testIB7() {
		 String fileName = "images/3_2.png";
		 Picture p = new Picture(fileName);
	    	 ImageBlocks block = new ImageBlocks(p);
		 int c = block.countConnectedBlocks();
		 assertEquals(c,3);
	}

  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.getTestHeader()+":"+failure.getTrace());
    }
  }
}
