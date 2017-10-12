package application;

import java.util.ArrayList;
import java.util.Random;

public class StartSession {
	
	ArrayList<Restaurant> fiveChoices = new ArrayList<Restaurant>();
	ArrayList<Person> users = new ArrayList<Person>();
	
	public StartSession() {
		fillRandomList();
	}
	
	/**
	 * Fills fiveChoices arraylist with 5 "random" restaurants
	 */
	public void fillRandomList(){
		RestaurantArray restaurants = new RestaurantArray();
		Random rand = new Random();
		int randomNumber = rand.nextInt(restaurants.getRestaurantList().size() + 1);
		for( int i = 0 ; i < 5 ; i++) {
			int j = randomNumber;
			for(Restaurant r : fiveChoices) {
				// if j is in fiveChoices, add k instead
				if(r == restaurants.getRestaurantList().get(j)) { 
					int k = randomNumber;
					fiveChoices.add(restaurants.getRestaurantList().get(k));
				// if j isn't in fiveChoices, add j
				}else {
					fiveChoices.add(restaurants.getRestaurantList().get(j));
				}
			}
		}	
	}
	
	
}
