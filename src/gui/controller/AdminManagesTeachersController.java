package gui.controller;

import be.School;
import be.User;
import dal.dao.SchoolDAO;
import gui.model.UserModel;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import javax.swing.*;
import javafx.event.EventHandler;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.RowId;
import java.util.ResourceBundle;

public class AdminManagesTeachersController implements Initializable {

    @FXML
    private Label schoolLbl;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableView<User> teachersTableView;

    @FXML
    private TextField newNameTxt;

    @FXML
    private TextField newPasswordTxt;

    @FXML
    private TextField newUserNameTxt;

    UserModel userModel;

    int schoolId1;

    public AdminManagesTeachersController(){
        userModel = new UserModel();
    }

    public void updateTeacherTableView(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        try {
            teachersTableView.setItems(userModel.getAllTeachers(schoolId1));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) schoolLbl.getScene().getWindow();
            schoolId1 = (int) currentStage.getUserData();
            schoolLbl.setText(userModel.getSchoolName(schoolId1));
            updateTeacherTableView();
            teachersTableView.setEditable(true);
            editTeacherFromTableView();
        });
    }

    public void addTeacher(ActionEvent event) {
        JFrame jFrame = new JFrame();
        try{
            if (newNameTxt.getText().isEmpty() || newUserNameTxt.getText().isEmpty() || newPasswordTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(jFrame, "One field is empty!\nPlease try again!");
            else {
                userModel.createTeacher(schoolId1, newNameTxt.getText(), newUserNameTxt.getText(), newPasswordTxt.getText());
                JOptionPane.showMessageDialog(jFrame, "Teacher created");
                updateTeacherTableView();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void editTeacherFromTableView() {
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        ((User) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                        TablePosition pos = teachersTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = teachersTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                    }
                }
        );

        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        usernameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        ((User) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setUsername(t.getNewValue());
                        TablePosition pos = teachersTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = teachersTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                    }
                }
        );

        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        ((User) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPassword(t.getNewValue());
                        TablePosition pos = teachersTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = teachersTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                    }
                }
        );

    }

    public void deleteTeacher(ActionEvent event) {
        JFrame jFrame = new JFrame();
        try {

            if (teachersTableView.getSelectionModel().getSelectedItem() == null){
                JOptionPane.showMessageDialog(jFrame, "Choose a Teacher!\nPlease try again");
            }
            else {
                userModel.deleteUser(((User) teachersTableView.getSelectionModel().getSelectedItem()).getUserId());
                JOptionPane.showMessageDialog(jFrame, "Teacher deleted");
                updateTeacherTableView();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}