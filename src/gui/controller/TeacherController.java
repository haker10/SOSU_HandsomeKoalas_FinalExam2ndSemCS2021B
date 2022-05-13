package gui.controller;

import gui.model.CitizenTemplateModel;
import gui.model.UserModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    @FXML
    private Button logoutBtn;

    @FXML
    private Label schoolLbl;

    @FXML
    private Button studentBtn;

    @FXML
    private Button citizenTemplateBtn;


    UserModel userModel;

    CitizenTemplateModel citizenTemplateModel;

    int schoolId1;


    public TeacherController() {
          userModel = new UserModel();
          citizenTemplateModel = new CitizenTemplateModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) schoolLbl.getScene().getWindow();
            schoolId1 = (int) currentStage.getUserData();
            schoolLbl.setText(userModel.getSchoolName(schoolId1));
        });
    }

    public void onClickManageStudents(ActionEvent actionEvent) {
        Stage currentStage = (Stage) studentBtn.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/teacherManagesStudentsView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            stage.setUserData(schoolId1);
            //scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleCitizenTemplate(ActionEvent actionEvent) {

        Stage currentStage = (Stage) citizenTemplateBtn.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        currentStage.close();

        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/teacherManagesCitizenTemplateView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setUserData(schoolId1);
            stage.show();
            //scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickManageCitizen(ActionEvent actionEvent) {

    }

    public void onClickLogOutBtn(ActionEvent actionEvent) {
        Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/loginView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            // stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            // scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
