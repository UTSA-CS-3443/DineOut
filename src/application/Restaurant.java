package application;

public class Restaurant {

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

	public Restaurant(String name, int price, double rating, String cuisine, String website, String address) {
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.cuisine = cuisine;
		this.website = website;
		this.address = address;
		this.selected = false;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCuisine() {
		return this.cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
