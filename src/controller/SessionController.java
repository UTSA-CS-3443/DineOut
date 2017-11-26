package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import application.Group;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.ChoicePair;
import model.ImageCollection;
import model.Person;
import model.Restaurant;
import model.Session;
import model.UserNotFoundException;

public class SessionController{
	

// -----------------------------------------------------------------------------
	private Group group1 = new Group();
	private String currentUser;
	private Restaurant firstRestaurant;
	private Restaurant secondRestaurant;
	private Restaurant thirdRestaurant;
	private Restaurant fourthRestaurant;
	private Restaurant fifthRestaurant;
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
    private ImageView images;
	
	@FXML
	ComboBox<Integer> rankComboBox = new ComboBox<Integer>();
	
	@FXML
	RadioButton loveChoice = new RadioButton();
	
	@FXML
	RadioButton neutralChoice = new RadioButton();
	
	@FXML
	RadioButton hateChoice = new RadioButton();
	
	ToggleGroup group = new ToggleGroup();
	RadioButton choice;
	public ChoicePair<String, String> choicePair = new ChoicePair<String, String>();
	private ImageCollection imageList = new ImageCollection();
	
	/**
	 * Initialize method for SessionController, automatically called corresponding
	 * FXML is loaded into the root layout. Called after all @FXML annotated members
	 * have been called
	 */
	@FXML
	public void initialize()throws UserNotFoundException{
		String groupName = LoginToSessionController.getGroupName();
		String userName = LoginToSessionController.getUserName();
		group1.setGroupName(groupName);
		group1 = group1.createGroupFromTxt();
		if(group1.findUserInFile(new Person(userName))){
			firstRestaurant = group1.getFiveChoices().get(0);
			secondRestaurant = group1.getFiveChoices().get(1);
			thirdRestaurant = group1.getFiveChoices().get(2);
			fourthRestaurant = group1.getFiveChoices().get(3);
			fifthRestaurant = group1.getFiveChoices().get(4);
			addUsers(group1);
			setInitialRestaurant();
			initRadioBtns();
			this.currentUser = userName;
		}else {
			throw new UserNotFoundException(userName + " not found in Group: " + group1.getGroupName());
		}
	}


	/**
	 * VERY BASIC CRAPPY UNOPTIMIZED WAY OF GRABBING NEXT RESTAURANT. NEED TO
	 * IMPLEMENT DIFFERENT APPROACH AND METHOD FOR EASIER GRABBING.
	 * @param e A reference to an ActionEvent
	 */
	@FXML
	public void nextRestaurant(ActionEvent e) {
		choicePair.addPair(choice.getText(), getCurrentRestaurant());
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
		changePicture();
	}

	/**
	 * VERY BASIC CRAPPY UNOPTIMIZED WAY OF GRABBING PREVIOUS RESTAURANT. NEED TO
	 * IMPLEMENT DIFFERENT APPROACH AND METHOD FOR EASIER GRABBING.
	 * @param e A reference to an ActionEvent
	 */
	@FXML
	public void previousRestaurant(ActionEvent e) {
		choicePair.addPair(choice.getText(), getCurrentRestaurant());
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
		changePicture();
	}

	public void initRadioBtns() {
		hateChoice.setToggleGroup(group);
		loveChoice.setToggleGroup(group);
		neutralChoice.setToggleGroup(group);
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		        if (group.getSelectedToggle() != null) {
		        	choice = (RadioButton) group.getSelectedToggle();
		        }
		      }
		});
		group.selectToggle(neutralChoice);
	}
	
	@FXML
	public void submit(ActionEvent e) {
		choicePair.addPair(choice.getText(), getCurrentRestaurant()); //to record option they click submit on
		choicePair.fillAnswerChoices();
		int[] ans = choicePair.getAnswersM();
		this.group1.vote(this.currentUser, ans);
		boolean createfile = this.group1.groupToTextfile();
		
		
		//Fill users answers list and create new text file
		

	}
	
	/**
	 * RUDIMENTARY IF ELSE STATEMENTS JUST TO CHECK IF LABELS / CSV IS WORKING. NEED
	 * REWORK
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
			
			subStage.setResizable(false);
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
	 * @param name A reference to the name of a Restaurant 
	 */
	public void setRestaurantName(String name) {
		this.restaurantNameLabel.setText(name);
	}
	
	/**
	 * Sets cuisine type in display
	 * @param cuisineType A reference to the cuisine type of a Restaurant 
	 */
	public void setCuisineType(String cuisineType) {
		this.cuisineTypeLabel.setText(cuisineType);
	}

	/**
	 * Sets price in display
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
	 * 
	 */
	public void changePicture() {
		for(Map.Entry<String, Image> entry : ImageCollection.images.entrySet()) {
			String key = (String) entry.getKey();
			Image value = entry.getValue();
			
			if(getCurrentRestaurant().toLowerCase().equals(key.toLowerCase())) {
				images.setImage(value);
			}
		}
	}

	/**
	 * Sets initial restaurant on opening scene, will probably need redoing with
	 * multiple users
	 */
	public void setInitialRestaurant() {
		restaurantNameLabel.setText(group1.getFiveChoices().get(0).getName());
		cuisineTypeLabel.setText(group1.getFiveChoices().get(0).getCuisine());
		priceLabel.setText(String.valueOf(group1.getFiveChoices().get(0).getPrice()));
		changePicture();
	}
	
	/**
     * Method to add users given a PersonArray
     * (For logging in)
     * @param personArray
     */
    public void addUsers(Group group) {
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
       
        for (int i = 0 ; i < group.getListOfUsers().getArraySize() ; i++) {
            userLabels.get(i).setText(group.getListOfUsers().getUser(i).getHandle());
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
}
