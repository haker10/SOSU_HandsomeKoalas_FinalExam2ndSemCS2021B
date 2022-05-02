package gui.controller;

import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    //constructor
    public LoginController(){

        //instantiate
        userModel = new UserModel();
    }

    public void login(ActionEvent event) {
       String username = usernameTxt.getText();
       String password = passwordTxt.getText();
       userModel.login(username, password);
        System.out.println("login successful");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
