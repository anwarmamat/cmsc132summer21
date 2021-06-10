package pets;

public class Dog extends Pet{

	/**
	 * Used to keep track of the age of the dog. We all know its 7 dog years to a human
	 * year, but for simplicity, we will use a 6:1 ratio
	 */
	int time;

	
	/**
	 * Allowed max 3 walks a day. Resets every 24 hours.
	 * NOTE: 24 hours WITHOUT using the Dog's accelerated aging.
	 */
	int walks;
	
	/**
	 * The dog's weight measured in pounds.
	 */
	int weight = 20;


	/**
	 * Other instance variables, if necessary
	 */
	
	public Dog() {
		//TODO
	}

	/**
	 * Walking a dog decreases its hunger by 5 units,
	 * its energy by 10 units and its weight by 3 units.
	 * Each walk lasts for an hour.
	 * Increase happiness by 5.
	 * Maximum of 3 walks per day.
	 */
	public void walk() {
		//TODO
	}

	/**
	 * In the next hour, the dog will loose 10 units of happiness, 
	 * 5 units of hunger and 5 units of energy.
	 * Of course, the next hour lasts for one hour.
	 */
	@Override
	public void nextHour() {
		//TODO
	}

	/**
	 * Playing with dog makes it loose 10 units
	 * of energy, 2 pounds of weight, gain 10 units
	 * of happiness. The play lasts for 1 hour.
	 */
	@Override
	public void play() {
		//TODO
	}

	/**
	 * Feeding a dog adds 10 units of hunger,
	 * 5 units of energy and 5 pounds of weight.
	 * The feeding lasts for one hour
	 */
	@Override
	public void feed() {
		//TODO
	}

	/**
	 * The dog rests for an hour. What happens to pets when they do this?
	 */
	@Override
	public void sleepForHour() {
		//TODO
	}

	
	/**
	 * 
	 * @return The weight of the dog
	 */
	public int getWeight() {return weight;}
}
