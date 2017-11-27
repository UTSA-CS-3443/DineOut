package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoadingScreenController implements Initializable {

	public Stage primaryStage;
	
	@FXML
    private ProgressBar progressBar;
	
	@FXML
    private Button startButton;
	
	@FXML
    private ImageView logo;
	
	class bg_Thread implements Runnable {
		
		@Override
		public void run() {
			for (int i = 0; i <= 100; i++)
			{
				try {
					progressBar.setProgress(i / 100.0);
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (progressBar.getProgress() == 1)
				startButton.setVisible(true);
		}
	}
	
	@FXML
	private void start(ActionEvent e) {
		if (progressBar.getProgress() == 1) {
			Parent loadSession;
			try {
				loadSession = FXMLLoader.load(getClass().getResource("../view/CreateSessionOrLoginInterface.fxml"));
				Scene sessionScene = new Scene(loadSession);
        			Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        			//------------------Centering LoginInterface on screen ---------------------------------
        			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        			primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() / 4);
        			primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() / 4.5);
        			//----------------------------------------------------------------------------------------
        	
        			primaryStage.centerOnScreen();
        			primaryStage.setScene(sessionScene);
        			primaryStage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			Thread th = new Thread(new bg_Thread());
			th.start();
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		progressBar.setProgress(0.0);
		startButton.fire();
	}

}
