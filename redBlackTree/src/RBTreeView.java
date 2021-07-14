import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import structure5.*;


/*
 * A Viewer for Binary Trees.
 */
class RBTreeView<Key extends Comparable<Key>, Value> extends JPanel {

    /* The tree currently being display */
    protected RedBlackTree<Key, Value> tree;

    /* The max. height of any tree drawn so far.  This
       is used to avoid the tree jumping around when nodes
       are removed from the tree. */
    protected int maxHeight;

    /* The font for the tree nodes. */
    protected Font font = new Font("Roman", 0, 24);
    
    
    /* 
     * Create a new window with the given width and height 
     * that is showing the given tree.
     */
    public RBTreeView(RedBlackTree<Key,Value> tree, int width, int height) {

        //Initialize drawing colors, border, opacity.
        setBackground(Color.white);
        setForeground(Color.black);

        // Create window and make it so hitting the close icon
        // will terminate the program
        JFrame f = new JFrame("BinaryTree View");
        f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        
        f.getContentPane().add(this, BorderLayout.CENTER);
        f.setSize(new Dimension(width, height));
        f.setVisible(true);
        
        // install initial tree.
        setTree(tree);
    }

    /*
     * Set the display to show the given tree.
     */ 
    public void setTree(RedBlackTree<Key,Value> t) {
        tree = t;
        maxHeight = tree.height();
    }

    /*
     * Invoke this method whenever you would like the window
     * to be refreshed, such as after updating the tree in some
     * way.
     */
    public void refresh() {
        paintImmediately(0,0, getWidth(), getHeight());
    }


    /*
     * Draw the contents of the tree into the given Graphics
     * context.
     * It will place all info between minX and maxX in the x-direction,
     * starting at location y in the y-direction.  Levels of the tree
     * will be separated by yStep pixels.
     */
    protected void drawTree(Graphics g, int minX, int maxX, 
                            int y, int yStep, RedBlackTree<Key,Value> tree) {

        if(tree.isEmpty()) return;
        String s = tree.info();
        
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(s);
        int height = fm.getHeight();
        g.setColor(new Color((tree.isRootRed() ? 255 : 0), 0, 0));

        int xSep = Math.min((maxX - minX)/8, 10);

        g.drawString(s, (minX + maxX)/2 - width/2, y + yStep/2);
        //g.drawString(".", (minX + maxX)/2 - width/2, y + yStep/2);
        
        //g.drawOval((minX + maxX)/2 - width/2 - 10, y + yStep/2 - 25, 40, 30);
        if (!tree.getLeft().isEmpty()) {
            // if left tree not empty, draw line to it and recursively
            // draw that tree
            g.setColor(new Color((tree.getLeft().isRootRed() ? 255 : 0), 0, 0));
            g.drawLine((minX + maxX)/2 - xSep, y + yStep/2 + 5,
                       (minX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, minX, (minX + maxX)/2, y + yStep, yStep, tree.getLeft());
        }
        if (!tree.getRight().isEmpty()) {
            // same thing for right subtree.
        	// Even though a right subtree shouldn't be red, we'll check for it just in case.
            g.setColor(new Color((tree.getRight().isRootRed() ? 255 : 0), 0, 0));
            g.drawLine((minX + maxX)/2 + xSep, y + yStep/2 + 5,
                       (maxX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, (minX + maxX)/2, maxX, y + yStep, yStep, tree.getRight());
        }
    }


    /*
     * paint method unherited from the Swing library.  Just
     * calls drawTree whenever the window needs to be repainted.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      //clears the background
        int width = getWidth();
        int height = getHeight();
        maxHeight = Math.max(tree.height(), maxHeight);
        if(maxHeight < 0){maxHeight = 0;}
        int treeHeight = maxHeight;
        

        drawTree(g, 0, width, 0, height / (treeHeight + 1), tree);

    } 

    /* 
     * Test code.
     */
    public static void main(String s[]) {
        RedBlackTree<String, String> tree = new RedBlackTree();

        RBTreeView<String,String> btv = new RBTreeView<String,String>(tree, 400, 400);
        btv.refresh();
    }
}
