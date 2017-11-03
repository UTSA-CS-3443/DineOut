package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.Restaurant;
import model.Session;

public class SessionController implements Initializable, MapComponentInitializedListener {

	// Map for display in mapView
	private GoogleMap map;
	
	// Session
	private Session session = new Session();
	

	// ----------------------------- Utility variables------------------------------
	private Restaurant firstRestaurant = session.getFiveChoices().get(0);
	private Restaurant secondRestaurant = session.getFiveChoices().get(1);
	private Restaurant thirdRestaurant = session.getFiveChoices().get(2);
	private Restaurant fourthRestaurant = session.getFiveChoices().get(3);
	private Restaurant fifthRestaurant = session.getFiveChoices().get(4);
	// -----------------------------------------------------------------------------

	// MapView container for map
	@FXML
	private GoogleMapView mapView;

	@FXML
	private Label dineOutTitleLabel;

	@FXML
	private Label friendsInvitedLabel;

	@FXML
	private Label user1Label;

	@FXML
	private Label user2Label;

	@FXML
	private Label user3Label;

	@FXML
	private Label user4Label;

	@FXML
	private Label user5Label;

	@FXML
	private Label user6Label;

	@FXML
	private Label user7Label;

	@FXML
	private Label user8Label;

	@FXML
	private Label user9Label;

	@FXML
	private Label user10Label;

	// --- Scrapping backgrounds for now until we can get entire program running ---
	@FXML
	private Pane user1LabelBackground;

	@FXML
	private Pane user2LabelBackground;

	@FXML
	private Pane user3LabelBackground;

	@FXML
	private Pane user4LabelBackground;

	@FXML
	private Pane user5LabelBackground;

	@FXML
	private Pane user6LabelBackground;

	@FXML
	private Pane user7LabelBackground;

	@FXML
	private Pane user8LabelBackground;

	@FXML
	private Pane user9LabelBackground;

	@FXML
	private Pane user10LabelBackground;

	@FXML
	private Pane user1IndicatorBackground;

	@FXML
	private Pane user2IndicatorBackground;

	@FXML
	private Pane user3IndicatorBackground;

	@FXML
	private Pane user4IndicatorBackground;

	@FXML
	private Pane user5IndicatorBackground;

	@FXML
	private Pane user6IndicatorBackground;

	@FXML
	private Pane user7IndicatorBackground;

	@FXML
	private Pane user8IndicatorBackground;

	@FXML
	private Pane user9IndicatorBackground;

	@FXML
	private Pane user10IndicatorBackground;

	// -----------------------------------------------------------------------------

	// -------------------------- Main controls ------------------------------------
	@FXML
	private Button previousRestaurantButton;

	@FXML
	private Label restaurantNumberLabel;

	@FXML
	private Button nextRestaurantButton;

	@FXML
	private Label restaurantNameLabel;

	@FXML
	private Button websiteButton;

	@FXML
	private Label cuisineTypeLabel;

	@FXML
	private Label priceLabel;

	@FXML
	ComboBox<Integer> rankComboBox = new ComboBox<Integer>();
	// -----------------------------------------------------------------------------

	/**
	 * This method is automatically called by FXMLLoader when it gets loaded into
	 * the root layout. MUST BE NO ARGS Even though it's empty this method is
	 * necessary for the program to run
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Initialize method for SessionController, automatically called corresponding
	 * FXML is loaded into the root layout. Adds listener to mapView
	 */
	public void initialize(URL url, ResourceBundle rb) {
		mapView.addMapInializedListener(this);
		// add users to labels
		addUsers();
		// initialize first restaurant
		setInitialRestaurant();
		// initializing combo box
		rankComboBox.getItems().addAll(1, 2, 3, 4, 5);
	}

