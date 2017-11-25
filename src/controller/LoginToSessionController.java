package controller;

import application.Group;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Person;
import model.PersonArray;
import model.Session;

public class LoginToSessionController {

	private static PersonArray users = new PersonArray();
	public static Group group = new Group();
	
    @FXML
    private TextField groupNameTextField;

    @FXML
    private TextField twitterHandle;

    @FXML
    private Button loginButton;
    
    private String groupName;
    
    private static String userName;
    
    @FXML
    public void addSymbol(MouseEvent event) {
    		twitterHandle.setText("@");
    		twitterHandle.positionCaret(1);
    }
    
    @FXML
    public void login(ActionEvent e) {
	    	try {	
	    		//needs to be changed, cannot make another session
	    		//needs method to call the previously made session. 
	    		//----------------------------???????????????
		    //	Session session = new Session();
		    	//	session.fillRandomList();
		    	//----------------------------???????????????
	    		
	    		groupName = groupNameTextField.getText();
	    		userName = twitterHandle.getText();
//	    		Person user = new Person(twitterHandle.getText());
//	    		
	    		group.setGroupName(groupName);
	    		//Group group = new Group(groupName);
	    		//group = group.createGroupFromTxt();
		    	
	    		
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
		return group.getGroupName();
	}
    
    public static String getUserName() {
    	return userName;
    }
}



