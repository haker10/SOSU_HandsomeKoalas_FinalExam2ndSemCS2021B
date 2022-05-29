package gui.controller;

import be.School;
import be.User;
import gui.model.UserModel;
import gui.view.util.PopUp;
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
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminManagesAdminsController implements Initializable {

    @FXML
    private TextField filterTxt;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private Label schoolLbl;

    @FXML
    public ChoiceBox<School> schoolChoiceBox;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableView<User> adminTableView;

    UserModel userModel;

    public AdminManagesAdminsController(){
        userModel = new UserModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminTableView.setEditable(true);
        updateAdminTableView();
        try {
            schoolChoiceBox.setItems(userModel.getAllSchoolsNotAssigned());
        } catch (Exception e) {
            PopUp.showError(e.getMessage());
        }
        editAdminFromTableView();
        try {
            filterAdminTableView();
        } catch (Exception e) {
            PopUp.showError(e.getMessage());
        }
    }

    public void updateSchoolComboBox() throws Exception {
        schoolChoiceBox.setItems(userModel.getAllSchoolsNotAssigned());
    }

    public void updateAdminTableView() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        try {
            adminTableView.setItems(userModel.getAllAdmins());
            filterAdminTableView();
        } catch (Exception e) {
            PopUp.showError(e.getMessage());
        }
    }

    public void createAdmin(ActionEvent actionEvent) throws Exception {
        int count;

        if(usernameTxt.getText().isEmpty() || nameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty() || schoolChoiceBox.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill in all the fields");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
            filterAdminTableView();
        }
        else {
            try {
                count = 0;
                List<User> allUsers = userModel.getAllUsernames();
                for (int i=0; i< allUsers.size();i++) {
                    if (allUsers.get(i).getUsername().equals(usernameTxt.getText())) {
                        Alert alert = new Alert(Alert.AlertType.NONE);
                        alert.setTitle("Error");
                        alert.setHeaderText("Username already exists, please choose a new one");
                        alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                        alert.getDialogPane().getStyleClass().add("myDialog");
                        ButtonType okButton = new ButtonType("OK");
                        alert.getButtonTypes().setAll(okButton);
                        alert.showAndWait();
                        filterAdminTableView();
                        count++;
                    }
                }
                if(count == 0) {
                    int schoolId = schoolChoiceBox.getValue().getSchoolID();
                    userModel.createAdmin(schoolId, nameTxt.getText(), usernameTxt.getText(), passwordTxt.getText());
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("Process confirmation");
                    alert.setHeaderText("Admin created");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                    alert.getDialogPane().getStyleClass().add("myDialog");
                    ButtonType okButton = new ButtonType("OK");
                    alert.getButtonTypes().setAll(okButton);
                    alert.showAndWait();
                    nameTxt.clear();
                    usernameTxt.clear();
                    passwordTxt.clear();
                    schoolChoiceBox.setValue(null);
                    schoolChoiceBox.setItems(userModel.getAllSchoolsNotAssigned());
                    updateAdminTableView();
                    filterAdminTableView();
                }
            } catch (Exception e) {
                PopUp.showError(e.getMessage());
            }
        }
    }

    public void filterAdminTableView() throws Exception {

        ObservableList<User> userList = userModel.getAllAdmins();
        FilteredList<User> filteredData = null;
        try {
            filteredData = new FilteredList<>(userList, b -> true);
        } catch (Exception e) {
            PopUp.showError(e.getMessage());
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

        sortedData.comparatorProperty().bind(adminTableView.comparatorProperty());

        adminTableView.setItems(sortedData);
    }

    private void editAdminFromTableView() {
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setName(t.getNewValue());
                        TablePosition pos = adminTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = adminTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        try {
                            userModel.editUser(userId, name, username, password);
                            filterAdminTableView();
                        } catch (Exception e) {
                            PopUp.showError(e.getMessage());
                        }

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
                        TablePosition pos = adminTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = adminTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        try {
                            userModel.editUser(userId, name, username, password);
                            filterAdminTableView();
                        } catch (Exception e) {
                            PopUp.showError(e.getMessage());
                        }

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
                        TablePosition pos = adminTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = adminTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        try {
                            userModel.editUser(userId, name, username, password);
                            filterAdminTableView();
                        } catch (Exception e) {
                            PopUp.showError(e.getMessage());
                        }

                    }
                }
        );
    }

    public void clickedOnTableView(MouseEvent mouseEvent) throws Exception {
        User user = adminTableView.getSelectionModel().getSelectedItem();
        int schoolId = user.getSchool();
        schoolLbl.setText(userModel.getSchoolName(schoolId));
    }

    public void onClickDelete(ActionEvent actionEvent) {
        try {
            if (adminTableView.getSelectionModel().getSelectedItem() == null){
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Error");
                alert.setHeaderText("Choose an Admin! Please try again");
                alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                alert.getDialogPane().getStyleClass().add("myDialog");
                ButtonType okButton = new ButtonType("OK");
                alert.getButtonTypes().setAll(okButton);
                alert.showAndWait();
                filterAdminTableView();
            }
            else {
                userModel.deleteUser(adminTableView.getSelectionModel().getSelectedItem().getUserId());
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Process confirmation");
                alert.setHeaderText("Admin deleted");
                alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                alert.getDialogPane().getStyleClass().add("myDialog");
                ButtonType okButton = new ButtonType("OK");
                alert.getButtonTypes().setAll(okButton);
                alert.showAndWait();
                updateAdminTableView();
                filterAdminTableView();
            }
        } catch (Exception e){
            PopUp.showError(e.getMessage());
        }
    }
}
