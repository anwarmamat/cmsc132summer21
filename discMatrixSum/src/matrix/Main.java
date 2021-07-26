package matrix;

import java.util.ArrayList;

public class Main {
	/**
	 * This method finds the sum of the rows or columns beginning form index start inclusive and ending at the
	 * index stop inclusive. It does so by creating threads to sum each row or column, placing the sum in the 
	 * appropriate index of the result array list.
	 * If the matrix is null, start > stop or start and stop are invalid, findSum should do nothing and leave results unchanged.
	 * @param matrix The grid of numbers to be used in the sum
	 * @param results array list that will hold the result of each sum
	 * @param threads This array list should contain a duplicate of all the Threads you created.
	 * @param start The first row/col to be summed
	 * @param stop The last row/col to be summed - notice these bounds are inclusive
	 * @param sumRow true if a row sum is required, false if a column sum is required.
	 * if matrix == null or start/stop out of bounds, or invlid range, return and don't modify results. and dont start any threads.
     * 
     * For example,
     * matrix = 1, 2, 3
     *          4, 5, 6
     *          7, 8, 9
     * start = 0
     * stop = 1
     * We need 2 threads here. Make one thread work on index 0 and make another
     * thread work on index 1.
	 */
	public static void findSum(int[][] matrix, ArrayList<Integer> results, 
            ArrayList<Thread> threads, int start, int stop, boolean sumRow) {
		//TODO
	}
}
