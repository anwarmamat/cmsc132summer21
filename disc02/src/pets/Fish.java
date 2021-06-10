package pets;

public class Fish extends Pet{
  /**
   * Timelines? Time is not made out of lines. It's made out of circles
   * Thats why clocks are round." - Michael J Caboose
   * His wise words also apply to round fishbowls so fish will age slowly
   * at a rate of 1:2 because they are so boring. They can look pretty though
   */


  /**
   * Used to keep track of time.
   */
  int time;
  
  public Fish() {
		//TODO
	}
  

  /**
   * When a fish swims, it looses 5 units of hunger, 5 units of energy
   * and gains 5 units of happiness.
   * A fish can only swim for an hour.
   */
  public void swim() {
		//TODO
	}

  /**
   * When a fish whiles away one hour, it looses 5 units of happiness, 5 units of hunger  and
   * 5 units of energy.
   * A fish can only while away one hour for an hour
   */
  @Override
  public void nextHour() {
		//TODO
	}

  /**
   * play does nothing. You can watch it swim around for an hour.
   */
  public void play() {
		//TODO
	}
  
  /**
   * When you feed a fish, it gains 5 units of hunger and 5 units of energy.
   * Feeding lasts for one hour.
   */
  @Override
  public void feed() {
		//TODO
	}
  
  /**
   * The fish rests for one hour. What happens to pets when they do this?
   */
  public void sleepForHour() {
		//TODO
	}
}
