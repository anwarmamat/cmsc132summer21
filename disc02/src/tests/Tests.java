package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import pets.*;

public class Tests {
	Dog pet1 = new Dog();
	Puppy pet2 = new Puppy();
	Cat pet3 = new Cat();
	Fish pet4 = new Fish();
	int happiness;
	int weight;
	int energy;
	int hunger;
  
	@Test
  public void testDogPlay() {
	  happiness = pet1.getHappiness();
	  weight = pet1.getWeight();
	  energy = pet1.getEnergy();
	  pet1.play();
	  assertEquals(pet1.getHappiness(), happiness+10);
	  assertEquals(pet1.getEnergy(), energy-10);
	  assertEquals(pet1.getWeight(), weight-2);
  }
	@Test
  public void testPupPlay() {  
	  happiness = pet2.getHappiness();
	  weight = pet2.getWeight();
	  energy = pet2.getEnergy();
	  pet2.play();
	  assertEquals(pet2.getHappiness(), happiness+15);
	  assertEquals(pet2.getWeight(), weight-2);
	  assertEquals(pet2.getEnergy(), energy-10);
  }

	@Test
  public void testCatPlay() {	  
	  energy = pet3.getEnergy();
	  hunger = pet3.getHunger();
	  pet3.play();
	  assertEquals(pet3.getEnergy(), energy-10);
	  assertEquals(pet3.getHunger(), hunger-5);
  }
	  
	@Test
  public void testFishPlay() {	  
	  happiness = pet4.getHappiness();
	  energy = pet4.getEnergy();
	  hunger = pet4.getHunger();
	  pet4.play();
	  assertEquals(pet4.getHappiness(), happiness);
	  assertEquals(pet4.getEnergy(), energy);
	  assertEquals(pet4.getHunger(), hunger);
  }
  
	@Test
  public void testDogFeed() {
	  hunger = pet1.getHunger();
	  weight = pet1.getWeight();
	  energy = pet1.getEnergy();
	  pet1.feed();
	  assertEquals(pet1.getHunger(), hunger+10);
	  assertEquals(pet1.getEnergy(), energy+5);
	  assertEquals(pet1.getWeight(), weight+5);
  }
  
	@Test
  public void testPupFeed() {
	  hunger = pet2.getHunger();
	  weight = pet2.getWeight();
	  energy = pet2.getEnergy();
	  pet2.feed();
	  assertEquals(pet2.getHunger(), hunger+10);
	  assertEquals(pet2.getWeight(), weight+5);
	  assertEquals(pet2.getEnergy(), energy+5);
  }

	@Test
  public void testCatFeed(){
	  int energy = pet3.getEnergy();
	  int hunger = pet3.getHunger();
	  pet3.feed();
	  assertEquals(pet3.getEnergy(), energy+5);
	  assertEquals(pet3.getHunger(), hunger+10);
  }
  
	@Test
  public void testFishFeed() {
	  energy = pet4.getEnergy();
	  hunger = pet4.getHunger();
	  pet4.feed();
	  assertEquals(pet4.getEnergy(), energy+5);
	  assertEquals(pet4.getHunger(), hunger+5);
  }
  
	@Test
  public void testCount() {
	int count = Pet.getCount();
	Dog pet5 = new Dog();
	Puppy pet6 = new Puppy();
	Cat pet7 = new Cat();
	Fish pet8 = new Fish();
	
	assertEquals(Pet.getCount(), count + 4);
	Dog d1 = new Dog();
	Puppy p1 = new Puppy();
	Dog d2 = new Puppy();
	assertEquals(Pet.getCount(),count + 7);
  }
  
	@Test
  public void testAge() {
	  for( int i = 0; i < 96; i++) {
		  int r = (int)Math.floor(Math.random()*4);
		  switch(r){
		  	case(0): pet1.feed(); pet2.feed(); pet3.feed();pet4.feed();break;
		  	case(1): pet1.play(); pet2.play(); pet3.play();pet4.play();break;
		  	case(2): pet1.nextHour();pet2.nextHour();pet3.nextHour();pet4.nextHour();break;
		  	case(3): pet1.sleepForHour();pet2.sleepForHour();pet3.sleepForHour();pet4.sleepForHour();break;
		  }
	  }
	  assertEquals(pet1.getAge(),25);
	  assertEquals(pet2.getAge(),25);
	  assertEquals(pet3.getAge(),5);
	  assertEquals(pet4.getAge(),3);
  }

  
  
  
 
  

  public static void main(String[] args){
    Result result = JUnitCore.runClasses(Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
