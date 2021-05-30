package model;
/**
Piece: I
*  Orientation:  
*        up       left      down      right       up again
*       _____     _____     _____     _____        _____
*     0|   * |  0|     |  0|  *  |  0|     | ->  0| *   |
*     1|   * |  1| ****|  1|  *  |  1|**** | ->  1| *   |
*     2|   * |  2|     |  2|  *  |  2|     | ->  2| *   |
*     3|   * |  3|     |  3|  *  |  3|     | ->  3| *   |
*     4|_____|  4|_____|  4|_____|  4|_____| ->  4|_____|
*       01234     01234     01234   01234          01234
*     
*     Notice this means that as you keep rotating it 
*     will automatically move left
*/

import java.util.ArrayList;

public class I extends Tetromino {
  /**
   * Constructor. You may want to modify
   * @param game used in the call to super constructor
   */
  public I(Game game) {
    super(game, "I", Cell.CYAN);
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
