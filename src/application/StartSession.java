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
		int i = rand.nextInt(restaurants.getRestaurantList().size() - 1);
		int count = 0;
		while (count < 5) {
			Restaurant tempRest = restaurants.getRestaurantList().get(i);
			if(tempRest.isSelected() == false) 
			{ // meaning its false
				fiveChoices.add(tempRest);
				restaurants.getRestaurantList().get(i).setSelected(true);
				count++;
			}
			i = rand.nextInt(restaurants.getRestaurantList().size() - 1);	
		}
		
	}
	
	
	public ArrayList<Restaurant> getFiveChoices(){
		return this.fiveChoices;
	}

	public ArrayList<Person> getUsers() {
		return users;
	}
	
	
}
