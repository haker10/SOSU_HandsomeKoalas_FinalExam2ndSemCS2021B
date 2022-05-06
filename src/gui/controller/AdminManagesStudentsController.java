package gui.controller;

import be.User;
import gui.model.UserModel;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.*;
import javafx.event.EventHandler;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.RowId;
import java.util.ResourceBundle;


public class AdminManagesStudentsController implements Initializable {


    UserModel userModel;
    @FXML
    private TableColumn<User, Integer> schoolColumn;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TableView<User> studentTableView;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TextField usernameTxt;

    int schoolId1;

    public AdminManagesStudentsController() {
        userModel = new UserModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentTableView.setEditable(true);
        editStudentFromTableView();
        updateStudentTableView();
    }

    public void editStudentFromTableView(){
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        ((User) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                        TablePosition pos = studentTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = studentTableView.getSelectionModel().getSelectedItem().getUserId();
                        int school = schoolColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String name = nameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        userModel.editStudent(userId, school, name, username);
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
                        TablePosition pos = studentTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = studentTableView.getSelectionModel().getSelectedItem().getUserId();
                        int school = schoolColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String name = nameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        userModel.editStudent(userId, school, name, username);
                    }
                }
        );

        schoolColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        schoolColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, Integer> t) {
                        ((User) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSchool(t.getNewValue());
                        TablePosition pos = studentTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = studentTableView.getSelectionModel().getSelectedItem().getUserId();
                        int school = schoolColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String name = nameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        userModel.editStudent(userId, school, name, username);
                    }
                }
        );
    }

    public void updateStudentTableView() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        schoolColumn.setCellValueFactory(new PropertyValueFactory<>("school"));
        try {
            studentTableView.setItems(userModel.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onClickCreate(ActionEvent actionEvent) {
        JFrame jFrame = new JFrame();
        Stage currentStage = (Stage) nameTxt.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        int schoolId = schoolId1;
        try {
            userModel.createStudent(schoolId, nameTxt.getText(), usernameTxt.getText(), passwordTxt.getText());
            nameTxt.clear();
            usernameTxt.clear();
            passwordTxt.clear();
            JOptionPane.showMessageDialog(jFrame, "USER CREATED !!");
            updateStudentTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickDelete(ActionEvent actionEvent) {
          JFrame jFrame = new JFrame();
        try{
            if (studentTableView.getSelectionModel() == null){
                JOptionPane.showMessageDialog(jFrame, "FIELD IS EMPTY !!\nPLEASE TRY AGAIN!!");
            }
            else {
                userModel.deleteStudent(studentTableView.getSelectionModel().getSelectedItem().getUserId());
                JOptionPane.showMessageDialog(jFrame, "USER DELETED !!");
                updateStudentTableView();
            }
            }catch (Exception e){
              e.printStackTrace();
    }
  }
}