package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Person;
import model.PersonArray;
import model.Restaurant;
import model.Session;
import model.TwitterClass;
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
			loader.setLocation(Main.class.getResource("../view/LoginInterface.fxml"));
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
		
		PersonArray userlist = new PersonArray();
		Restaurant selected = session.getFiveChoices().get(1);
		
		//TODO Loop through csv find groupname and save users into list 
		Person current = new Person("@BrandonLwowski");
		Person current2 = new Person("@JHorwath18");
		userlist.addUser(current);
		userlist.addUser(current2);
		
		TwitterClass test = new TwitterClass(userlist, selected);
		//test.sendTweet();
		
		
		
	}
}
