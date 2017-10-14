package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	public Stage primaryStage;
	//public Stage stage;
	public AnchorPane rootLayout;
	static Session session = new Session();
	
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
	
	
	public static void main(String[] args) {
		launch(args);
		
		for(int i = 0 ; i < session.getFiveChoices().size() ; i++) {
			Restaurant temp = session.getFiveChoices().get(i);
			System.out.println("Name = " + temp.getName());
			System.out.println("Price = " + temp.getPrice());
			System.out.println("Rating = " + temp.getRating());
			System.out.println("Cuisine = " + temp.getCuisine());
			System.out.println("Website = " + temp.getWebsite());
			System.out.println("Address = " + temp.getAddress());
			System.out.println("");
		}
		//RestaurantArray restaurantList = new RestaurantArray();
		//restaurantList.printRestaurantInfo();
		//Person person = new Person();
		//person.addUser();
	}
}
