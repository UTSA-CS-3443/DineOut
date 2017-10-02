package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public Stage primaryStage;
	//public Stage stage;
	public AnchorPane rootLayout;
	
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
			loader.setLocation(Main.class.getResource("SBUserInterface.fxml"));
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
		RestaurantArray restaurantList = new RestaurantArray();
		restaurantList.fillArrayList();
		restaurantList.printRestaurantInfo();
	}
}
