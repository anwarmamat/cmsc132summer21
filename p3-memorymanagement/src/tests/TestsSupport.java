package tests;

import static org.junit.Assert.assertTrue;

import manager.Block;

public class TestsSupport {
	public static int countAvailableBlocks(Block current) {
		int count = 0;
		while(current != null) {
			count++;
			current = current.nextBlock;
		}
		
		return count;
	}
	
	public static void assertAvailableBlockList(Block current, int[] sizes) {
		int i = 0;
		
		while(current != null) {
			assertTrue("Expected block of size " + current.size + " but found block of size " + sizes[i], current.size == sizes[i]);
			current = current.nextBlock;
			i++;
		}
		
		assertTrue(i == sizes.length);
	}
}
