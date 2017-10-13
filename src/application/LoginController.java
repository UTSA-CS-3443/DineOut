package application;

import java.io.IOException;

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
    	//add person to session or somwhere...
    }
    
    @FXML
    public void done(ActionEvent e) {
    	try {
        	Parent loadSession = FXMLLoader.load(getClass().getResource("SBUserInterface.fxml"));
        	Scene sessionScene = new Scene(loadSession);
        	Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        	primaryStage.setScene(sessionScene);
        	primaryStage.show();
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	}
    }
}
