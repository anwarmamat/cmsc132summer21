package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import functions.TreeFunctions;
import functions.TreeNode;

public class Tests{
	
	@Test
	public void testMax() {
		TreeFunctions a = new TreeFunctions(new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(2)), new TreeNode(8, new TreeNode(7), new TreeNode(9))));
		TreeFunctions b = new TreeFunctions(new TreeNode(5, new TreeNode(3, null, new TreeNode(2)), new TreeNode(8, new TreeNode(7), null)));
		TreeFunctions c = new TreeFunctions(new TreeNode(9, new TreeNode(3, new TreeNode(1), null), new TreeNode(8, null, new TreeNode(5))));
		TreeFunctions d = new TreeFunctions(null);
		assertTrue(a.findMax() == 9);
		assertTrue(b.findMax() == 8);
		assertTrue(c.findMax() == 9);
		assertTrue(d.findMax() == -1);
	}
	@Test
	public void testSymmetric1() {
		TreeFunctions a = new TreeFunctions(new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(2)), new TreeNode(8, new TreeNode(7), new TreeNode(9))));
		TreeFunctions b = new TreeFunctions(new TreeNode(5, new TreeNode(3, null, new TreeNode(2)), new TreeNode(8, new TreeNode(7), null)));
		TreeFunctions c = new TreeFunctions(new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(8, null, null)));
		assertTrue(a.isSymmetric());
		assertTrue(b.isSymmetric());
		assertFalse(c.isSymmetric());
	}
	
	
	@Test
	public void testLCA1() {
		TreeFunctions a = new TreeFunctions(new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(2)), new TreeNode(8, new TreeNode(7), new TreeNode(9))));
		assertEquals(a.LowestCommonAncestor(1, 2), 3);
		assertEquals(a.LowestCommonAncestor(7, 9), 8);
		assertEquals(a.LowestCommonAncestor(3, 8), 5);
	}
	
	
	@Test
	public void testMirror1() {
		TreeFunctions a = new TreeFunctions(new TreeNode(5, new TreeNode(2), new TreeNode(8, new TreeNode(6), new TreeNode(9))));
		TreeFunctions b = new TreeFunctions(new TreeNode(5, new TreeNode(8, new TreeNode(9), new TreeNode(6)), new TreeNode(2)));
		TreeFunctions c = new TreeFunctions(new TreeNode(5, new TreeNode(3), new TreeNode(8)));
		TreeFunctions d = new TreeFunctions(new TreeNode(3, new TreeNode(8), new TreeNode(5)));
		assertTrue(a.mirror(b));
		assertFalse(c.mirror(d));
	}
  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
      for (Failure failure : result.getFailures()) {
        System.out.println(failure.getTestHeader()+":"+failure.getTrace());
    }
  }
}
