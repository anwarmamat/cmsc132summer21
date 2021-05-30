package model;

/**
Piece: O
*  Orientation:  
*      up      left     down     right
*     ____     ____     ____     ____
*   0|    |  0|    |  0|    |  0|    |
*   1| ** |  1| ** |  1| ** |  1| ** |   
*   2| ** |  2| ** |  2| ** |  2| ** |
*   3|____|  3|____|  3|____|  3|____|
*     0123     0123     0123     0123
*    
*/

import java.util.ArrayList;

public class O extends Tetromino {

  public O(Game game) {
    /**
     * Constructor. You may want to modify
     * @param game used in the call to super constructor
     */
    super(game, "O", Cell.YELLOW);
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
