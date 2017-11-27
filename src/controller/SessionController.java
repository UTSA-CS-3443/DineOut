package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import application.Group;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.ChoicePair;
import model.ImageCollection;
import model.Person;
import model.Restaurant;
import model.UserNotFoundException;

public class SessionController{

// -----------------------------------------------------------------------------
	private Group group1 = new Group();
	private String currentUser;
	@SuppressWarnings("unused")
	private String currentGroupName;
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
	
	@FXML
    private ImageView ratingStar1L;
	
	@FXML
    private ImageView ratingStar1R;
	
	@FXML
    private ImageView ratingStar2L;
	
	@FXML
    private ImageView ratingStar2R;
	
	@FXML
    private ImageView ratingStar3L;
	
	@FXML
    private ImageView ratingStar3R;
	
	@FXML
    private ImageView ratingStar4L;
	
	@FXML
    private ImageView ratingStar4R;
	
	@FXML
    private ImageView ratingStar5L;
	
	@FXML
    private ImageView ratingStar5R;
	

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
	@SuppressWarnings("unused")
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
		this.currentGroupName = groupName;
		this.group1.setGroupName(groupName);
		if(group1.findUserInFile(new Person(userName))){
			this.group1 = group1.createGroupFromTxt();
			firstRestaurant = group1.getFiveChoices().get(0);
			secondRestaurant = group1.getFiveChoices().get(1);
			thirdRestaurant = group1.getFiveChoices().get(2);
			fourthRestaurant = group1.getFiveChoices().get(3);
			fifthRestaurant = group1.getFiveChoices().get(4);
			addUsers(group1);
			setInitialRestaurant();
			setCurrentUser(userName);
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
			setStars(secondRestaurant.getRating());

		} else if (currentRestaurantEquals(secondRestaurant)) {
			setRestaurantName(thirdRestaurant.getName());
			setCuisineType(thirdRestaurant.getCuisine());
			setPrice(thirdRestaurant.getPrice());
			setStars(thirdRestaurant.getRating());

		} else if (currentRestaurantEquals(thirdRestaurant)) {
			setRestaurantName(fourthRestaurant.getName());
			setCuisineType(fourthRestaurant.getCuisine());
			setPrice(fourthRestaurant.getPrice());
			setStars(fourthRestaurant.getRating());

		} else if (currentRestaurantEquals(fourthRestaurant)) {
			setRestaurantName(fifthRestaurant.getName());
			setCuisineType(fifthRestaurant.getCuisine());
			setPrice(fifthRestaurant.getPrice());
			setStars(fifthRestaurant.getRating());
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
			setStars(fourthRestaurant.getRating());

		} else if (currentRestaurantEquals(fourthRestaurant)) {
			setRestaurantName(thirdRestaurant.getName());
			setCuisineType(thirdRestaurant.getCuisine());
			setPrice(thirdRestaurant.getPrice());
			setStars(thirdRestaurant.getRating());

		} else if (currentRestaurantEquals(thirdRestaurant)) {
			setRestaurantName(secondRestaurant.getName());
			setCuisineType(secondRestaurant.getCuisine());
			setPrice(secondRestaurant.getPrice());
			setStars(secondRestaurant.getRating());

		} else if (currentRestaurantEquals(secondRestaurant)) {
			setRestaurantName(firstRestaurant.getName());
			setCuisineType(firstRestaurant.getCuisine());
			setPrice(firstRestaurant.getPrice());
			setStars(firstRestaurant.getRating());
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
		int[] ansArray = choicePair.getAnswersM();
		this.group1.vote(this.currentUser, ansArray);
		@SuppressWarnings("unused")
		boolean createfile = this.group1.groupToTextfile();
		boolean doneVoting = this.group1.allUsersVoted();
		System.out.println(doneVoting);
		if(doneVoting)
		{	
			this.group1.setSelectedRest(this.group1.calcVotes());
			int selected = this.group1.getSelectedRest();
			System.out.println(this.group1.getFiveChoices().get(selected));
		}
		
		
		Parent loadSession;
		try {
			loadSession = FXMLLoader.load(getClass().getResource("../view/ThankYouScreen.fxml"));
			Scene sessionScene = new Scene(loadSession);
        		Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        		//------------------Centering LoginInterface on screen ---------------------------------
        		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        		primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() / 4);
        		primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() / 4.5);
        		//----------------------------------------------------------------------------------------
        	
