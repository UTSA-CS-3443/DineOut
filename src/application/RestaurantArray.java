package application;

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
		    in = new Scanner(new File("restaurants.txt"));
		} catch (FileNotFoundException exception) {
		    throw new RuntimeException("failed to open restaurants.txt");
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
			String address = lineArray[5].substring(1);
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
	
	

}
