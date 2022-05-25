package gui.controller;

import be.User;
import gui.model.UserModel;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminManagesTeachersController implements Initializable {

    @FXML
    private TextField filterTxt;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) schoolLbl.getScene().getWindow();
            schoolId1 = (int) currentStage.getUserData();
            updateTeacherTableView();
            teachersTableView.setEditable(true);
            editTeacherFromTableView();
            filterTeacherTableView();
        });
    }

    public void updateTeacherTableView(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        try {
            teachersTableView.setItems(userModel.getAllTeachers(schoolId1));
            filterTeacherTableView();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void filterTeacherTableView() {
        ObservableList<User> userList = userModel.getAllTeachers(schoolId1);
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

                if (user.getName().toLowerCase().contains(lowerCaseFilter) || user.getUsername().toLowerCase().contains(lowerCaseFilter) || user.getPassword().toLowerCase().contains(lowerCaseFilter))
                    return true;
                else
                    return false;
            });
        });

        SortedList<User> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(teachersTableView.comparatorProperty());

        teachersTableView.setItems(sortedData);
    }

    public void addTeacher(ActionEvent event) {
        //JFrame jFrame = new JFrame();
        int count = 0;
        if (newNameTxt.getText().isEmpty() || newUserNameTxt.getText().isEmpty() || newPasswordTxt.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(jFrame, "One of the fields is empty!\nPlease try again!");
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("One of the fields is empty! Please try again!");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
            filterTeacherTableView();
        } else {
            try {
                count = 0;
                List<User> allUsers = userModel.getAllUsernames();
                for (int i = 0; i < allUsers.size(); i++) {
                    if (allUsers.get(i).getUsername().equals(newUserNameTxt.getText())) {
                        //JOptionPane.showMessageDialog(jFrame, "Username already exists, please choose a new one");
                        Alert alert = new Alert(Alert.AlertType.NONE);
                        alert.setTitle("Error");
                        alert.setHeaderText("Username already exists, please choose a new one");
                        alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                        alert.getDialogPane().getStyleClass().add("myDialog");
                        ButtonType okButton = new ButtonType("OK");
                        alert.getButtonTypes().setAll(okButton);
                        alert.showAndWait();
                        filterTeacherTableView();
                        count++;
                    }
                }
                if (count == 0) {
                    userModel.createTeacher(schoolId1, newNameTxt.getText(), newUserNameTxt.getText(), newPasswordTxt.getText());
                    newNameTxt.clear();
                    newUserNameTxt.clear();
                    newPasswordTxt.clear();
                    //JOptionPane.showMessageDialog(jFrame, "Teacher created");
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("Process confirmation");
                    alert.setHeaderText("Teacher created");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                    alert.getDialogPane().getStyleClass().add("myDialog");
                    ButtonType okButton = new ButtonType("OK");
                    alert.getButtonTypes().setAll(okButton);
                    alert.showAndWait();
                    updateTeacherTableView();
                    filterTeacherTableView();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void editTeacherFromTableView() {
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setName(t.getNewValue());
                        TablePosition pos = teachersTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = teachersTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                        filterTeacherTableView();
                    }
                }
        );

        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        usernameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setUsername(t.getNewValue());
                        TablePosition pos = teachersTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = teachersTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                        filterTeacherTableView();
                    }
                }
        );

        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setPassword(t.getNewValue());
                        TablePosition pos = teachersTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = teachersTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((teachersTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                        filterTeacherTableView();
                    }
                }
        );
    }

    public void deleteTeacher(ActionEvent event) {
        //JFrame jFrame = new JFrame();
        try {
            if (teachersTableView.getSelectionModel().getSelectedItem() == null){
                //JOptionPane.showMessageDialog(jFrame, "Choose a Teacher!\nPlease try again");
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Error");
                alert.setHeaderText("Choose a Teacher! Please try again");
                alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                alert.getDialogPane().getStyleClass().add("myDialog");
                ButtonType okButton = new ButtonType("OK");
                alert.getButtonTypes().setAll(okButton);
                alert.showAndWait();
                filterTeacherTableView();
            }
            else {
                userModel.deleteUser(teachersTableView.getSelectionModel().getSelectedItem().getUserId());
                //JOptionPane.showMessageDialog(jFrame, "Teacher deleted");
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Process confirmation");
                alert.setHeaderText("Teacher deleted");
                alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                alert.getDialogPane().getStyleClass().add("myDialog");
                ButtonType okButton = new ButtonType("OK");
                alert.getButtonTypes().setAll(okButton);
                alert.showAndWait();
                updateTeacherTableView();
                filterTeacherTableView();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}