	/**
	 * Initializes map markers and sets the MapOptions
	 */
	@Override
	public void mapInitialized() {
		// Restaurant Locations
		LatLong theBlockLocation = new LatLong(29.575883, -98.624715);
		LatLong tacoPalenqueLocation = new LatLong(29.576716, -98.593963);
		LatLong singaporeChineseIndochinaLocation = new LatLong(29.576295, -98.625766);
		LatLong whiskeyCakeLocation = new LatLong(29.593221, -98.611472);
		LatLong littleCaesarsLocation = new LatLong(29.576491, -98.632428);
		LatLong crazyCarlsLocation = new LatLong(29.575883, -98.624715);
		LatLong picnikinsPatioLocation = new LatLong(29.571706, -98.597036);
		LatLong einsteinBrosLocation = new LatLong(29.581673, -98.617404);
		LatLong greensToGoLocation = new LatLong(29.584344, -98.617356);
		LatLong chikFilALocation = new LatLong(29.584346, -98.617358);
		LatLong papaJohnsLocation = new LatLong(29.584344, -98.617356);
		LatLong subwayLocation = new LatLong(29.584344, -98.617356);
		LatLong sushicLocation = new LatLong(29.584344, -98.617356);
		LatLong steakNShakeLocation = new LatLong(29.584425, -98.618168);
		LatLong smoothieKingLocation = new LatLong(29.584533, -98.617616);
		LatLong jplStarbucksLocation = new LatLong(29.584225, -98.617825);
		LatLong hebUCSubwayLocation = new LatLong(29.583322, -98.62014);
		LatLong ucStarbucksLocation = new LatLong(29.583756, -98.620437);
		LatLong chilisLocation = new LatLong(29.583499, -98.620899);
		LatLong pandaExpressLocation = new LatLong(29.583653, -98.62068);
		LatLong tacoTacoCafeLocation = new LatLong(29.583728, -98.620543);
		LatLong mooyahLocation = new LatLong(29.583693, -98.620581);
		LatLong roadrunnerCafeLocation = new LatLong(29.585714, -98.624614);
		LatLong rowdyCurbsideLocation = new LatLong(29.585507, -98.619088);

		// Set the initial properties of the map.
		MapOptions mapOptions = new MapOptions();
		mapOptions.center(new LatLong(29.583049, -98.619676)).mapType(MapTypeIdEnum.ROADMAP).overviewMapControl(true)
				.panControl(false).rotateControl(false).scaleControl(false).streetViewControl(false).zoomControl(false)
				.scrollWheel(true).zoom(16).fullscreenControl(false).mapTypeControl(false);

		map = mapView.createMap(mapOptions);

		// Adding position of markers to respected restaurants
		MarkerOptions markerOptions1 = new MarkerOptions().position(theBlockLocation);
		MarkerOptions markerOptions2 = new MarkerOptions().position(tacoPalenqueLocation);
		MarkerOptions markerOptions3 = new MarkerOptions().position(singaporeChineseIndochinaLocation);
		MarkerOptions markerOptions4 = new MarkerOptions().position(whiskeyCakeLocation);
		MarkerOptions markerOptions5 = new MarkerOptions().position(littleCaesarsLocation);
		MarkerOptions markerOptions6 = new MarkerOptions().position(crazyCarlsLocation);
		MarkerOptions markerOptions7 = new MarkerOptions().position(picnikinsPatioLocation);
		MarkerOptions markerOptions8 = new MarkerOptions().position(einsteinBrosLocation);
		MarkerOptions markerOptions9 = new MarkerOptions().position(greensToGoLocation);
		MarkerOptions markerOptions10 = new MarkerOptions().position(chikFilALocation);
		MarkerOptions markerOptions11 = new MarkerOptions().position(papaJohnsLocation);
		MarkerOptions markerOptions12 = new MarkerOptions().position(subwayLocation);
		MarkerOptions markerOptions13 = new MarkerOptions().position(sushicLocation);
		MarkerOptions markerOptions14 = new MarkerOptions().position(steakNShakeLocation);
		MarkerOptions markerOptions15 = new MarkerOptions().position(smoothieKingLocation);
		MarkerOptions markerOptions16 = new MarkerOptions().position(jplStarbucksLocation);
		MarkerOptions markerOptions17 = new MarkerOptions().position(hebUCSubwayLocation);
		MarkerOptions markerOptions18 = new MarkerOptions().position(ucStarbucksLocation);
		MarkerOptions markerOptions19 = new MarkerOptions().position(chilisLocation);
		MarkerOptions markerOptions20 = new MarkerOptions().position(pandaExpressLocation);
		MarkerOptions markerOptions21 = new MarkerOptions().position(tacoTacoCafeLocation);
		MarkerOptions markerOptions22 = new MarkerOptions().position(mooyahLocation);
		MarkerOptions markerOptions23 = new MarkerOptions().position(roadrunnerCafeLocation);
		MarkerOptions markerOptions24 = new MarkerOptions().position(rowdyCurbsideLocation);

		Marker theBlockMarker = new Marker(markerOptions1);
		Marker tacoPalenqueMarker = new Marker(markerOptions2);
		Marker singaporeChineseIndochinaMarker = new Marker(markerOptions3);
		Marker whiskeyCakeMarker = new Marker(markerOptions4);
		Marker littleCaesarsMarker = new Marker(markerOptions5);
		Marker crazyCarlsMarker = new Marker(markerOptions6);
		Marker picnikinsPatioMarker = new Marker(markerOptions7);
		Marker einsteinBrosMarker = new Marker(markerOptions8);
		Marker greensToGoMarker = new Marker(markerOptions9);
		Marker chikFilAMarker = new Marker(markerOptions10);
		Marker papaJohnsMarker = new Marker(markerOptions11);
		Marker subwayMarker = new Marker(markerOptions12);
		Marker sushicMarker = new Marker(markerOptions13);
		Marker steakNShakeMarker = new Marker(markerOptions14);
		Marker smoothieKingMarker = new Marker(markerOptions15);
		Marker jplStarbucksMarker = new Marker(markerOptions16);
		Marker hebUCSubwayMarker = new Marker(markerOptions17);
		Marker ucStarbucksMarker = new Marker(markerOptions18);
		Marker chilisMarker = new Marker(markerOptions19);
		Marker pandaExpressMarker = new Marker(markerOptions20);
		Marker tacoTacoCafeMarker = new Marker(markerOptions21);
		Marker mooyahMarker = new Marker(markerOptions22);
		Marker roadrunnerCafeMarker = new Marker(markerOptions23);
		Marker rowdyCurbsideMarker = new Marker(markerOptions24);

		// map.addMarker(theBlockMarker);

		mapView.setCenterOnLatLong(theBlockLocation);

	}

