package gui.controller;

import be.User;
import gui.model.UserModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button logInBtn;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField usernameTxt;

    UserModel userModel;

    int schoolId1;
    int studentId1;

    //constructor
    public LoginController(){

        //instantiate
        userModel = new UserModel();
    }

    public void login(ActionEvent event) {
       String username = usernameTxt.getText();
       String password = passwordTxt.getText();
       Stage currentStage = (Stage) logInBtn.getScene().getWindow();
       currentStage.close();
       try {
           User result = userModel.login(username, password);
           if (result == null) {
               Alert alert = new Alert(Alert.AlertType.NONE);
               alert.setTitle("Error");
               alert.setHeaderText("LOGIN FAILED !!");
               alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
               alert.getDialogPane().getStyleClass().add("myDialog");
               ButtonType okButton = new ButtonType("OK");
               alert.getButtonTypes().setAll(okButton);
               alert.showAndWait();
               Parent root = FXMLLoader.load(getClass().getResource("/gui/view/loginView.fxml"));
               Stage stage = new Stage();
               Scene scene = new Scene(root);
               stage.initStyle(StageStyle.TRANSPARENT);
               stage.setScene(scene);
               stage.show();
               scene.setFill(Color.TRANSPARENT);
           }
           else {
               if (result.getTypeOfUser() == 1) {
                   schoolId1 = result.getSchool();
                   try{
                       Parent root = FXMLLoader.load(getClass().getResource("/gui/view/adminView.fxml"));
                       Stage stage = new Stage();
                       Scene scene = new Scene(root);
                       stage.initStyle(StageStyle.TRANSPARENT);
                       stage.setScene(scene);
                       stage.setUserData(schoolId1);
                       stage.show();
                       scene.setFill(Color.TRANSPARENT);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
               else if (result.getTypeOfUser() == 2) {
                   schoolId1 = result.getSchool();
                   try{
                       Parent root = FXMLLoader.load(getClass().getResource("/gui/view/teacherView.fxml"));
                       Stage stage = new Stage();
                       Scene scene = new Scene(root);
                       stage.initStyle(StageStyle.TRANSPARENT);
                       stage.setScene(scene);
                       stage.setUserData(schoolId1);
                       stage.show();
                       scene.setFill(Color.TRANSPARENT);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
               else if (result.getTypeOfUser() == 3) {
                   schoolId1 = result.getSchool();
                   studentId1 = result.getUserId();
                   String info = schoolId1 + "," + studentId1;
                   try{
                       Parent root = FXMLLoader.load(getClass().getResource("/gui/view/studentView.fxml"));
                       Stage stage = new Stage();
                       Scene scene = new Scene(root);
                       stage.initStyle(StageStyle.TRANSPARENT);
                       stage.setScene(scene);
                       stage.setUserData(info);
                       stage.show();
                       scene.setFill(Color.TRANSPARENT);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void OnClickXBtn(ActionEvent actionEvent) {
        Platform.exit();
    }

}
