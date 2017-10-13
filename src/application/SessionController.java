package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SessionController {
	
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
    
    public void addUsers(){
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

    	for(int i = 0 ; i < LoginController.getUsers().size() ; i++) {
			userLabels.get(i).setText(LoginController.getUsers().get(i).getName());
    	}
    }
    
    
    // This method is automatically called by FXMLLoader when it gets loaded into the root layout
    // MUST BE NO ARGS
    @FXML
    private void initialize() {
    	friendsInvitedLabel.setStyle("-fx-background-color: lightblue");
    	//initalize user list here
    	addUsers();
    }
    
    
    @FXML
    public void nextRestaurant(ActionEvent e) {
    	
    	//Main.restaurantList.getRestaurantList();
    	//restaurantNameLabel.setText(restaurantChoices.get(i).getName());
    	//cuisineTypeLabel.setText(restaurantChoices.get(i).getCuisine());
    	//priceLabel.setText("");
    	//websiteButton.
    	
    	
    	// Goto next restaurant when nextRestaurantButton is clicked
    	// set number in sequence in title
/*   	Person p = LoginController.getUsers().get(0);
			user1Label.setText(p.toString());*/
	
//  	user1LabelBackground.setOpacity(.3);
//  user1LabelBackground.setStyle("-fx-background-color: red;");
//  user1IndicatorBackground.setOpacity(.3);
//  user1IndicatorBackground.setStyle("-fx-background-color: red;");
    	//restaurantNameLabel.setText(RestaurantList().getRestaurantList());
    	// set name
    	// set cuisine
    	// set price
    	// set website
    	// set rating
    	// set map
    }
    
    @FXML
    public void previousRestaurant(ActionEvent e) {
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
    public void toRestaurantWebsite(ActionEvent e) {
    	//Hyperlink  link = new Hyperlink() // 5restaurantChoices.get().getWebsite()
    	//getHostServices().showDocument("www.google.com");
    	// goto restaurant website given URL
    }
    
    
    

}