	/**
	 * VERY BASIC CRAPPY UNOPTIMIZED WAY OF GRABBING NEXT RESTAURANT. NEED TO
	 * IMPLEMENT DIFFERENT APPROACH AND METHOD FOR EASIER GRABBING.
	 * 
	 * @param e A reference to an ActionEvent
	 */
	@FXML
	public void nextRestaurant(ActionEvent e) {
		if (currentRestaurantEquals(firstRestaurant)) {
			setRestaurantName(secondRestaurant.getName());
			setCuisineType(secondRestaurant.getCuisine());
			setPrice(secondRestaurant.getPrice());

		} else if (currentRestaurantEquals(secondRestaurant)) {
			setRestaurantName(thirdRestaurant.getName());
			setCuisineType(thirdRestaurant.getCuisine());
			setPrice(thirdRestaurant.getPrice());

		} else if (currentRestaurantEquals(thirdRestaurant)) {
			setRestaurantName(fourthRestaurant.getName());
			setCuisineType(fourthRestaurant.getCuisine());
			setPrice(fourthRestaurant.getPrice());

		} else if (currentRestaurantEquals(fourthRestaurant)) {
			setRestaurantName(fifthRestaurant.getName());
			setCuisineType(fifthRestaurant.getCuisine());
			setPrice(fifthRestaurant.getPrice());
		}
	}

