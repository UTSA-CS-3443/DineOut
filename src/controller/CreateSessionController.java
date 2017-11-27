package controller;

import java.io.IOException;
import application.Group;
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
import model.Person;
import model.PersonArray;

public class CreateSessionController {
	
	// will pass to screen via initialize() method
	private static PersonArray users = new PersonArray();
	
    @FXML
    private TextField groupNameTextField;

    @FXML
    private TextField twitterHandleTextField0;
    
    @FXML
    private TextField twitterHandleTextField1;
    
    @FXML
    private TextField twitterHandleTextField2;
    
    @FXML
    private TextField twitterHandleTextField3;
    
    @FXML
    private TextField twitterHandleTextField4;
    
    @FXML
    private TextField twitterHandleTextField5;
    
    @FXML
    private TextField twitterHandleTextField6;
    
    @FXML
    private TextField twitterHandleTextField7;
    
    @FXML
    private TextField twitterHandleTextField8;
    
    @FXML
    private TextField twitterHandleTextField9;
    
    @FXML
    private Button doneWithScene;
    
    private String groupName;
    
    @FXML
    public void addSymbol(MouseEvent event) {
    		TextField tf = (TextField)event.getSource();
    		tf.setText("@");
    		tf.positionCaret(1);
    }
    
    @FXML
    public void done(ActionEvent e) {
	    	try {
	    		groupName = groupNameTextField.getText();
	    		
	    		Person a = new Person(twitterHandleTextField0.getText());
	    		Person b = new Person(twitterHandleTextField1.getText());
	    		Person c = new Person(twitterHandleTextField2.getText());
	    		Person d = new Person(twitterHandleTextField3.getText());
	    		Person f = new Person(twitterHandleTextField4.getText());
	    		Person g = new Person(twitterHandleTextField5.getText());
	    		Person h = new Person(twitterHandleTextField6.getText());
	    		Person i = new Person(twitterHandleTextField7.getText());
	    		Person j = new Person(twitterHandleTextField8.getText());
	    		Person k = new Person(twitterHandleTextField9.getText());
	    		
	    		Person[] sessionUsers = {a,b,c,d,f,g,h,i,j,k};
	    		for(Person p : sessionUsers) {
	    			if(p.getHandle().isEmpty() || p.getHandle() == null) {
	    				continue;
	    			}else if(p.getHandle().length() == 1) {
	    				continue;
	    			}else {
	    				users.addUser(p);
	    			}
	    		}
	    		
	    		Group group = new Group(groupName, users);
	    		group.fillRandomList();
	    		group.setFiveChoices(group.getFiveChoices());
			boolean createfile = group.groupToTextfile();
	    		if (createfile == true)
	    			group.sendInviteTweets();
	    		
	    		//-------------- changing scene
	    		Parent loadSession = FXMLLoader.load(getClass().getResource("../view/CreateSessionOrLoginInterface.fxml"));
	        	Scene sessionScene = new Scene(loadSession);
	        	Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        	
	        	//------------------Centering SessionInterface on screen ---------------------------------
	        	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	        	primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() / 4);
	        	primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() / 5.5);
	        	//----------------------------------------------------------------------------------------
	        	primaryStage.centerOnScreen();
	        	primaryStage.setScene(sessionScene);
	        	primaryStage.show();
	    	} catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
    }
    
	public static PersonArray getUsers(){
		return users;
	}
    
}
