package gui.controller;

import be.User;
import gui.model.UserModel;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherManagesStudentsController implements Initializable {

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TextField filterTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TableView<User> studentTableView;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    UserModel userModel;

    int schoolId1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
        Stage currentStage = (Stage) nameTxt.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        studentTableView.setEditable(true);
        editStudentFromTableView();
        updateStudentTableView();
        filterStudentTableView();
        });
    }

    public void filterStudentTableView() {

        ObservableList<User> userList = userModel.getAllStudents(schoolId1);
        FilteredList<User> filteredData = null;
        try {
            filteredData = new FilteredList<>(userList, b -> true);
        } catch (Exception e) {
            e.printStackTrace();
        }



        FilteredList<User> finalFilteredData = filteredData;
        filterTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            finalFilteredData.setPredicate(user -> {


                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getName().toLowerCase().contains(lowerCaseFilter))
                    return true;
                else
                    return false;
            });
        });


        SortedList<User> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(studentTableView.comparatorProperty());

        studentTableView.setItems(sortedData);
    }

    public TeacherManagesStudentsController(){
        userModel = new UserModel();
    }

    public void updateStudentTableView() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        try {
            studentTableView.setItems(userModel.getAllStudents(schoolId1));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                        String password = passwordColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String name = nameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
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
                        TablePosition pos = studentTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = studentTableView.getSelectionModel().getSelectedItem().getUserId();
                        String password = passwordColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String name = nameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
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
                        TablePosition pos = studentTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = studentTableView.getSelectionModel().getSelectedItem().getUserId();
                        String password = passwordColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String name = nameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((studentTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                    }
                }
        );
    }

    public void onClickCreate(ActionEvent actionEvent) {
        JFrame jFrame = new JFrame();
        Stage currentStage = (Stage) nameTxt.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        try {
            userModel.createStudent(schoolId1, nameTxt.getText(), usernameTxt.getText(), passwordTxt.getText());
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
                userModel.deleteUser(studentTableView.getSelectionModel().getSelectedItem().getUserId());
                JOptionPane.showMessageDialog(jFrame, "Student DELETED !!");
                updateStudentTableView();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
