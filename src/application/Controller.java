package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Controller {

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

    @FXML
    private Pane user1LabelBackground;

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

    @FXML
    private Pane user2LabelBackground;

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
    public void nextRestaurant(ActionEvent e) {
    	// Goto next restaurant when nextRestaurantButton is clicked
    	// set number in sequence in title
    	user1Label.setText("Mark");
    	user1LabelBackground.setOpacity(.3);
    	user1LabelBackground.setStyle("-fx-background-color: red;");
    	user1IndicatorBackground.setOpacity(.3);
    	user1IndicatorBackground.setStyle("-fx-background-color: red;");
    	//restaurantNameLabel.setText(RestaurantList().getRestaurantList());
    	// set name
    	// set cuisine
    	// set price
    	// set website
    	// set rating
    	// set map
    }
    
    @FXML
    public void previousRestaurant() {
    	// Goto previous restaurant when nextRestaurantButton is clicked
    	// set number in sequence in title
    	// set name
    	// set cuisine
    	// set price
    	// set website
    	// set rating
    	// set map
    }
    
    @FXML
    public void addUser() {
    	// add user when they connect to session
    	// add name
    	// set name label opacity
    	// set name label background pane opacity
    	// set indicator opacity
    	// set Indicator background pane opacity
    }
    
    @FXML
    public void toRestaurantWebsite() {
    	// goto restaurant website given URL
    }
    
    
    

}
