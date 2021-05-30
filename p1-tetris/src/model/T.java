package model;

import java.util.ArrayList;
/**
 * 
 *  Piece: T
 *  Orientation:  
 *        up       left      down      right
 *       _____     _____     _____     _____
 *     0|     |  0|  *  |  0|  *  |  0|  *  |
 *     1| *** |  1|  ** |  1| *** |  1| **  |
 *     2|  *  |  2|  *  |  2|     |  2|  *  |
 *     3|_____|  3|_____|  3|_____|  3|_____|
 *       01234     01234     01234     01234
 */
public class T extends Tetromino {
  public T(Game game) {
    /**
     * Constructor. You may want to modify
     * @param game used in the call to super constructor
     */
    super(game, "T", Cell.PURPLE);
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
