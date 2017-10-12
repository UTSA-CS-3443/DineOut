package application;

import java.util.ArrayList;
import java.util.Random;

public class StartSession {
	
	ArrayList<Restaurant> fiveChoices = new ArrayList<Restaurant>();
	//ArrayList<Restaurant> fiveChoices = new ArrayList<Restaurant>();
	ArrayList<Person> users = new ArrayList<Person>();
	RestaurantArray restaurants = new RestaurantArray();
	
	public  void returnArrayList(){
		Random rand = new Random();
		int randomNumber = rand.nextInt(restaurants.getRestaurantList().size() + 1);
		for( int i = 0 ; i < 5 ; i++) {
			int j = randomNumber;
			int k = randomNumber;
			for(Restaurant r : fiveChoices) {
				if(r == restaurants.getRestaurantList().get(j) && r != restaurants.getRestaurantList().get(k)) {
					fiveChoices.add(restaurants.getRestaurantList().get(k));
				}else if( (r != restaurants.getRestaurantList().get(j) && r != restaurants.getRestaurantList().get(k)) && (j != k)) {
					fiveChoices.add(restaurants.getRestaurantList().get(j));
					fiveChoices.add(restaurants.getRestaurantList().get(k));
				}else if( r != restaurants.getRestaurantList().get(j) && r == restaurants.getRestaurantList().get(k)) {
					fiveChoices.add(restaurants.getRestaurantList().get(j));
				}else if( r == restaurants.getRestaurantList().get(j) && j == k) {
					
				}
				else {
					fiveChoices.add(pullNumbersFromHere.get(j));
				}
			}
		}
		//return numbers;
	}
}
