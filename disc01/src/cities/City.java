
package cities;
/**
 * This class holds the city information.
 *
 */
public class City {
	// city,growth_from_2000_to_2013,latitude,longitude,population,rank,state
	public String name;
	public double latitude;
	public double longitude;
	public int population;
	public int rank;
	public String state;
	
	public City(String name,  double latitude, double longitude, 
			int population, int rank, String state){
		
		this.name  = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.population = population;
		this.rank = rank;
		this.state = state;
	}
	
}
