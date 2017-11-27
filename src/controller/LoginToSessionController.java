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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginToSessionController {

    @FXML
    private TextField groupNameTextField;

    @FXML
    private TextField twitterHandle;

    @FXML
    private Button loginButton;
    
    private static String groupName;
    private static String userName;
    
    @FXML
    public void addSymbol(MouseEvent event) {
    		twitterHandle.setText("@");
    		twitterHandle.positionCaret(1);
    }
    
    @FXML
    public void login(ActionEvent e) {
	    	try {	    		
	    		groupName = groupNameTextField.getText();
	    		userName = twitterHandle.getText();
	        	Parent loadSession = FXMLLoader.load(getClass().getResource("../view/SessionInterface.fxml"));
	        	Scene sessionScene = new Scene(loadSession);
	        	Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();        	
	        	//------------------Centering LoginInterface on screen ---------------------------------
	        	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	        	primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() / 4);
	        	primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() / 4.5);
	        	//----------------------------------------------------------------------------------------
	        	//primaryStage.centerOnScreen();
	        	primaryStage.setScene(sessionScene);
	        	primaryStage.show();	
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	} 
    	
    }	
    
    public static String getGroupName(){
		return groupName;
	}
    
    public static String getUserName() {
    	return userName;
    }
}



