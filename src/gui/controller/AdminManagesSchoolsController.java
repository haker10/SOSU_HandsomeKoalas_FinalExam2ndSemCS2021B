package gui.controller;

import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminManagesSchoolsController implements Initializable {

    @FXML
    private TextField newSchoolTxt;

    @FXML
    private ListView schoolsListView;

    UserModel userModel;

    public AdminManagesSchoolsController() {
        userModel = new UserModel();
    }

    public void updateSchoolsTableView() {
        try {
            schoolsListView.setItems(userModel.getAllSchools());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateSchoolsTableView();
    }

    public void createNewSchool(ActionEvent actionEvent) {
        JFrame frame = new JFrame();
        try {
            if (newSchoolTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(frame, "Please enter a school name");
            else {
                userModel.createNewSchool(newSchoolTxt.getText());
                newSchoolTxt.setText("");
                updateSchoolsTableView();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
