package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChoicePair<T,U> {
	//ArrayLists 
	private List<T> ranks = new ArrayList<T>();
	private List<U> restaurants = new ArrayList<U>();
	
	public ChoicePair() {}
	
	public ChoicePair(ArrayList<T> ranks, ArrayList<U> restaurants) {
		this.ranks = ranks;
		this.restaurants = restaurants;
	}
	
	public void addPair(T rank, U restaurant) {
		int index = 0;
		if(restaurants.contains(restaurant)) {
			index = restaurants.indexOf(restaurant);
			restaurants.remove(index);
			ranks.remove(index);
			ranks.add(rank);
			restaurants.add(restaurant);
		}else {
			ranks.add(rank);
			restaurants.add(restaurant);
		}
	}
	

	@Override
	public String toString() {
		Iterator<U> restaurantIterator = restaurants.iterator();
		Iterator<T> rankIterator = ranks.iterator();
		StringBuilder sb = new StringBuilder();
		while(restaurantIterator.hasNext() && rankIterator.hasNext()) {
			sb.append("Choice: " + rankIterator.next());
			sb.append(", ");
			sb.append("Restaurant: " + restaurantIterator.next());
			sb.append("\n");
		}
		return sb.toString();
	}

}
