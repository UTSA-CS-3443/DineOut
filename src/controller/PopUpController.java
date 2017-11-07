package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PopUpController {

    @FXML
    private Button okButton;

    @FXML
    void close(ActionEvent event) {
    		Stage stage = (Stage) okButton.getScene().getWindow();
    	    stage.close();
    }
}
