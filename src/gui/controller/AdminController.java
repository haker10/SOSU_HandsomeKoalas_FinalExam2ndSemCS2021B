package gui.controller;

import gui.view.util.PopUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import gui.model.UserModel;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Label schoolLbl;

    @FXML
    private Button logoutBtn;

    UserModel userModel;

    @FXML
    AdminManagesAdminsController adminController;

    int schoolId1;

    public AdminController() {
        userModel = new UserModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) schoolLbl.getScene().getWindow();
            schoolId1 = (int) currentStage.getUserData();
            try {
                schoolLbl.setText(userModel.getSchoolName(schoolId1));
            } catch (Exception e) {
                PopUp.showError(e.getMessage());
            }
        });
    }

    public void onClickLogOutBtn(ActionEvent actionEvent) {
        Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/loginView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            PopUp.showError(e.getMessage());
        }
    }

    public void OnClickXBtn(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void adminTabSelected(Event event) throws Exception {
        adminController.updateSchoolComboBox();
    }
}

