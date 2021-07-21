package tests;

import static org.junit.Assert.*;
import com.pholser.junit.quickcheck.Property;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import static tests.TestUtils.*;

import org.junit.*;
import java.io.IOException;
import matrix.Matrix;



public class Tests{
	@Test
    public void testEqual() {
        Matrix a = new Matrix(4, 4);
        Matrix b = new Matrix(4, 4);
        Matrix c = new Matrix(4, 3);

        assertEquals(a,b);
        assertFalse(b.equals(c));

        loadMatrix(a, "4x4.txt");
        loadMatrix(b, "4x4.txt");

        assertEquals(a, b);
    }

	@Test
    public void testBasic() {
        Matrix a = new Matrix(4, 4);
        Matrix b = new Matrix(4, 6);
        Matrix correct = new Matrix(4, 6);

        loadMatrix(a, "4x4.txt");
        loadMatrix(b, "4x6.txt");
        loadMatrix(correct, "test1.txt");

        Matrix c = a.multiply(b, 4);

        assertEquals(correct, c);
    }
    
    public static void main(String[] args){ 
    	Result result = JUnitCore.runClasses(Tests.class);
    	for (Failure failure : result.getFailures()) 
    	{ System.out.println(failure.getTestHeader()+":"+failure.getTrace()); }
    }
}
