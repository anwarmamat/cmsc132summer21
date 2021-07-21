package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import matrix.Matrix;

public class TestUtils {
    public static void loadMatrix(Matrix matrix, String filename) {
        try {
            matrix.load("data/" + filename);
        } catch(IOException e) {
            fail("Error reading data/" + filename + ".  Make sure the test files are in the data/ directory in the project root.");
        }
    }
}
