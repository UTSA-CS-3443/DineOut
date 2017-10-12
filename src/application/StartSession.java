package application;

import java.util.ArrayList;
import java.util.Random;

public class StartSession {
	
	ArrayList<Restaurant> numbers = new ArrayList<Restaurant>();
	ArrayList<Restaurant> fiveChoices = new ArrayList<Restaurant>();
	ArrayList<Person> users = new ArrayList<Person>();
	RestaurantArray restaurants = new RestaurantArray();
	
	public  void returnArrayList(){
		Random rand = new Random();
		int randomNumber = rand.nextInt(restaurants.getRestaurantList().size() + 1);
		for( int i = 0 ; i < 5 ; i++) {
			int j = randomNumber;
			int k = randomNumber;
			for(Restaurant num : numbers) {
				if(num == j && num != k) {
					numbers.add(restaurants.getRestaurantList().get(k));
				}else if( (num != j && num != k) && (j != k)) {
					numbers.add(restaurants.getRestaurantList().get(j));
					numbers.add(pullNumbersFromHere.get(k));
				}else if( num != j && num == k) {
					numbers.add(pullNumbersFromHere.get(j));
				}else if(num == j && num == k) {
					
				}
				else {
					numbers.add(pullNumbersFromHere.get(j));
				}
			}
		}
		//return numbers;
	}
}
