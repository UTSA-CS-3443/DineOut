package application;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Person;
import model.PersonArray;
import model.Restaurant;
import model.Session;
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
		initLayout();
		
	}
	
	public void initLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/CreateSessionOrLoginInterface.fxml"));
			rootLayout = loader.load();
			Scene scene = new Scene( rootLayout );
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args){
		launch(args);
		
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
		
		
		
		Group group1 = new Group("CupOfJava", userlist1);
 		group1.sendInviteTweets();
 		
 		//Check if group and user exist exist
 		boolean createfile = group1.groupToTextfile();
 		boolean check = group1.findUserInFile(user7);
 		
 		int[] newVotes = new int[5];
 		newVotes[0] = 1;
 		newVotes[1] = 5;
 		newVotes[2] = 4;
 		newVotes[3] = 3;
 		newVotes[4] = 2;
		
		
		
		group1.vote("@JHorwath18", newVotes);
  		group1.vote("@albertjasso1", newVotes);
  		group1.sendAllUsersAns(group1.allUsersVoted());
 
 		PersonArray userlist = new PersonArray();
 		Restaurant selected = session.getFiveChoices().get(1);
 		
 
 		Person current = new Person("@BrandonLwowski");
 		Person current2 = new Person("@JHorwath18");
 		userlist.addUser(current);
 		userlist.addUser(current2);
  		
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
