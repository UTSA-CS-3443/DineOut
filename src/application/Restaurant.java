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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
	
	
	
	
	
	
	
	
}
