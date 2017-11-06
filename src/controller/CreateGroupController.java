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

public class CreateGroupController {
	
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
    
    @FXML
    public void done(ActionEvent e) {
	    	try {  		
	    		//hardcoding
	    		//implement to save this info to server
	    		Person a = new Person(userNameTextField0.getText());
	    		Person b = new Person(userNameTextField1.getText());
	    		Person c = new Person(userNameTextField2.getText());
	    		Person d = new Person(userNameTextField3.getText());
	    		Person f = new Person(userNameTextField4.getText());
	    		Person g = new Person(userNameTextField5.getText());
	    		Person h = new Person(userNameTextField6.getText());
	    		Person i = new Person(userNameTextField7.getText());
	    		Person j = new Person(userNameTextField8.getText());
	    		Person k = new Person(userNameTextField9.getText());
	    		users.add(a);
	    		users.add(b);
	    		users.add(c);
	    		users.add(d);
	    		users.add(f);
	    		users.add(g);
	    		users.add(h);
	    		users.add(i);
	    		users.add(j);
	    		users.add(k);
	    		
	    		//-------------- changing scene
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
    
	public static ArrayList<Person> getUsers(){
		return users;
	}
    
}
