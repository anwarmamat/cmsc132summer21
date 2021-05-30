/**
 *  DO NOT MODIFY THIS CLASS
 */
package model;

public class Tetris extends Game {
	private int score;
	private int N = 7; //number of possible pieces
	
	private boolean needNewPiece = true;
	private boolean gameOverFlag = false;
	
	private Tetromino livePiece; 	//current piece 
	
	public Tetris(int maxCols, int maxRows) {
		super(maxCols, maxRows);
		score = 0;
		livePiece = null;
	}

	@Override
	public boolean isGameOver() {
		return gameOverFlag;
	}

	@Override
	public int getScore() {
		return score;
	}

	/**
	 * @param piece is a integer which will dictate which piece should be
	 * inserted next. Null for random. The GUI will call null always. This
	 * is more for testing purposes. 
	 * The following are the mapping of numbers to pieces:
	 * 1    I 
	 * 2    O
	 * 3    T
	 * 4    J
	 * 5    L
	 * 6    S
	 * 7    Z
	 */
	@Override
	public void nextAnimationStep(Integer piece) {
		if(needNewPiece) {
			insertNewPiece(piece);
			needNewPiece = false;
		}else {
			if(!livePiece.moveDown()) {
				collapse();
				needNewPiece = true;
				nextAnimationStep(piece);
			}
		}
	}
	
	private void collapse() {
		int r =  getMaxRows() - 1 ;
		int c = getMaxCols() - 1;
		int count = 0;				//this will keep track of how many lines are completed
		for(int i = r; i > 0; i--) {
			int j = 0;
			for( j = 0; j <= c; j++) {
				if(getBoardCell(j,i) == Cell.EMPTY) break;
			}
			
			if(j > c) {
				count++; //this counts how many lines you cleared at once
				for(int k = i; k > 0; k--) {
					for(j = 0; j <= c; j++) {
						setBoardCell(j,k, getBoardCell(j,k-1));
					}
				}
				for(int k = 0; k <= c; k++) {
					setBoardCell(k,0,Cell.EMPTY);
				}
				i++; //repeat the same row
			}
		}
		/* These scores as taken from Tetris Wiki Fandom.
		 * http://tetris.wikia.com/wiki/Scoring
		*/
		switch(count) {
		case(1): score += 40; break;
		case(2): score += 100; break;
		case(3): score += 300; break;
		case(4): score += 1200; break;
		default: break;
		}
	}

	@Override
	public void processCell(Action action) {
		switch(action) {
		case MOVELFT:
			livePiece.moveLeft();
			break;
		case MOVEDOWN:
			livePiece.moveDown();
			break;
		case MOVERIGHT:
			livePiece.moveRight();
			break;
		case ROTATE:
			livePiece.rotate();
			break;
		case FALL:
			livePiece.fall();
			break;
		
		default:
			break;
		}
	}

	/**
	 * Randomly creates a piece and inserts it at the center of row 0
	 * @param piece is a integer which will dictate which piece. Null for random
	 * It is passed in from nextAnimationStep
	 */
	private void insertNewPiece(Integer piece) {	
		int n;
		if (piece == null)
			n= (int)(Math.random() * N + 1);
		else
			n = piece;
		Tetromino p = null;
		switch(n) {
		case 1:
			p = new I(this);
			break;
		case 2:
			p = new O(this);
			break;
		case 3:
			p = new T(this);
			break;
		case 4:
			p = new J(this);
			break;
		case 5:
			p = new L(this);
			break;
		case 6:
			p = new S(this);
			break;
		case 7:
			p = new Z(this);
			break;
		}
		int r = 0;
		int c = getMaxCols() / 2;		//horizontal center
		
		if(p.insertAt(new Coordinate(c, r)))
			livePiece = p;
		else {
			gameOverFlag = true;
		}
	}
	
	/* For testing purposes. */
	//to return the board object for testing purposes
	public Cell[][] getBoard() {return board;}
	
	//returns a string
	@Override
	public String toString() {
		String result = "";
		for(int i=0; i<getMaxRows();i++) {
			for(int j=0; j<getMaxCols();j++) {
				result += board[j][i].getName()+" ";
			}
			result += "\n";
		}
		return result;
	}
	
	
}