package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	public Stage primaryStage;
	//public Stage stage;
	public AnchorPane rootLayout;
	public static Session session = new Session();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("DineOut");
		this.primaryStage.setResizable(false);
		
		// calling initLayout() to configure the rootLayout within the scene graph
		initLayout();
		
	}
	
	
	public void initLayout() {
		try {
			// creating FXMLLoader to pass in .fxml file
			FXMLLoader loader = new FXMLLoader();
			// getting .fxml resource
			loader.setLocation(Main.class.getResource("LoginInterface.fxml"));
			// loading the .fxml file into the rootLayout
			rootLayout = loader.load();
			// Creating scene with the base as rootLayout (Parent of the scene graph)
			Scene scene = new Scene( rootLayout );
			// Appending .css style sheet to scene
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			// Setting scene for primaryStage with newly created scene
			primaryStage.setScene(scene);
			// "Raising the curtains" - allowing primaryStage to show the scene
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	public static void main(String[] args){
		launch(args);
		//Create user array
		PersonArray userlist1 = new PersonArray();
		//Create 7 users
		Person user1 = new Person("@BrandonLwowski");
		Person user2 = new Person("@JHorwath18");
		Person user3 = new Person("@albertjasso1");
		Person user4 = new Person("@CookiesKoo1aid");
		Person user5 = new Person("@possumIsGoodEat");
		Person user6 = new Person("@strongho1d");
		Person user7 = new Person("@TEST");
		//Add 6 of them to the group
		userlist1.addUser(user1);
		userlist1.addUser(user2);
		userlist1.addUser(user3);
		userlist1.addUser(user4);
		userlist1.addUser(user5);
		userlist1.addUser(user6);
		
		//Create a group with the array list and 6 users
		Group group1 = new Group("CupOfJava", userlist1);
		group1.sendInviteTweets();
		ArrayList<Restaurant> random5 = group1.fillRandomList();
		group1.setFiveChoices(random5);
		
		//Check if group and user exist exist
		boolean createfile = group1.groupToTextfile();
		boolean check = group1.findUserInFile(user7);
		
		int[] newVotes = new int[5];
		newVotes[0] = 1;
		newVotes[1] = 5;
		newVotes[2] = 4;
		newVotes[3] = 3;
		newVotes[4] = 2;
		
		
		group1.vote("@BrandonLwowski", newVotes);
		group1.vote("@JHorwath18", newVotes);
		group1.vote("@albertjasso1", newVotes);
		group1.sendAllUsersAns(group1.allUsersVoted());
		
		group1 = group1.createGroupFromTxt();
		createfile = group1.groupToTextfile();
		
		newVotes[0] = 3;
		newVotes[1] = 4;
		newVotes[2] = 5;
		newVotes[3] = 1;
		newVotes[4] = 2;
		
		group1.vote("@CookiesKoo1aid", newVotes);
		group1.vote("@possumIsGoodEat", newVotes);
		group1.vote("@strongho1d", newVotes);
		group1.sendAllUsersAns(group1.allUsersVoted());
		
		group1 = group1.createGroupFromTxt();
		createfile = group1.groupToTextfile();
		
		
		
			
	}
}
