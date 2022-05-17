package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ImageController implements Initializable {

    @FXML
    private Button okBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void OnClickOk(ActionEvent actionEvent) {
        Stage currentStage = (Stage) okBtn.getScene().getWindow();
        currentStage.close();
    }
}