	/**
	 * VERY BASIC CRAPPY UNOPTIMIZED WAY OF GRABBING PREVIOUS RESTAURANT. NEED TO
	 * IMPLEMENT DIFFERENT APPROACH AND METHOD FOR EASIER GRABBING.
	 * 
	 * @param e A reference to an ActionEvent
	 */
	@FXML
	public void previousRestaurant(ActionEvent e) {
		if (currentRestaurantEquals(fifthRestaurant)) {
			setRestaurantName(fourthRestaurant.getName());
			setCuisineType(fourthRestaurant.getCuisine());
			setPrice(fourthRestaurant.getPrice());

		} else if (currentRestaurantEquals(fourthRestaurant)) {
			setRestaurantName(thirdRestaurant.getName());
			setCuisineType(thirdRestaurant.getCuisine());
			setPrice(thirdRestaurant.getPrice());

		} else if (currentRestaurantEquals(thirdRestaurant)) {
			setRestaurantName(secondRestaurant.getName());
			setCuisineType(secondRestaurant.getCuisine());
			setPrice(secondRestaurant.getPrice());

		} else if (currentRestaurantEquals(secondRestaurant)) {
			setRestaurantName(firstRestaurant.getName());
			setCuisineType(firstRestaurant.getCuisine());
			setPrice(firstRestaurant.getPrice());
		}
	}

	/**
	 * RUDIMENTARY IF ELSE STATEMENTS JUST TO CHECK IF LABELS / CSV IS WORKING. NEED
	 * REWORK
	 * 
	 * @param e A reference to an ActionEvent
	 */
	@FXML
	public void toRestaurantWebsite(ActionEvent e) {
		if (currentRestaurantEquals(firstRestaurant)) {
			openWebpage(firstRestaurant.getWebsite());
		} else if (currentRestaurantEquals(secondRestaurant)) {
			openWebpage(secondRestaurant.getWebsite());
		} else if (currentRestaurantEquals(thirdRestaurant)) {
			openWebpage(thirdRestaurant.getWebsite());
		} else if (currentRestaurantEquals(fourthRestaurant)) {
			openWebpage(fourthRestaurant.getWebsite());
		} else if (currentRestaurantEquals(fifthRestaurant)) {
			openWebpage(fifthRestaurant.getWebsite());
		}
	}

	// ---------------------------- Utility methods-----------------------
	
	/**
	 * Sets name of restaurant in display
	 * 
	 * @param name A reference to the name of a Restaurant 
	 */
	public void setRestaurantName(String name) {
		this.restaurantNameLabel.setText(name);
	}

	/**
	 * Sets cuisine type in display
	 * 
	 * @param cuisineType A reference to the cuisine type of a Restaurant 
	 */
	public void setCuisineType(String cuisineType) {
		this.cuisineTypeLabel.setText(cuisineType);
	}

	/**
	 * Sets price in display
	 * 
	 * @param price A reference to the price range of a Restaurant
	 */
	public void setPrice(int price) {
		this.priceLabel.setText(String.valueOf(price));
	}

	/**
	 * Checks if restaurants are equal based on name
	 * @param r A restaurant object
	 * @return true if restaurant names are the same, false otherwise
	 */
	public boolean currentRestaurantEquals(Restaurant r) {
		if (restaurantNameLabel.getText().equals(r.getName())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Sets initial restaurant on opening scene, will probably need redoing with
	 * multiple users
	 */
	public void setInitialRestaurant() {
		restaurantNameLabel.setText(session.getFiveChoices().get(0).getName());
		cuisineTypeLabel.setText(session.getFiveChoices().get(0).getCuisine());
		priceLabel.setText(String.valueOf(session.getFiveChoices().get(0).getPrice()));
	}

	/**
	 * Method for adding users to ArrayList to iterate and set userLabels
	 * respectfully
	 */
	public void addUsers() {
		ArrayList<Label> userLabels = new ArrayList<Label>();
		userLabels.add(user1Label);
		userLabels.add(user2Label);
		userLabels.add(user3Label);
		userLabels.add(user4Label);
		userLabels.add(user5Label);
		userLabels.add(user6Label);
		userLabels.add(user7Label);
		userLabels.add(user8Label);
		userLabels.add(user9Label);
		userLabels.add(user10Label);

		// Loop for setting users from LoginController to labels in order
		for (int i = 0; i < LoginController.getUsers().size(); i++) {
			userLabels.get(i).setText(LoginController.getUsers().get(i).getHandle());
		}
	}

	/**
	 * Method which opens default browser and links to website specified by
	 * parameter url
	 * 
	 * @param url URL of restaurant website
	 */
	public static void openWebpage(String url) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	}
	// -------------------------------------------------------------------

}
