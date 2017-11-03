package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MapViewStage {
	
	public MapViewStage() {
		try {
		Stage subStage = new Stage();
    	Parent loadSession = FXMLLoader.load(getClass().getResource("../view/MapView.fxml"));
    	Scene sessionScene = new Scene(loadSession);
    	subStage.setScene(sessionScene);
    	subStage.setTitle("Map");
    	subStage.show();
		}catch (IOException e1) {
    		e1.printStackTrace();
    	}
	}
}

