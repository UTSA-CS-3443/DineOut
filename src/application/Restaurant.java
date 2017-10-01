package application;

public class Restaurant{
	
	// Restraunts name
	private String name;
	
	// General price range
	private int price;
	
	// Rating
	private double rating;
	
	// Type of cuisine
	private String cuisine;
	
	// Website of restaurant
	private String website;
	
	// Address of restaurant
	private String address;
	
	// Boolean var which says if restraunt was selected.
	private boolean selected;
	
	public Restaurant(
			String name, int price, double rating, String cuisine, 
			String website, String address) {
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.cuisine = cuisine;
		this.website = website;
		this.address = address;
		this.selected = false;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSelected(boolean b) {
		this.selected = b;
	}
	
	
	
	
	
	
	
	
}
