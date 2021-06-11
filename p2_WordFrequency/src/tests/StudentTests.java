package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import frequency.WordFrequency;

public class StudentTests {

	@Test
	public void test1() {
		String answer = WordFrequency.freq("data/myTest1.txt",5);
		assertTrue(TestsSupport.isCorrect("data/pubMyTest1.txt", answer));
	}

	
}
