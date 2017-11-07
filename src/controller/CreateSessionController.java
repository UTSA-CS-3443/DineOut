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

public class CreateSessionController {
	
	// will pass to screen via initialize() method
	private static ArrayList<Person> users = new ArrayList<Person>();
	
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
    
    @FXML
    public void done(ActionEvent e) {
	    	try {  		
	    		//hardcoding
	    		//implement to save this info to server along with groupNameTextField
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
	    			}else if(p.getHandle().charAt(0) == '@'){
	    				users.add(p);
	    			}else {
	    				continue;
	    			}
	    		}
	    		
	    		/*
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
	    		*/
	    		
	    		//check users entered have @ handle
	    		/*for(int s = 0; s < users.size(); s++) {
	    			if(users.get(s).getHandle().isEmpty() || users.get(s).getHandle().contains("@")) {
	    				
	    			}else {
	    				System.out.println("needs @symbol");
	    			}
	    			
	    		}*/
	    		
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
