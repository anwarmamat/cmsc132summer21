package tests;

import manager.Manager;
import manager.Block;

import static tests.TestsSupport.assertAvailableBlockList;
import static tests.TestsSupport.countAvailableBlocks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class Tests {

	@Test
	public void testMemorySetup() {
		int sizes[] = new int[] {1, 2, 2, 1, 3, 4, 5, 6 ,7, 8};
		Manager manager = new Manager(sizes);
		
		ArrayList<Block> memory = manager.getMemory();
		for(int i =0; i < sizes.length; i++) {
			assertTrue(memory.get(i).inUse == 0);
			assertTrue(memory.get(i).prevInUse == 0);
			if(i > 0) {
				assertTrue(memory.get(i).prevBlock == memory.get(i-1));
				assertTrue(memory.get(i-1).nextBlock == memory.get(i));
			}
		}
		
		assertTrue(manager.getFitPolicy() == 0);
	}
	
	@Test
	public void testMallocFirsFit1() {
		int sizes[] = new int[] {1, 2, 2, 1, 3, 5, 5, 6 ,7, 8};
		Manager manager = new Manager(sizes);
		Block availableBlockList = manager.getAvailableBlockList();

		assertTrue(countAvailableBlocks(availableBlockList) == 10);
		
		manager.malloc(3);
		
		ArrayList<Block> memory = manager.getMemory();
		availableBlockList = manager.getAvailableBlockList();
		
		assertTrue(memory.get(4).prevBlock == null);
		assertTrue(memory.get(4).nextBlock == null);
		
		assertTrue(memory.get(4).inUse == 1);
		assertTrue(memory.get(4).prevInUse == 0);
		
		assertTrue(countAvailableBlocks(availableBlockList) == 9);
	}
	
	@Test
	public void testMallocFirstFit2() {
		int sizes[] = new int[] {1, 2, 2, 1, 3, 5, 5, 6 ,7, 8};
		Manager manager = new Manager(sizes);
		
		manager.malloc(4);
		
		Block availableBlockList = manager.getAvailableBlockList();
		ArrayList<Block> memory = manager.getMemory();
		
		assertTrue(memory.get(5).prevBlock == null);
		assertTrue(memory.get(5).nextBlock == null);
		
		assertTrue(memory.get(5).inUse == 1);
		assertTrue(memory.get(5).prevInUse == 0);
		
		assertTrue(memory.get(6).size == 1);
		assertTrue(memory.get(6).prevInUse == 1);
		
		assertTrue(countAvailableBlocks(availableBlockList) == 10);
	}
	
	@Test
	public void testFree1() {
		int sizes[] = new int[] {1, 2, 2, 1, 3, 5, 5, 6 ,4, 8};
		Manager manager = new Manager(sizes);
		
		Block b = manager.malloc(5);
		Block availableBlockList = manager.getAvailableBlockList();
		
		assertTrue(countAvailableBlocks(availableBlockList) == 9);
		
		assertTrue(manager.free(b));
		
		availableBlockList = manager.getAvailableBlockList();
		assertTrue(countAvailableBlocks(availableBlockList) == 8);	
		assertTrue(manager.getMemory().get(4).size == 13);
	}
	
	
	@Test
	public void testFree2() {
		int sizes[] = new int[] {1, 2, 2, 1, 3, 5, 5, 6 ,4, 8};
		Manager manager = new Manager(sizes);
		manager.setFitPolicy(1);
		
		Block b1 = manager.malloc(3);
		Block b2 = manager.malloc(5);
		
		assertTrue(manager.free(b1));
		assertTrue(countAvailableBlocks(manager.getAvailableBlockList()) == 8);
		assertTrue(manager.getMemory().get(3).size == 4);
		
		assertTrue(manager.free(b2));
		assertTrue(countAvailableBlocks(manager.getAvailableBlockList()) == 7);
		assertTrue(manager.getMemory().get(3).size == 14);
	}

  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }

}
