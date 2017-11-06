package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Person;

public class LoginController {
	
	// will pass to screen via initialize() method
	private static ArrayList<Person> users = new ArrayList<Person>();
	
    @FXML
    private TextField GroupNameTextField;

    @FXML
    private TextField userNameTextField0;

    @FXML
    private TextField userNameTextField1;

    @FXML
    private TextField userNameTextField2;

    @FXML
    private TextField userNameTextField3;

    @FXML
    private TextField userNameTextField4;

    @FXML
    private TextField userNameTextField5;

    @FXML
    private TextField userNameTextField6;

    @FXML
    private TextField userNameTextField7;

    @FXML
    private TextField userNameTextField8;

    @FXML
    private TextField userNameTextField9;

    @FXML
    private Button doneWithScene;

	public static ArrayList<Person> getUsers(){
    		return users;
    }
    
    @FXML
    public void done(ActionEvent e) {
	    	try {  		
	        	Parent loadSession = FXMLLoader.load(getClass().getResource("../view/SessionInterface.fxml"));
	        	Scene sessionScene = new Scene(loadSession);
	        	Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        	
	        	//------------------Centering SessionInterface on screen ---------------------------------
	        	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	        	primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() / 4);
	        	primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() / 4.5);
	        	//----------------------------------------------------------------------------------------
	        	
	        	primaryStage.setScene(sessionScene);
	        	primaryStage.show();
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
    }
    
}
