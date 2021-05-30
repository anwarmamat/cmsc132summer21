package model;

import java.util.ArrayList;

/**
 * 
 *  Piece: Z
 *  Orientation:  
 *      up       left     down     right
 *     _____     _____     _____    _____ 
 *  0 |     |  0|   * |  0|     | 0|   * | 
 *  1 | **  |  1|  ** |  1| **  | 1|  ** |
 *  2 |  ** |  2|  *  |  2|  ** | 2|  *  |
 *  3 |_____|  3|_____|  3|_____| 3|_____|
 *     01234     01234     01234    01234
 */

public class Z extends Tetromino{
  /**
   * Constructor. You may want to modify
   * @param game used in the call to super constructor
   */
  public Z(Game game) {
    super(game, "Z", Cell.RED);
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
