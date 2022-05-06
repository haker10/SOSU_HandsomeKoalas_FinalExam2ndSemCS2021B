package gui.controller;

import be.School;
import be.User;
import gui.model.UserModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminManagesTeachersController implements Initializable {

    @FXML
    private TableColumn usernameColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn schoolColumn;

    @FXML
    private TableColumn passwordColumn;

    @FXML
    private TableView teachersTableView;

    @FXML
    private TextField newNameTxt;

    @FXML
    private TextField newPasswordTxt;

    @FXML
    private ChoiceBox<Integer> schoolChoiceBox;

    @FXML
    private TextField newUserNameTxt;

    UserModel userModel;

    public AdminManagesTeachersController(){
        userModel = new UserModel();
    }

    public void updatePlayListTableView(){
        schoolColumn.setCellValueFactory(new PropertyValueFactory<>("school"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        try {
            teachersTableView.setItems(userModel.getAllTeachers());

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void loadData(){
        schoolChoiceBox.getItems().addAll(1,2,3);
        updatePlayListTableView();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();

    }
    public void addTeacher(ActionEvent event) {
        JFrame jFrame = new JFrame();
        try{
            if (schoolChoiceBox.getValue() == null || newNameTxt.getText().isEmpty() || newUserNameTxt.getText().isEmpty() || newPasswordTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(jFrame, "One field is empty!\nPlease try again!");
            else {
                userModel.createTeacher(schoolChoiceBox.getValue(), newNameTxt.getText(), newUserNameTxt.getText(), newPasswordTxt.getText());
                JOptionPane.showMessageDialog(jFrame, "Teacher created");
                updatePlayListTableView();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void editTeacher(ActionEvent event) {

    }

    public void deleteTeacher(ActionEvent event) {
        JFrame jFrame = new JFrame();
        try {

            if (teachersTableView.getSelectionModel().getSelectedItem() == null){
                JOptionPane.showMessageDialog(jFrame, "Choose a Teacher!\nPlease try again");
            }
            else {
                userModel.deleteTeacher(((User) teachersTableView.getSelectionModel().getSelectedItem()).getUserId());
                JOptionPane.showMessageDialog(jFrame, "Teacher deleted");
                updatePlayListTableView();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}