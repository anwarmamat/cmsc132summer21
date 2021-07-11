package tests;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import tree.*;
import junit.framework.TestCase;
import junit.framework.AssertionFailedError;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class Tests {
	
	@Test
	public void testBasics() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();
		
		assertEquals(0, ptree.size());
		
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(1, "OneSecondTime");
		assertEquals(3, ptree.size());
		assertEquals("OneSecondTime", ptree.get(1));
		assertEquals("Two", ptree.get(2));
		assertEquals("Three", ptree.get(3));
		assertEquals(null, ptree.get(8));
	}
	
	@Test
	public void testEmptySearchTree() {
		PolymorphicBST<String, Integer> ptree = new PolymorphicBST<String, Integer>();
		
		assertEquals(0, ptree.size());
		
		try {
			assertEquals(null, ptree.getMin());
			fail("Should have thrown NoSuchElementException");
		} catch (NoSuchElementException e) {
			assert true; // as intended
		}
		try {
			assertEquals(null, ptree.getMax());
			fail("Should have thrown NoSuchElementException");
		} catch (NoSuchElementException e) {
			assert true; // as intended
		}
		assertEquals(null, ptree.get("a"));
	}
	
	@Test
	public void testHeightInorderClear() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();
		
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		assertEquals(3, ptree.height());
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		ptree.inorderTraversal(task);
		assertEquals(task.getKeys().toString(), "[1, 2, 3, 4]");
		assertEquals(task.getValues().toString(), "[One, Two, Three, Four]");
		
		ptree.clear();
		assertEquals(0, ptree.size());
	}

	static private void verify(PolymorphicBST<Integer, Integer> map, int[] insertOrder, int i, int i2, boolean detailed) {
		String foo = Arrays.toString(insertOrder) + ":" + i + ":" + i2;


		assertEquals(foo, i2-i, map.size());
		if (detailed) {
			Set<Integer> keys = new HashSet<Integer>();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int j = i; j < i2; j++) {
				min = Math.min(min, insertOrder[j]);
				max = Math.max(max, insertOrder[j]);
				keys.add(insertOrder[j]);
			}
			if (min <= max) {
				assertEquals(min, map.getMin().intValue());
				assertEquals(max, map.getMax().intValue());
			}
			if (max < Integer.MAX_VALUE)
				assertNull(map.get(max+1));

			Set<Integer> inTree = map.keySet();
			assertEquals(keys, inTree);
		}

		for(int j = 0; j < insertOrder.length; j++) {
			Integer result = map.get(insertOrder[j]);
			if (j < i || j >= i2) assertNull(result);
			else assertEquals(insertOrder[j], result.intValue());
		}
	}

	static ArrayList<int[]> all;
	
	static void initialize() {
		all = new ArrayList<int[]>(120);
		int[] start = {1, 2, 3, 4, 5};
		
		recurse(start, 0);
	}
	
	static void recurse(int [] a, int n) {
		if (n == a.length) {
			all.add(a.clone());
			return;
		}
		for(int i = n; i < a.length; i++) {
			int tmp = a[i];
			a[i] = a[n];
			a[n] = tmp;
			recurse(a, n+1);
			tmp = a[i];
			a[i] = a[n];
			a[n] = tmp;
		}
		
	}
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()) {
      System.out.println(failure.getTestHeader()+":"+failure.getTrace());
    }
  }
}
