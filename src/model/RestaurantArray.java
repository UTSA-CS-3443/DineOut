package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantArray {
	
	private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	protected int restaurantCount;
	
	public RestaurantArray() {
		this.restaurantList.clear();
		this.restaurantCount = 0;
		fillArrayList();
	}
	
	public void fillArrayList() {
		Scanner in = null;
		try {
		    in = new Scanner(new File("res/restaurants2.txt"));
		} catch (FileNotFoundException exception) {
		    throw new RuntimeException("failed to open restaurants2.txt");
		}
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			String[] lineArray = line.split("\\s*,\\s*");
			String name = lineArray[0]; 
			int price = Integer.parseInt(lineArray[1]);
			double rating = Double.parseDouble(lineArray[2]);
			String cuisine = lineArray[3];
			String website= lineArray[4]; 
			String address = lineArray[5];
			Restaurant newRest = new Restaurant(name, price, rating, cuisine, website, address);
			this.restaurantList.add(newRest);
			this.restaurantCount++;
			
		}
		in.close();
		
	}
	
	// not sure why tf i made this
	public ArrayList<Restaurant> getRestaurantList() {
		return restaurantList;
	}
	
	public void printRestaurantInfo(){
		for(int i = 0; i < this.restaurantCount; i++) {
			Restaurant temp = this.restaurantList.get(i);
			System.out.println("Name = " + temp.getName());
			System.out.println("Price = " + temp.getPrice());
			System.out.println("Rating = " + temp.getRating());
			System.out.println("Cuisine = " + temp.getCuisine());
			System.out.println("Website = " + temp.getWebsite());
			System.out.println("Address = " + temp.getAddress());
			System.out.println("");
		}
	}
	
	//Might not be in the correct location, so let me know. --Marcus
	public String voteResults()
	{
		/**
		 * Iterate though arrayList for selected = true
		 * Add to votes[] for each true
		 * Store highest votes[] ---> choice
		 * return RestaurantList<choice> for winner
		 */
		int voteNum = -1;
		int choice = -1;
		int[] votes = new int[restaurantCount];
		
		for(int i = 0; i < restaurantCount; i++)
		{
			if(restaurantList.get(i).isSelected())
				votes[i]+=1;
		}
				
		for(int j = 0; j < restaurantCount; j++)
		{
			if(votes[j] > voteNum)
			{
				voteNum = votes[j];
				choice = j;
			}
						
		}
		
		if(choice == -1) return "Error: votes did not register.\n";
		
		return this.restaurantList.get(choice).toString() + " has the most votes.\n";
	}
	
	

}
