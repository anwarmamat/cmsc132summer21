package model;

import java.util.ArrayList;

/**
 * 
 *  Piece: S
 *  Orientation:  
 *      up       left     down     right
 *     _____     _____     _____     _____
 *  0 |     |  0| *   |  0|     |  0| *   | 
 *  1 |  ** |  1| **  |  1|  ** |  1| **  |
 *  2 | **  |  2|  *  |  2| **  |  2|  *  |
 *  3 |_____|  3|_____|  3|_____|  3|_____|
 *     01234     01234     01234    01234
 */

public class S extends Tetromino{
  /**
   * Constructor. You may want to modify
   * @param game used in the call to super constructor
   */
  public S(Game game) {
    super(game, "S", Cell.GREEN);
  }

  /**
   * rotates the piece counter-clockwise. See above orientation
   * for reference on which tile to rotate around. 
   */
  @Override
  public boolean rotate() {
		//TODO
	}
}
