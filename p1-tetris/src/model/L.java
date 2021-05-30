package model;

/**
 * 
 *  Piece: L
 *  Orientation:  
 *        up       left      down      right
 *       _____     _____     _____     _____
 *     0|  *  |  0|   * |  0|  ** |  0|     |
 *     1|  *  |  1| *** |  1|   * |  1|  ***| 
 *     2|  ** |  2|     |  2|   * |  2|  *  |
 *     3|_____|  3|_____|  3|_____|  3|_____|
 *       01234     01234     01234     01234
 */

import java.util.ArrayList;

public class L extends Tetromino {

  public L(Game game) {
    /**
     * Constructor. You may want to modify
     * @param game used in the call to super constructor
     */
    super(game, "L", Cell.ORANGE);
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
