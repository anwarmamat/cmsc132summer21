package tests;

import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import matrix.*;

public class Tests {
	
	@Test
	public void testSumCol() {
		int[][] arr = new int[][]{{1, 2, 3},{4, 5,6}};
		int start = 0;
		int end = 2;
		int[] sol = new int[] {5,7,9};
		ArrayList<Thread> threads = new ArrayList<Thread>();
		ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
		
		Main.findSum(arr, results, threads, start, end, false);
		for(int i = start; i <= end; i++) {
			assertEquals(sol[i],results.get(i).intValue());
		}
	}
	
	@Test
	public void testSumRow() {
		int[][] arr = new int[][]{{1, 2, 3},{4, 5,6}};
		int start = 0;
		int end = 1;
		int[] sol = new int[] {6,15};
		ArrayList<Thread> threads = new ArrayList<Thread>();
		ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0));

		Main.findSum(arr, results, threads, start, end, true);
		for(int i = start; i <= end; i++) {
			assertEquals(sol[i], results.get(i).intValue());
		}
	}
	
	@Test
	public void testSumEmptyMatrix() {
		int[][] arr = new int[][]{};
		int start = 0;
		int end = 2;
		ArrayList<Thread> threads = new ArrayList<Thread>();
		ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 0));

		Main.findSum(arr, results, threads, start, end, true);
		assertEquals(Arrays.asList(0, 0, 0), results);
		Main.findSum(null, results, threads, 0, 2, false);
		assertEquals(Arrays.asList(0, 0, 0), results);
	}
	
	@Test
	public void testSumWrongBoundsMatrix() {
		int[][] arr = new int[][]{{1, 2, 3},{4, 5,6}};
		ArrayList<Thread> threads = new ArrayList<Thread>();
		ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 0));

		Main.findSum(null, results, threads, 2, 0, true);
		assertEquals(Arrays.asList(0, 0, 0), results);
		Main.findSum(arr, results, threads, 0, 2, true);
		assertEquals(Arrays.asList(0, 0, 0), results);
		Main.findSum(arr, results, threads, 0, 3, false);
		assertEquals(Arrays.asList(0, 0, 0), results);

	}
	
  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
      for (Failure failure : result.getFailures()) {
        System.out.println(failure.getTestHeader()+":"+failure.getTrace());
    }
  }
}
