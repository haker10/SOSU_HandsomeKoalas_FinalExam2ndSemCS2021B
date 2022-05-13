package gui.controller;

import be.School;
import be.User;
import gui.model.UserModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminManagesAdminsController implements Initializable {

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private Label schoolLbl;

    @FXML
    private ChoiceBox schoolChoiceBox;

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

    public void updateAdminTableView() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
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
            schoolChoiceBox.setItems(userModel.getAllSchoolsNotAssigned());
            updateAdminTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminTableView.setEditable(true);
        updateAdminTableView();
        schoolChoiceBox.setItems(userModel.getAllSchoolsNotAssigned());
        editAdminFromTableView();
    }

    private void editAdminFromTableView() {
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<User, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<User, String> t) {
                        ((User) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                        TablePosition pos = adminTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = adminTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
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
                        TablePosition pos = adminTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = adminTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
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
                        TablePosition pos = adminTableView.getSelectionModel().getSelectedCells().get(0);
                        int row = pos.getRow();
                        int userId = adminTableView.getSelectionModel().getSelectedItem().getUserId();
                        String name = nameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String username = usernameColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        String password = passwordColumn.getCellObservableValue(((adminTableView.getItems().get(row)))).getValue();
                        userModel.editUser(userId, name, username, password);
                    }
                }
        );
    }

    public void clickedOnTableView(MouseEvent mouseEvent) {
        User user = adminTableView.getSelectionModel().getSelectedItem();
        int schoolId = user.getSchool();
        schoolLbl.setText(userModel.getSchoolName(schoolId));
    }

    public void onClickDelete(ActionEvent actionEvent) {
        JFrame jFrame = new JFrame();
        try {

            if (adminTableView.getSelectionModel().getSelectedItem() == null){
                JOptionPane.showMessageDialog(jFrame, "Choose a Teacher!\nPlease try again");
            }
            else {
                userModel.deleteUser(((User) adminTableView.getSelectionModel().getSelectedItem()).getUserId());
                JOptionPane.showMessageDialog(jFrame, "Admin deleted");
                updateAdminTableView();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
