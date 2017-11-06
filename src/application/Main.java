package application;

import java.io.IOException;

import controller.SessionController;
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
import javafx.scene.layout.Pane;


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
			loader.setLocation(Main.class.getResource("../view/LoginInterface.fxml"));
			rootLayout = loader.load();
			Scene scene = new Scene( rootLayout );
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	//public SessionController getSessionController() {
	//	return sessionController;
	//}
	
	
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
