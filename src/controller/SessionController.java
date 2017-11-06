package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Restaurant;
import model.Session;

public class SessionController implements Initializable{

	// Session
	private Session session = new Session();
	

	// ----------------------------- Utility variables------------------------------
	private Restaurant firstRestaurant = session.getFiveChoices().get(0);
	private Restaurant secondRestaurant = session.getFiveChoices().get(1);
	private Restaurant thirdRestaurant = session.getFiveChoices().get(2);
	private Restaurant fourthRestaurant = session.getFiveChoices().get(3);
	private Restaurant fifthRestaurant = session.getFiveChoices().get(4);
	// -----------------------------------------------------------------------------

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
	
	Label testLabel = new Label("");
	
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
		// add users to labels
		addUsers();
		// initialize first restaurant
		setInitialRestaurant();
		// initializing combo box
		rankComboBox.getItems().addAll(1, 2, 3, 4, 5);
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
		
		//testLabel.textProperty().bind(restaurantNameLabel.getText());
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
	
	/**
	 * Opens new scene with google maps view
	 */
	public void toMapView(ActionEvent e) {
		//new MapViewStage();
		try {
			Stage subStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("../view/MapView.fxml").openStream());
			MapController mapController = (MapController)loader.getController();
			mapController.loadCurrentRestaurant(getCurrentRestaurant());
			Scene scene = new Scene(root);
			
			subStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent arg0) {
					mapController.getMap().clearMarkers();
				}
			});
			
	    	subStage.setScene(scene);
	    	subStage.setTitle("Map");
	    	subStage.show();
			}catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
	}

	// ---------------------------- Utility methods-----------------------
	
	public String getCurrentRestaurant() {
		return this.restaurantNameLabel.getText();
	}
	
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
