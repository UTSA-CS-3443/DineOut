package application;

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

public class LoginController {
	
	//Removed, don't neeed Session here.
	//private Session session = new Session();
	
	// We'll handle the users here, then SessionController
	// will pass to screen via initialize() method
	private static ArrayList<Person> users = new ArrayList<Person>();
	
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
    		Person p = new Person(userNameTextField.getText(), twitterHandleTextField.getText());
    		users.add(p);
    		userNameTextField.setText("");
    		twitterHandleTextField.setText("");
    }

	public static ArrayList<Person> getUsers(){
    		return users;
    }
    
    @FXML
    public void done(ActionEvent e) {
	    	try {
	        	Parent loadSession = FXMLLoader.load(getClass().getResource("SessionInterface.fxml"));
	        	Scene sessionScene = new Scene(loadSession);
	        	Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        	//------------------Centering SessionInterface on screen --------------------------------
	        	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	        	primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() / 4);
	        	primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() / 4.5);
	        	//----------------------------------------------------------------------------------------
	        	primaryStage.setScene(sessionScene);
	        	primaryStage.show();
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
	    	
	    	// -- Removed, handling users inside LoginController itself rather than Session
	    	//for(Person p : users) {
	    	//	session.addUser(p);
	    	//}    
    }
    
}
