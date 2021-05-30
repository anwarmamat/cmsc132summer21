/**
 *  DO NOT MODIFY THIS CLASS
 */
package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Action;
import model.Cell;
import model.Tetris;
import model.Game;

public class GameGUI extends JComponent {
	private static final long serialVersionUID = 1L;
	private static int CELL_DIMENSION = 30;
	private static boolean RAISED_CELL = true;
	private Game gameModel;
	private Timer timer;
	private static JLabel scoreView;
	public GameGUI(int timerDelayInMilliSecs, Game gameModelIn) {
		this.gameModel = gameModelIn;

		setPreferredSize(new Dimension(gameModel.getMaxCols() * CELL_DIMENSION,
				gameModel.getMaxRows() * CELL_DIMENSION));
		System.out.println(gameModel.getMaxCols());
		System.out.println(gameModel.getMaxRows());
		addMouseListener(new MouseHandler());
		Keyboard listener = new Keyboard();
		addKeyListener(listener);
		setFocusable(true);
		
		ActionListener animator = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!gameModel.isGameOver()) {
					gameModel.nextAnimationStep(null);	//updated to take in a parameter. here it will be null
					repaint();
				} else {
					timer.stop();
					String message = "Score: " + gameModel.getScore() + "\nGame Over";
					JOptionPane.showMessageDialog(GameGUI.this, message);
					System.exit(0);
				}
			}
		};
		timer = new Timer(timerDelayInMilliSecs, animator);
		timer.start();
	}

	protected void paintComponent(Graphics g) {
		Graphics g2 = (Graphics2D) g;
		scoreView.setText(" Score: "+gameModel.getScore());
		/* Setting background */
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		/* Drawing the grid */
		Cell[][] board = getBoard(gameModel);
		for (int col = 0; col < board.length; col++) {
			for (int row = 0; row < board[col].length; row++) {
				g2.setColor(board[col][row].getColor());
				g2.fill3DRect(col * CELL_DIMENSION, row * CELL_DIMENSION,
							 CELL_DIMENSION, CELL_DIMENSION, RAISED_CELL);
			}
		}
	}

	private class Keyboard implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		            break;
		        case KeyEvent.VK_DOWN:
		        	gameModel.processCell(Action.MOVEDOWN);
		            break;
		        case KeyEvent.VK_LEFT:
		        	gameModel.processCell(Action.MOVELFT);
		            break;
		        case KeyEvent.VK_RIGHT :		        	
		        	gameModel.processCell(Action.MOVERIGHT);
		            break;
		        case KeyEvent.VK_Z :		// rotate to left
		        	gameModel.processCell(Action.ROTATE);
		            break;
		        case KeyEvent.VK_SPACE :		// fall
		        	gameModel.processCell(Action.FALL);
		            break;
		     }
		    repaint();
		}
	}
	
	private class MouseHandler extends MouseAdapter {
		public void mouseReleased(MouseEvent evt) {
			gameModel.processCell(Action.ROTATE);
			repaint();
		}
	}
	
	private static Cell[][] getBoard(Game model) {
		int maxRows = model.getMaxRows();
		int maxCols = model.getMaxCols();
		Cell[][] board = new Cell[maxCols][maxRows];
		
		for (int col=0; col < maxCols; col++)
			for (int row=0; row < maxRows; row++)
				board[col][row] = model.getBoardCell(col, row);
		return board;
	}
	
	public static void createAndDisplayGUI(Game gameModel, int timerDelayInMilliSecs) {
		GameGUI gameGUI = new GameGUI(timerDelayInMilliSecs, gameModel);
		   
		JFrame frame = new JFrame("Tetris Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel pane1 = new JPanel(new GridLayout(2,1));
		JPanel pane2 = new JPanel();
		frame.add(pane2, BorderLayout.WEST);
		frame.add(pane1, BorderLayout.EAST);
		
	
		//frame.add(gameGUI);
		//Container pane = frame.getContentPane();
		JLabel s1 = new JLabel(" Score Board ");
		scoreView = new JLabel(" Score: 0");
		pane1.add(s1);
		pane1.add(scoreView);
		
		pane2.add(gameGUI);//,BorderLayout.WEST);
		
		frame.pack();
		
		/* Centralizing the frame in the display window */
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int upperLeftCornerX = (screenSize.width - frame.getWidth()) / 2;
	    int upperLeftCornerY = (screenSize.height - frame.getHeight()) / 2;
	    frame.setLocation(upperLeftCornerX, upperLeftCornerY);
	   
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Runnable createShowGUI = new Runnable() {
			public void run() {
				int maxRows = 22;
				int maxCols = 10;
				int timerDelayInMilliSecs = 1000; 
				GameGUI.createAndDisplayGUI(new Tetris(maxCols, maxRows), 
											timerDelayInMilliSecs);
			}
		};
		SwingUtilities.invokeLater(createShowGUI);
	}
}