        		primaryStage.centerOnScreen();
        		primaryStage.setScene(sessionScene);
        		primaryStage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		if (price == 1)
			this.priceLabel.setText(" $");
		if (price == 2)
			this.priceLabel.setText(" $$");
		if (price == 3)
			this.priceLabel.setText(" $$$");
		
		//this.priceLabel.setText(String.valueOf(price));
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
		setPrice(group1.getFiveChoices().get(0).getPrice());
		setStars(group1.getFiveChoices().get(0).getRating());
		changePicture();
	}
	
	/**
	 * Highlight user that logged in.
	 */
	public void setCurrentUser(String userName) {
		if ( user1Label.getText().equals(userName) )
			user1Label.setStyle("-fx-background-color:lightblue");
		if ( user2Label.getText().equals(userName) )
			user2Label.setStyle("-fx-background-color:lightblue");
		if ( user3Label.getText().equals(userName) )
			user3Label.setStyle("-fx-background-color:lightblue");
		if ( user4Label.getText().equals(userName) )
			user4Label.setStyle("-fx-background-color:lightblue");
		if ( user5Label.getText().equals(userName) )
			user5Label.setStyle("-fx-background-color:lightblue");
		if ( user6Label.getText().equals(userName) )
			user6Label.setStyle("-fx-background-color:lightblue");
		if ( user7Label.getText().equals(userName) )
			user7Label.setStyle("-fx-background-color:lightblue");
		if ( user8Label.getText().equals(userName) )
			user8Label.setStyle("-fx-background-color:lightblue");
		if ( user9Label.getText().equals(userName) )
			user9Label.setStyle("-fx-background-color:lightblue");
		if ( user10Label.getText().equals(userName) )
			user10Label.setStyle("-fx-background-color:lightblue");
	}
	
	/**
	 * Highlight user that logged in.
	 */
	public void setStars(double rating) {
//		if (rating == 0.5)
//			ratingStar1L.setVisibility(true);
//		if (rating == 1.0) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//		}
//		if (rating == 1.5) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true);
//		}
//		if (rating == 2.0) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true); ratingStar2R.setVisibility(true);
//		}
//		if (rating == 2.5) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true); ratingStar2R.setVisibility(true);
//			ratingStar3L.setVisibility(true);
//		}
//		if (rating == 3.0) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true); ratingStar2R.setVisibility(true);
//			ratingStar3L.setVisibility(true); ratingStar3R.setVisibility(true);
//		}
//		if (rating == 3.5) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true); ratingStar2R.setVisibility(true);
//			ratingStar3L.setVisibility(true); ratingStar3R.setVisibility(true);
//			ratingStar4L.setVisibility(true);
//		}
//		if (rating == 4.0) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true); ratingStar2R.setVisibility(true);
//			ratingStar3L.setVisibility(true); ratingStar3R.setVisibility(true);
//			ratingStar4L.setVisibility(true); ratingStar4R.setVisibility(true);
//		}
//		if (rating == 4.5) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true); ratingStar2R.setVisibility(true);
//			ratingStar3L.setVisibility(true); ratingStar3R.setVisibility(true);
//			ratingStar4L.setVisibility(true); ratingStar4R.setVisibility(true);
//			ratingStar5L.setVisibility(true);
//		}
//		if (rating == 5.0) {
//			ratingStar1L.setVisibility(true); ratingStar1R.setVisibility(true);
//			ratingStar2L.setVisibility(true); ratingStar2R.setVisibility(true);
//			ratingStar3L.setVisibility(true); ratingStar3R.setVisibility(true);
//			ratingStar4L.setVisibility(true); ratingStar4R.setVisibility(true);
//			ratingStar5L.setVisibility(true); ratingStar5R.setVisibility(true);
//		}
//			
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
