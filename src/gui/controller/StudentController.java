package gui.controller;

import gui.model.UserModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private Label schoolLbl;

    UserModel userModel;

    int schoolId1;

    public StudentController() {
          userModel = new UserModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) schoolLbl.getScene().getWindow();
            schoolId1 = (int) currentStage.getUserData();
            schoolLbl.setText(userModel.getSchoolName(schoolId1));
        });
    }
}
