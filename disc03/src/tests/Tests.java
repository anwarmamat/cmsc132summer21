package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import loopbag.Bag;
import loopbag.LoopBag;
import loopbag.Node;
import loopbag.NodeInt;

public class Tests{

	@Test
	public void testInsert() {
		LoopBag<Integer> bag = new Bag(5);
		for(int i = 1; i < 8; i++){
			bag.insert(i);
		}
		String answer = "1,2,3,4,5,";
		assertEquals(answer, bag.toString());
		
		NodeInt<Integer> ret = bag.getNode(3);
		assertTrue(ret.getData().equals(4));
	}

	@Test
	public void testSize1() {
		LoopBag<Integer> bag = new Bag(5);
		for(int i = 1; i < 8; i++){
			bag.insert(i);
		}
		assertEquals(bag.size(),5);
		
		NodeInt<Integer> ret = bag.getNode(0);
		assertTrue(ret.getData().equals(1));
	}

	@Test
	public void testSize2() {
		LoopBag<Integer> bag = new Bag(5);
		for(int i = 1; i < 4; i++){
			bag.insert(i);
		}
		assertEquals(bag.size(),3);
	}
	
	@Test
	public void testContains1() {
		LoopBag<Integer> bag = new Bag(5);
		for(int i = 1; i < 4; i++){
			bag.insert(i);
		}
		assertTrue(bag.contains(3));
		
		NodeInt<Integer> ret = bag.getNode(2);
		assertTrue(ret.getData().equals(3));
	}
	
	@Test
	public void testContains2() {
		LoopBag<Integer> bag = new Bag(5);
		for(int i = 1; i < 10; i++){
			bag.insert(i);
		}
		assertFalse(bag.contains(7));
	}
	
	@Test
	public void testIsEmpty(){
		LoopBag<Integer> bag = new Bag(5);
		assertTrue(bag.isEmpty());
		
		NodeInt<Integer> ret = bag.getNode(3);
		assertTrue(ret == null);
	}

	@Test
	public void testIsEmpty2(){
		LoopBag<Integer> bag = new Bag(5);
		bag.insert(10);
		assertFalse(bag.isEmpty());
	}
	
	@Test
	public void testUnion1(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(2);
		bag2.insert(1);
		bag2.insert(2);
		bag1.union(bag2);
		String answer="1,2,";
		assertEquals(answer, bag1.toString());
		assertEquals(10, bag1.capacity());
		
		NodeInt<Integer> ret = bag1.getNode(1);
		assertTrue(ret.getData().equals(2));
	}
	@Test
	public void testUnion2(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(2);
		bag2.insert(1);
		bag2.insert(3);
		bag1.union(bag2);
		String answer="1,2,3,";
		assertEquals(answer, bag1.toString());
	}
	@Test
	public void testUnion3(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(3);
		bag2.insert(1);
		bag2.insert(2);
		bag1.union(bag2);
		String answer="1,3,2,";
		assertEquals(answer, bag1.toString());
		
		NodeInt<Integer> ret = bag1.getNode(2);
		assertTrue(ret.getData().equals(2));
	}
	
	@Test
	public void testUnion4(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(2);
		bag1.insert(3);
		bag2.insert(1);
		bag2.insert(4);
		bag2.insert(5);
		bag2.insert(6);
		bag1.union(bag2);
		String answer="1,2,3,4,5,6,";
		assertEquals(answer, bag1.toString());
		
		NodeInt<Integer> ret = bag1.getNode(0);
		assertTrue(ret.getData().equals(1));
	}
	
	@Test
	public void testIntersect1(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(2);
		bag2.insert(1);
		bag2.insert(2);
		bag1.intersect(bag2);
		String answer="1,2,";
		assertEquals(answer, bag1.toString());
		
		NodeInt<Integer> ret = bag1.getNode(0);
		assertTrue(ret.getData().equals(1));
	}
	@Test
	public void testIntersect2(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(2);
		bag2.insert(1);
		bag2.insert(3);
		bag1.intersect(bag2);
		String answer="1,2,";
		assertNotEquals(answer, bag1.toString());
	}
	@Test
	public void testIntersect3(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(2);
		bag2.insert(1);
		bag2.insert(3);
		bag1.intersect(bag2);
		String answer="1,";
		assertEquals(answer, bag1.toString());
		
		NodeInt<Integer> ret = bag1.getNode(0);
		assertTrue(ret.getData().equals(1));
	}
	
	@Test
	public void testIntersect4(){
		LoopBag<Integer> bag1 = new Bag(5);
		LoopBag<Integer> bag2 = new Bag(5);
		bag1.insert(1);
		bag1.insert(2);
		bag1.insert(4);
		bag2.insert(1);
		bag2.insert(2);
		bag2.insert(3);
		bag2.insert(4);
		bag1.intersect(bag2);
		String answer="1,2,4,";
		assertEquals(answer, bag1.toString());
		
		NodeInt<Integer> ret = bag1.getNode(2);
		assertTrue(ret.getData().equals(4));
	}
	
  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
