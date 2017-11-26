package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChoicePair<T,U> {
	//ArrayLists 
	private List<T> ranks = new ArrayList<T>();
	private List<U> restaurants = new ArrayList<U>();
	private int[] answersM = new int[5];
	
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

	public void fillAnswerChoices() {
		Iterator<T> rankIterator = ranks.iterator();
		StringBuilder sb = new StringBuilder();
		while(rankIterator.hasNext())
		{
			sb.append(rankIterator.next());
			sb.append(",");
		}
		String ans = sb.toString();
		String[] ansArray = ans.split(",");
		for(int i = 0; i <5; i++)
		{
			if(ansArray[i].equals("Neutral"))
				this.answersM[i]= 1;
			else if(ansArray[i].equals("I hate it"))
				this.answersM[i] = 2;
			else
				this.answersM[i] = 3;
		}
	}

	public int[] getAnswersM() {
		return answersM;
	}

	public void setAnswersM(int[] answersM) {
		this.answersM = answersM;
	}
	
	

}
