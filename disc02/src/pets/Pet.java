package pets;

public abstract class Pet {
	/**
	 * This field will hold the number of pets that have been created.
	 */
	static int count = 0;
	
	/**
	 * This field will hold the name of the pet.
	 */
	protected String name;
	
	/**
	 * This field will hold the age of the pet.
	 */
	protected int age;
	
	/**
	 * This field indicates how hungry the pet is.
	 */
	protected int hunger;
	
	/**
	 * This field indicate how happy the pet is.
	 */
	protected int happiness;
	
	/**
	 * This field indicates how much energy the pet has.
	 */
	protected int energy;
	
	
	public Pet() {
		age = 1;
		name = makeName();
		count++;
		hunger = 80;
		happiness = 80;
		energy = 80;
	}
	
	public abstract void nextHour();
	public abstract void play();
	public abstract void feed();
	
	/**
	 * This method randomly generates a name from a WONDERFUL list of 
	 * names for animals.
	 * @return The randomly generated name
	 */
	private String makeName() {
		String[] names = {"Doctor McGILLicutty","CATrina","Snoop DOG",
							"FINley","Bait","Bob BARKer" ,"Kit KAT",
							"BEEverly","Daniel RATcliffe","Mary PUPPins"};
		return names[(int)Math.floor(Math.random() * 9)];
	}
	
	/**
	 * @return The age of the pet
	 */
	public int getAge() {return age;}
	/**
	 * @return The level of hunger of the pet
	 */
	public int getHunger() {return hunger;}
	/**
	 * 
	 * @return The level of happiness of the pet
	 */
	public int getHappiness() {return happiness;}
	/**
	 * @return The pet's energy level
	 */
	public int getEnergy() {return energy;}
	/**
	 * When a pet sleeps for an hour, it gains 10 units of energy
	 */
	public void sleepForHour() { energy += 10; }
	/**
	 * 
	 * @return The number of pets that have been created
	 */
	public static int getCount() {return count;}
}
