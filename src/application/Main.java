package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public Stage stage;
	public AnchorPane layout;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
		AnchorPane root = FXMLLoader.load(getClass().getResource("/SBUserInterface.fxml"));
		
		primaryStage.setTitle("DineOut");
		primaryStage.setScene(new Scene(root, 1000, 700));
		primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//		try {
//			this.stage = primaryStage;
//			this.stage.setTitle("DineOut");
//			initLayout();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
			// load up fx file
			
			//set fxml file location
			
			//show
		
		
		/*
		try {	
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
//	public void initLayout() {
//		try {
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation( Main.class.getResource("application/SBUserInterface.fxml"));
//			this.layout = (AnchorPane) loader.load();
//			
//			Scene scene = new Scene( layout );
//			this.stage.setScene( scene );
//			this.stage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
