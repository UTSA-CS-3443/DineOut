package application;

import java.util.ArrayList;
import java.util.Random;

public class StartSession {
	
	private ArrayList<Restaurant> fiveChoices = new ArrayList<Restaurant>();
	private ArrayList<Person> users = new ArrayList<Person>();
	
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

		for(int count = 0 ; count < 5 ; count++) {
			int i = randomNumber;
			if(restaurants.getRestaurantList().get(i).isSelected() == true) {
				continue;
			}else { // meaning its false
				fiveChoices.add(restaurants.getRestaurantList().get(i));
				restaurants.getRestaurantList().get(i).setSelected(true);
			}
		}
		
	}
	
	
	public ArrayList<Restaurant> getFiveChoices(){
		return this.fiveChoices;
	}

	public ArrayList<Person> getUsers() {
		return this.users;
	}
	
	public void addUser(Person p) {
		users.add(p);
	}
	
	
}
