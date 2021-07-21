package matrix;

import java.io.*;

public class Matrix {

    public int[][] matrix;
    int[][] trans;
    public int x, y;
    private boolean transposed;

    public Matrix(int x, int y){
        matrix = new int[x][y];
        this.x = x;
        this.y = y;
    }

    /*
     * This method takes in a 2d matrix array and returns the transposed matrix
     * https://en.wikipedia.org/wiki/Transpose
     */
    private int[][] transpose(int[][] arr){
		//TODO
	}
    
    public void set(int[][] in){
        this.matrix = in;
    }
    
    // DO NOT MODIFY THIS METHOD
    public void load(String path) throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(path));
        }catch(FileNotFoundException e){
            System.err.println("file not found: " + path);
        }
        int row = 0;
        while(true){
            String line = br.readLine();
            if(line == null){
                break;
            }
            String arr[] = line.split(" ");
            for(int i = 0; i < arr.length; i ++) {
                matrix[row][i] = Integer.parseInt(arr[i]);
            }
            row++;
        }
        trans = transpose(matrix);
        transposed = true;
    }

    // DO NOT MODIFY THIS METHOD
    public String toString(){
        String aString = "";
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                aString += " " + matrix[row][col];
            }
            aString += "\r\n";
        }
        return aString;
    }

    /*
     * This is a single-threaded matrix multiply.
     * Takes in a matrix and multiplies itself by it so (this x*b)
     */
    public Matrix multiply(Matrix b){
        // TODO
    }

    /*
     * This method takes in a matrix, and a number of threads and uses that 
     * number of threads to multiply the two matrices together. It should be in 
     * the order (this x*m) 
     */
    public Matrix multiply(Matrix m, int threads) {
		//TODO
	}
    
    /*
     * A method that should take in a matrix and determine if it is equal to 
     * this matrix
     */
    @Override
    public boolean equals(Object in) {
		//TODO
	}

    // This is given as potentially useful starting point for testing
    public static void main(String[] args){
        Matrix a = new Matrix(3,4);
        Matrix b = new Matrix(4,4);
        int[][] ain = {
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}//,
            //   {1, 2, 3, 4}
        };
        int[][] bin = {
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
        };
        a.set(ain);
        b.set(bin);
        Matrix rem = a.multiply(b, 3);

		/*
        System.out.println(a);
        System.out.println(b);
        System.out.println(rem);
        */

    }

}

