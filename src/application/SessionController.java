package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

    // --------------Scrapping backgrounds for now until we can get entire program running---------
    
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

    //---------------------------------------------------------------------------------------------
    
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
    
    // Method for adding users to arraylist to iterate and set userLabels
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
    	
    	// Loop for setting users from LoginController to labels in order
    	for(int i = 0 ; i < LoginController.getUsers().size() ; i++) {
			userLabels.get(i).setText(LoginController.getUsers().get(i).getName());
    	}
    }
    

    //TEST METHOD TO OPEN WEBPAGE ON BUTTON CLICK
    public static void openWebpage(String url) {
    	if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

   
    //Sets initial restaurant on opening scene, will probably need redoing with multiple users
    public void setInitialRestaurant() {
    	restaurantNumberLabel.setText("Choice 1");
    	restaurantNameLabel.setText(Main.session.getFiveChoices().get(0).getName());
    	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(0).getCuisine());
    	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(0).getPrice()));
    	
    	// Need to initialize website button somehow
    }
    
    
    // This method is automatically called by FXMLLoader when it gets loaded into the root layout
    // MUST BE NO ARGS
    // Initialize will need to set users and first restaurant. 
    @FXML
    private void initialize() {
    	friendsInvitedLabel.setStyle("-fx-background-color: lightblue");
    	//initalize user list here
    	addUsers();
    	//initialize first restaurant
    	setInitialRestaurant();
    	
    }
    
    // VERY BASIC CRAPPY UNOPTIMIZED WAY OF GRABBING NEXT RESTAURANT. NEED TO ADD IMPLEMENT
    // DIFFERENT APPROACH AND METHOD FOR EASIER GRABBING.
    @FXML
    public void nextRestaurant(ActionEvent e) {
    	if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(0).getName())) {
    		restaurantNumberLabel.setText("Choice 2");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(1).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(1).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(1).getPrice()));
        	
    	}else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(1).getName())) {
    		restaurantNumberLabel.setText("Choice 3");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(2).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(2).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(2).getPrice()));
        	
    	}else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(2).getName())) {
    		restaurantNumberLabel.setText("Choice 4");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(3).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(3).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(3).getPrice()));
        	
    	}else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(3).getName())) {
    		restaurantNumberLabel.setText("Choice 5");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(4).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(4).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(4).getPrice()));
    	}
    }
    
    @FXML
    public void previousRestaurant(ActionEvent e) {
    	if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(4).getName())) {
    		restaurantNumberLabel.setText("Choice 4");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(3).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(3).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(3).getPrice()));
        	
    	}else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(3).getName())) {
    		restaurantNumberLabel.setText("Choice 3");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(2).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(2).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(2).getPrice()));
        	
    	}else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(2).getName())) {
    		restaurantNumberLabel.setText("Choice 2");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(1).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(1).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(1).getPrice()));
        	
    	}else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(1).getName())) {
    		restaurantNumberLabel.setText("Choice 1");
        	restaurantNameLabel.setText(Main.session.getFiveChoices().get(0).getName());
        	cuisineTypeLabel.setText(Main.session.getFiveChoices().get(0).getCuisine());
        	priceLabel.setText(String.valueOf(Main.session.getFiveChoices().get(0).getPrice()));
    	}
    }
    
    //RUDIMENTARY IF ELSE STATEMENTS JUST TO CHECK IF LABELS / CSV IS WORKING. NEED REWORK
    @FXML
    public void toRestaurantWebsite(ActionEvent e) {
    	if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(0).getName())) {
    		openWebpage(Main.session.getFiveChoices().get(0).getWebsite());
    	} else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(1).getName())) {
    		openWebpage(Main.session.getFiveChoices().get(1).getWebsite());
    	} else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(2).getName())) {
    		openWebpage(Main.session.getFiveChoices().get(2).getWebsite());
    	} else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(3).getName())) {
    		openWebpage(Main.session.getFiveChoices().get(3).getWebsite());
    	} else if(restaurantNameLabel.getText().equals(Main.session.getFiveChoices().get(4).getName())) {
    		openWebpage(Main.session.getFiveChoices().get(4).getWebsite());
    	}
    }
}
