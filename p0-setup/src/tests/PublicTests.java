package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import project0.Maths;

public class PublicTests {
	@Test
	public void testSumFact1() {
		assertTrue(2 == Maths.sumFactorials(1, 1));
	}
	
	@Test
	public void testSumFact2() {
		assertTrue(126 == Maths.sumFactorials(3, 5));
	}
	
	@Test
	public void testFib1() {
		assertTrue(1 == Maths.fibonacci(1));
	}

  public static void main(String[] args){
    Result result = JUnitCore.runClasses(PublicTests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
