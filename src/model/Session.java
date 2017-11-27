package model;

import java.util.ArrayList;
import java.util.Random;

public class Session {

	private ArrayList<Restaurant> fiveChoices = new ArrayList<Restaurant>();

	public Session() {
		//Call fillRandomList(), not included in constructor anymore
		//fillRandomList();
	}

	/**
	 * Fills fiveChoices arraylist with 5 "random" restaurants
	 */
	public void fillRandomList() {
		RestaurantArray restaurants = new RestaurantArray();
		Random rand = new Random();
		int i = rand.nextInt(restaurants.getRestaurantList().size() - 1);
		int count = 0;
		while (count < 5) {
			Restaurant tempRest = restaurants.getRestaurantList().get(i);
			if (tempRest.isSelected() == false) { // meaning its false
				fiveChoices.add(tempRest);
				restaurants.getRestaurantList().get(i).setSelected(true);
				count++;
				System.out.println(count);
			}
			i = rand.nextInt(restaurants.getRestaurantList().size() - 1);
		}
		System.out.println(restaurants);
	}

	public ArrayList<Restaurant> getFiveChoices() {
		return this.fiveChoices;
	}

}
