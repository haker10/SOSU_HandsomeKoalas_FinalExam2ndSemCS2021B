package gui.controller;

import gui.model.UserModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    UserModel userModel;

    public StudentController() {
          userModel = new UserModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
