package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	
	private StartSession session;
	
	private ArrayList<Person> tempUsers;
	
    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField twitterHandleTextField;

    @FXML
    private Button addUserButton;

    @FXML
    private Button doneWithScene;

    @FXML
    public void addPerson(ActionEvent e) {
    		Person p = new Person(userNameTextField.getText());
    		tempUsers = new ArrayList<Person>();
    		tempUsers.add(p);
    		for(Person j : tempUsers) {
    			System.out.println(j);
    		}
    }
    
    @FXML
    public void done(ActionEvent e) {
	    	try {
	        	Parent loadSession = FXMLLoader.load(getClass().getResource("SessionInterface.fxml"));
	        	Scene sessionScene = new Scene(loadSession);
	        	Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        	primaryStage.setScene(sessionScene);
	        	primaryStage.show();
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
    	session = new StartSession();
    	for(Person p : tempUsers) {
    		session.addUser(p);
    	}
    		
    }
}
