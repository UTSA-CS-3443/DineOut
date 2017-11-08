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
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Session;

public class LoginToSessionController {

    @FXML
    private TextField groupNameTextField;

    @FXML
    private TextField twitterHandle;

    @FXML
    private Button loginButton;
    
    @FXML
    public void login(ActionEvent e) {
	    	try {
	    		//implement
	    		//retrieve text in twitterHandle to look up in the server 
	    		//error checking for @ sign
	    		if(twitterHandle.getText().charAt(0) != '@') {
	    			Stage subStage = new Stage();
	    			FXMLLoader loader = new FXMLLoader();
	    			Pane root = loader.load(getClass().getResource("../view/PopUpError.fxml").openStream());
	    			Scene scene = new Scene(root);
	    			subStage.setResizable(false);
	    			subStage.setScene(scene);
	    			subStage.setTitle("Error!");
	    			subStage.show();
	    		}else {
	    			
	    			
	    		//needs to be changed, cannot make another session
	    		//needs method to call the previously made session. 
	    		//----------------------------???????????????
		    	Session session = new Session();
		    	session.fillRandomList();
		    	//----------------------------???????????????
	    		
	        	Parent loadSession = FXMLLoader.load(getClass().getResource("../view/SessionInterface.fxml"));
	        	Scene sessionScene = new Scene(loadSession);
	        	Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        	
	        	//------------------Centering LoginInterface on screen ---------------------------------
	        	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	        	primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() / 4);
	        	primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() / 4.5);
	        	//----------------------------------------------------------------------------------------
	        	
	        	primaryStage.setScene(sessionScene);
	        	primaryStage.show();
	    		}
	    		
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	} catch (StringIndexOutOfBoundsException e1) {
	    		System.out.println("you didnt enter a handle");
	    	} catch (IndexOutOfBoundsException e1) {
		    	e1.printStackTrace();
	    	} 
    	
    }		 
}