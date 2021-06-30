package tests;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Stack;
import functions.Stacks;
import functions.Recursion;
import functions.Node;

public class Tests {
	
    @Test
	public void testPalindrome1() {
		assertTrue(Stacks.isPalindrome(""));
		assertTrue(Stacks.isPalindrome("a"));
		assertTrue(Stacks.isPalindrome("a a"));
		assertTrue(Stacks.isPalindrome("aa"));
		assertTrue(Stacks.isPalindrome("babbab"));
		assertTrue(Stacks.isPalindrome("abba"));
		assertTrue(Stacks.isPalindrome("babab"));
		assertFalse(Stacks.isPalindrome("baba"));
		assertFalse(Stacks.isPalindrome("ba"));
		assertFalse(Stacks.isPalindrome("babaa"));
	}

	@Test
 	public void testLength1() {
		assertTrue(Recursion.length(new Node(new int[] {1, 2, 3, 4, 5}))==5);
		assertTrue(Recursion.length(new Node(new int[] {1, 2, -1, 6, 7}))==5);
		assertTrue(Recursion.length(new Node(new int[] {0, 0, 0, 0, 0}))==5);
		assertTrue(Recursion.length(new Node(new int[] {1, 2, 3, 4}))==4);
		assertTrue(Recursion.length(new Node(new int[] {1111, 1, 1}))==3);
		assertTrue(Recursion.length(new Node(new int[] {-1}))==1);
		assertTrue(Recursion.length(new Node(new int[] {1, 2, 3, 4, 5, 4, 3, 2}))==8);
	}

	
	@Test
	public void testBalance1(){
		assertTrue(Recursion.isBalanced(""));
		assertTrue(Recursion.isBalanced("abc"));
		assertTrue(Recursion.isBalanced("ab"));
		assertTrue(Recursion.isBalanced("a"));
		assertTrue(Recursion.isBalanced("()"));
		assertTrue(Recursion.isBalanced("(())"));
		assertTrue(Recursion.isBalanced("(()())"));
		assertTrue(Recursion.isBalanced("<(<>)>"));
		assertTrue(Recursion.isBalanced("<[a[a]a]>"));
		assertTrue(Recursion.isBalanced("(aa{aa<aa>aa}aa)aa"));
	}

	@Test
	public void testFibRec(){
		assertTrue(Recursion.fibonacci(0)==0);
		assertTrue(Recursion.fibonacci(1)==1);
		assertTrue(Recursion.fibonacci(2)==1);
		assertTrue(Recursion.fibonacci(3)==2);
		assertTrue(Recursion.fibonacci(4)==3);
		assertTrue(Recursion.fibonacci(5)==5);
		assertTrue(Recursion.fibonacci(6)==8);
		assertTrue(Recursion.fibonacci(7)==13);
		assertTrue(Recursion.fibonacci(8)==21);
		assertTrue(Recursion.fibonacci(9)==34);
	}

    @Test
	public void testFibStack(){
		assertTrue(Stacks.fibonacci(0)==0);
		assertTrue(Stacks.fibonacci(1)==1);
		assertTrue(Stacks.fibonacci(2)==1);
		assertTrue(Stacks.fibonacci(3)==2);
		assertTrue(Stacks.fibonacci(4)==3);
		assertTrue(Stacks.fibonacci(5)==5);
		assertTrue(Stacks.fibonacci(6)==8);
		assertTrue(Stacks.fibonacci(7)==13);
		assertTrue(Stacks.fibonacci(8)==21);
		assertTrue(Stacks.fibonacci(9)==34);
	}

	@Test
	public void testFactRec(){
		assertTrue(Recursion.factorial(0)==1);
		assertTrue(Recursion.factorial(1)==1);
		assertTrue(Recursion.factorial(2)==2);
		assertTrue(Recursion.factorial(3)==6);
		assertTrue(Recursion.factorial(4)==24);
		assertTrue(Recursion.factorial(5)==120);
		assertTrue(Recursion.factorial(6)==720);
	}

    @Test
	public void testFactStack(){
		assertTrue(Stacks.factorial(0)==1);
		assertTrue(Stacks.factorial(1)==1);
		assertTrue(Stacks.factorial(2)==2);
		assertTrue(Stacks.factorial(3)==6);
		assertTrue(Stacks.factorial(4)==24);
		assertTrue(Stacks.factorial(5)==120);
		assertTrue(Stacks.factorial(6)==720);
	}

	@Test
	public void testMinRec1(){
		int[] stack = new int[] {7, 2, 3, 1, 7, 8, 3, 4}; 
		int[] stack2 = new int[] {1, 9, 6, 3, 0}; 
		int[] stack3 = new int[] {-1, 2, 3, 3, 4}; 
		int[] stack4 = new int[] {0}; 
		assertTrue(Recursion.min(new Node(stack)) == (1));
		assertTrue(Recursion.min(new Node(stack2)) == (0));
		assertTrue(Recursion.min(new Node(stack3)) == (-1));
		assertTrue(Recursion.min(new Node(stack4)) == (0));
	}

    @Test
	public void testMinStack1(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		assertTrue(Stacks.min(stack).equals(1));
	}

  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
