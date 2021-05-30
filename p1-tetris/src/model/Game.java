/**
 *  DO NOT MODIFY THIS CLASS
 */
package model;

public abstract class Game {
	protected Cell[][] board;

	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * 
	 * @param maxRows
	 * @param maxCols
	 */
	public Game(int maxCols, int maxRows) {
		board = new Cell[maxCols][maxRows];
		for (int col = 0; col < board.length; col++) {
			for (int row= 0; row < board[col].length; row++) {
				board[col][row] = Cell.EMPTY;
			}
		}
	}

	public int getMaxRows() {
		return board[0].length;
	}

	public int getMaxCols() {
		return board.length;
	}

	public void setBoardCell(int colIndex, int rowIndex, Cell boardCell) {
		board[colIndex][rowIndex] = boardCell;
	}

	public Cell getBoardCell(int colIndex, int rowIndex) {
		return board[colIndex][rowIndex];
	}

	/**
	 * Initializes row with the specified color.
	 * @param rowIndex
	 * @param cell
	 */
	public void setRowWithColor(int rowIndex, Cell cell) {
		for (int col = 0; col < getMaxCols(); col++) {
			setBoardCell(col, rowIndex, cell);
		}
	}
	
	/**
	 * Initializes column with the specified color.
	 * @param colIndex
	 * @param cell
	 */
	public void setColWithColor(int colIndex, Cell cell) {
		for (int row = 0; row < getMaxRows(); row++) {
			setBoardCell(colIndex, row, cell);
		}
	}
	
	/**
	 * Initializes the board with the specified color.
	 * @param cell
	 */
	public void setBoardWithColor(Cell cell) {
		for (int row = 0; row < getMaxRows(); row++) {
			setRowWithColor(row, cell);
		}
	}	
	
	public abstract boolean isGameOver();

	public abstract int getScore();

	/**
	 * Advances the animation one step.
	 */
	public abstract void nextAnimationStep(Integer piece);

	/**
	 * Adjust the board state according to the current board state and the
	 * selected cell.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 */
	public abstract void processCell(Action action);
	
	
}