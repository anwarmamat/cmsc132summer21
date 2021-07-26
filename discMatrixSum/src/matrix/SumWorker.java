package matrix;

import java.util.ArrayList;

/**
 * This class represents the task of taking the sum of an indicated row or
 * column of a two dimensional array.
 */
public class SumWorker implements Runnable{
	/**
	 * The two dimensional array whose row or column is to be summed
	 */
	private int[][] matrix;

	/**
	 * This variable is set to true if the sum of a row is to be taken and
     * false if the sum of a column is to be taken.
	 */
	private boolean sumRow;

	/**
	 * The index to be summed
	 */
	private int index;
	  
    /**
	 * Array list that will hold the result of each sum
	 */
	private ArrayList<Integer> results;

	/**
	 * @param matrix A n x m grid of integers
	 * @param sumRow true if the sum of a row will be taken, false otherwise
	 * @param index - the index to be summed
	 * @param results - the array list where the results should be placed. Use set to place the result at the appropriate index
	 * Used to shift the array over
	 */
	public SumWorker(int[][] matrix, boolean sumRow, int index, 
            ArrayList<Integer> results) {
		//TODO
	}
	
    /**
     * Given an index and a matrix, calculate the sum of that index in the
     * matrix and put this sum at the given index of results
     */
	public void run(){
		//TODO
	}
}
