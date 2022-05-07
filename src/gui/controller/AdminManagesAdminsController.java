package gui.controller;

import be.School;
import be.User;
import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminManagesAdminsController implements Initializable {

    @FXML
    private ChoiceBox schoolChoiceBox;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn schoolColumn;

    @FXML
    private TableView<User> adminTableView;

    UserModel userModel;

    public AdminManagesAdminsController(){
        userModel = new UserModel();
    }

    public void updateAdminTableView() {
        schoolColumn.setCellValueFactory(new PropertyValueFactory<>("school"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        try {
            adminTableView.setItems(userModel.getAllAdmins());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAdmin(ActionEvent actionEvent) {
        int schoolId = ((School) schoolChoiceBox.getValue()).getSchoolID();
        try {
            userModel.createAdmin(schoolId, nameTxt.getText(), usernameTxt.getText(), passwordTxt.getText());
            nameTxt.clear();
            usernameTxt.clear();
            passwordTxt.clear();
            schoolChoiceBox.setValue(null);
            updateAdminTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateAdminTableView();
        schoolChoiceBox.setItems(userModel.getAllSchools());
    }
}
