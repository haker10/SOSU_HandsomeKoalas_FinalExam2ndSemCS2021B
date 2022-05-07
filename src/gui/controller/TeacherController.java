package gui.controller;

import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    @FXML
    private Button studentBtn;

    UserModel userModel;

    int schoolId1;

    public TeacherController() {
          userModel = new UserModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

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
}
