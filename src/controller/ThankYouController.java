package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ThankYouController {

	@FXML
    private Button menuButton;
	
	@FXML
    private ImageView ThankYou;
	
	@FXML
	private void menu(ActionEvent e) {
		Parent loadSession;
		try {
			loadSession = FXMLLoader.load(getClass().getResource("../view/CreateSessionOrLoginInterface.fxml"));
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
}
