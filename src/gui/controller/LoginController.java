package gui.controller;

import be.User;
import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
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
           JFrame jFrame = new JFrame();
           if (result == null) {
               JOptionPane.showMessageDialog(jFrame, "LOGIN FAILED !!");
               Parent root = FXMLLoader.load(getClass().getResource("/gui/view/loginView.fxml"));
               Stage stage = new Stage();
               Scene scene = new Scene(root);
               //stage.initStyle(StageStyle.TRANSPARENT);
               stage.setScene(scene);
               stage.show();
               //scene.setFill(Color.TRANSPARENT);
           }
           else {
               if (result.getTypeOfUser() == 1) {
                   schoolId1 = result.getSchool();
                   try{
                       Parent root = FXMLLoader.load(getClass().getResource("/gui/view/adminView.fxml"));
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
               else if (result.getTypeOfUser() == 2) {
                   schoolId1 = result.getSchool();
                   try{
                       Parent root = FXMLLoader.load(getClass().getResource("/gui/view/teacherView.fxml"));
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
               else if (result.getTypeOfUser() == 3) {
                   schoolId1 = result.getSchool();
                   try{
                       Parent root = FXMLLoader.load(getClass().getResource("/gui/view/studentView.fxml"));
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
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
