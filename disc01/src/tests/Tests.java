package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import cities.CityApp;

public class Tests {

	CityApp ca;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ca = new CityApp();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCamelCase1() {
		String expected = "Los Angeles";
		String result = ca.camelCase("los angeles   ");
		assertEquals(expected, result);
	}

	
	
	
	@Test
	public void testCamelCase3() { 
		String expected = "My Name Is Alice.";
		String result = ca.camelCase("my name is alice.");
		assertEquals(expected, result);
	}
	
	@Test
	public void testPopulation1() { 
		int expected = 8405837;
		int result = ca.population("new york");
		assertEquals(expected, result);
	}
	
	
	
	@Test
	public void testPopulation3() { 
		int expected = 268738;
		int result = ca.population("Lincoln");
		assertEquals(expected, result);
	}
	

	
	
	@Test
	public void testPopulation5() { 
		int expected = 1409019;
		int result = ca.population("San Antonio");
		assertEquals(expected, result);
	}
	
	
	@Test
	public void testPopulation6() { 
		int expected = 148892;
		int result = ca.population("alexandria");
		assertEquals(expected, result);
	}
	
	@Test
	public void testState1() { 
		String expected = "New York";
		String result = ca.state("new york");
		assertEquals(expected, result);
	}
	
	@Test
	public void testState2() { 
		String expected = null;
		String result = ca.state("city");
		assertEquals(expected, result);
	}
	
	
	
	
	@Test
	public void testCityRank1() { 
		String expected = "Houston";
		String result = ca.cityByRank(4);
		assertEquals(expected, result);
	}
	
	@Test
	public void testCityRank2() { 
		String expected = "Chicago";
		String result = ca.cityByRank(3);
		assertEquals(expected, result);
	}
	
	
	
	@Test
	public void testCitiesInState1() { 
		int expected = 7;
		int result = ca.CitiesInState("maryland");
		assertEquals(expected, result);
	}
	
	@Test
	public void testCitiesInState2() { 
		int expected = 1;
		int result = ca.CitiesInState("maine");
		assertEquals(expected, result);
	}
	
	
	
	@Test
	public void testDistance1() { 
		int expected = 711;
		int result = (int)ca.distance("chicago","new York");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testDistance2() { 
		int expected = 593;
		int result = (int)ca.distance("chicago","washington");	
		assertEquals(expected, result);
	}
	
	@Test
	public void testNthHighest1() { 
		String expected = "Anchorage";
		String result = ca.nthLargest(1);
		assertEquals(expected, result);
	}
	
	@Test
	public void testNthHighest2() { 
		String expected = "Everett";
		String result = ca.nthLargest(5);
		assertEquals(expected, result);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

	
	

	
	

  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
	
}
