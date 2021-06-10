package pets;

public class Cat extends Pet{
	
/**
 * Used to keep track of the age of the cat.
 */
  int time;

	public Cat() {
		//TODO
	}

	
	/**
	 * Causing chaos makes loose 5 units of hunger, 10 units of energy
	 * and helps it gain 10 units of happiness.
	 * The chaos of a cat can only last for one hour.
	 */
	public void causeChaos() {
		//TODO
	}
	
	/**
	 * By whiling away one hour, a cat looses 10 units of happiness,
	 * 5 units of hunger and 5 units of energy
	 * Of course, whiliing away one hour takes one hour.
	 */
	@Override
	public void nextHour() {
		//TODO
	}

	/**
	 * Playing with the cat makes it loose 10 units of energy and
	 * 5 units of hunger. 
	 * This play lasts for one hour.
	 * Note: Cats don't actually play. They hunt and take over the world.
	 */
	@Override
	public void play() {
		//TODO
	}

	/**
	 * Feeding a cat makes it gain 10 units of hunger, 5 units of energy and
	 * lasts one hour.
	 */
	@Override
	public void feed() {
		//TODO
	}
	
	/**
	 * One hour of time passes bye, with the cat resting. What happens to pets
	 * when they do this?
	 */
	@Override
	public void sleepForHour() {
		//TODO
	}
}
