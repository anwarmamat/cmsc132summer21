
package imageblocks;

import java.awt.Color;

import utils.Picture;

public class ImageBlocks {
    static Color BLACK = new Color(0,0,0);
    static Color WHITE = new Color(255,255,255);                
    private int height;
    private int width;
    boolean [][] visited;
    Picture pic;
    
    public ImageBlocks(Picture pic) {
    	this.pic = pic;
    	height = pic.height();
    	width = pic.width();
    }
    
    
    private boolean isBlack(int x,int y){
        return pic.get(x,y).equals(BLACK);
    }
    private boolean isWhite(int x,int y){
        return pic.get(x,y).equals(WHITE);
    }
    
    /**
     * count the number of image blocks in the given image
     * Counts the number of connected blocks in the binary digital image
     * @return number of black blocks
     */
    public int countConnectedBlocks(){
		//TODO
	}
    
    /**
     * Removes all neighboring black pixels of the provided pixel (x,y)
     * @param x
     * @param y
     * @return updated picture
     */
    public Picture delete(int x, int y) {
		//TODO
	}
   
    
    /**
     * Crops an image by setting all the pixels outside the provided
     * indices to the color white
     * delete everything not inside the bounds of the parameters (inclusive)
     * @param row_start
     * @param col_start
     * @param row_end
     * @param col_end
     * @return updated picture
     */
    public Picture crop(int x_start, int x_end, int y_start, int y_end) {
		//TODO
	}
    
    public static void main(String[] args) {
        
        String fileName = "images/14.png";
        Picture p = new Picture(fileName);
        ImageBlocks block = new ImageBlocks(p);
        try{
            int c1 = block.countConnectedBlocks();
            block.delete(4, 8);
            int c2 = block.countConnectedBlocks();
            p = block.crop(0, 90, 0, 90);
            int c3 = block.countConnectedBlocks();
            System.out.println("Number of connected blocks="+c1);
            System.out.println("Number of connected blocks after delete="+c2);
            System.out.println("Number of connected blocks after crop="+c3);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
