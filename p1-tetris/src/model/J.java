package model;

/**
 * 
 *  Piece: J
 *  Orientation:  
 *        up       left      down      right
 *       _____     _____     _____     _____
 *     0|  *  |  0|     |  0|  ** |  0| *   |
 *     1|  *  |  1| *** |  1|  *  |  1| *** | 
 *     2| **  |  2|   * |  2|  *  |  2|     |
 *     3|_____|  3|_____|  3|_____|  3|_____|
 *       01234     01234     01234     01234
 */

import java.util.ArrayList;

public class J extends Tetromino{

  public J(Game game) {
    /**
     * Constructor. You may want to modify
     * @param game used in the call to super constructor
     */
    super(game, "J", Cell.BLUE);
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
