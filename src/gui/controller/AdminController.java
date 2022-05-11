package gui.controller;


import be.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import gui.model.UserModel;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Label schoolLbl;

    @FXML
    private Button adminBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button schoolBtn;

    @FXML
    private Button studentBtn;

    @FXML
    private Button teacherBtn;

    UserModel userModel;

    int schoolId1;

    public AdminController() {
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


    public void onClickManageTeachers(ActionEvent actionEvent) {
        Stage currentStage = (Stage) teacherBtn.getScene().getWindow();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/adminManagesTeachersView.fxml"));
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

    public void onClickManageSchools(ActionEvent actionEvent) {
        Stage currentStage = (Stage) schoolBtn.getScene().getWindow();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/adminManagesSchoolsView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            //scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickManageStudents(ActionEvent actionEvent) {
        Stage currentStage = (Stage) studentBtn.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/adminManagesStudentsView.fxml"));
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

    public void onClickManageAdmins(ActionEvent actionEvent) {
        Stage currentStage = (Stage) adminBtn.getScene().getWindow();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/adminManagesAdminsView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            //scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
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
