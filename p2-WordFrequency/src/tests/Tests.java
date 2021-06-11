package tests;

import static org.junit.Assert.*;
//import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import frequency.Frequency;
import frequency.WordFrequency;

public class Tests {

	@Test //public - 5
	public void testEinstein() {
		String answer = WordFrequency.freq("data/einstein.txt",20);
		assertTrue(TestsSupport.isCorrect("data/pubEinstein.txt", answer));
	}
	
	@Test //public - 5
	public void test0() {
		String answer = WordFrequency.freq("data/test0.txt",10);
		assertTrue(TestsSupport.isCorrect("data/pubTest0.txt", answer));
	}
	
	@Test //public - 5
	public void testValid() {
		Frequency<String> freq = new Frequency<>();
		freq.insert("alice");
		freq.insert("alice");
		freq.insert("cat");
		freq.insert("bob");
		freq.insert("cat");
		freq.insert("bob");
		freq.insert("cat");
		assertEquals(freq.getCount("bob"),2);
		assertTrue(freq.isValid());
	}
	
	public void testWarPeace() {
		String answer = WordFrequency.freq("data/war_peace.txt", 20);
		assertTrue(TestsSupport.isCorrect("data/pubWar_peace.txt", answer));
	}
	
	@Test //public - 5
	public void testInsert1() {
		Frequency<String> freq = new Frequency<>();
		freq.insert("alice");
		String answer = freq.getWords(1).trim();
		assertEquals("[alice,1]", answer);
	}
	
	@Test //public - 5
	public void testGetCount1() {
		
		Frequency<String> freq = new Frequency<>();
		freq.insert("alice");
		assertTrue(freq.isValid());
		freq.insert("alice");
		freq.insert("cat");
		assertTrue(freq.isValid());
		freq.insert("bob");
		freq.insert("cat");
		assertTrue(freq.isValid());
		freq.insert("bob");
		freq.insert("cat");
		assertTrue(freq.isValid());
        int answer = freq.getCount("cat");
        int expected = 3;
        assertEquals(expected, answer);
	}
	
	@Test //public - 5
	public void testInsert2() {
		Frequency<String> freq = new Frequency<>();
		freq.insert("alice");
		freq.insert("alice");
		String answer = freq.getWords(1).trim();
		assertEquals("[alice,2]", answer);
		assertTrue(freq.isValid());
	}
	
	@Test //public - 5
	public void testIterator1() {
		
		Frequency<String> freq = new Frequency<>();
		freq.insert("alice");
		freq.insert("alice");
		freq.insert("cat");
		freq.insert("bob");
		freq.insert("cat");
		freq.insert("bob");
		freq.insert("cat");
		
		StringBuilder strFrequency = new StringBuilder();
        for(String s: freq){
        	String t = "["+s +","+freq.getCount(s)+"]";
            strFrequency.append(t);
            
        }
        String answer =  strFrequency.toString();
        String expected = "[cat,3][alice,2][bob,2]";
        assertEquals(expected, answer);
        assertTrue(freq.isValid());
	}
	
  //RELEASE TESTS
	@Test //release-6
	public void test1() {
		String answer = WordFrequency.freq("releasedata/release1.txt",10);
		assertTrue(TestsSupport.isCorrect("releasedata/pubRelease1.txt", answer));
	}

	@Test //release-6
	public void test2() {
		String answer = WordFrequency.freq("releasedata/release2.txt",10);
		assertTrue(TestsSupport.isCorrect("releasedata/pubRelease2.txt", answer));
	}
	@Test //release-6
	public void test3() {
		String answer = WordFrequency.freq("releasedata/release3.txt",10);
		assertTrue(TestsSupport.isCorrect("releasedata/pubRelease3.txt", answer));
	}
	@Test //release-6
	public void test4() {
		String answer = WordFrequency.freq("releasedata/release4.txt",10);
		assertTrue(TestsSupport.isCorrect("releasedata/pubRelease4.txt", answer));
	}
	@Test //release-6
	public void test5() {
		String answer = WordFrequency.freq("releasedata/release5.txt",10);
		assertTrue(TestsSupport.isCorrect("releasedata/pubRelease5.txt", answer));
	}
	


  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
