/**
 *  DO NOT MODIFY THIS CLASS
 */
package model;

public class Coordinate implements Comparable<Coordinate> {

	protected int row, col;
	
	public Coordinate(int col, int row) {
		this.row = row;
		this.col = col;
	}
	
	public Coordinate translate(int c, int r) {
		return new Coordinate(col+c, row + r);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (!(o instanceof Coordinate)) {
			return false;
		} else {
			Coordinate c = (Coordinate) o;
			return this.compareTo(c) == 0;
		}
	}
	
	@Override
	public int compareTo(Coordinate c) {
		if (this.row == c.row && this.col == c.col) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "(" + col + "," + row + ")";
	}

}
