package gui.controller;

import be.School;
import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminManagesSchoolsController implements Initializable {

    @FXML
    private TextField newSchoolTxt;

    @FXML
    private ListView<School> schoolsListView;

    UserModel userModel;
    AdminManagesAdminsController adminManagesAdminsController;

    public AdminManagesSchoolsController() {
        userModel = new UserModel();
        adminManagesAdminsController = new AdminManagesAdminsController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateSchoolsTableView();
    }

    public void updateSchoolsTableView() {
        try {
            schoolsListView.setItems(userModel.getAllSchools());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNewSchool(ActionEvent actionEvent) {
        //JFrame frame = new JFrame();
        int count = 0;
        if (newSchoolTxt.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(frame, "Please enter a school name");
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter a school name");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
        }
        else {
            try {
                count = 0;
                List<School> allSchools = userModel.getAllSchools();
                for (int i=0; i< allSchools.size();i++) {
                    if (allSchools.get(i).getSchool().equals(newSchoolTxt.getText())) {
                        //JOptionPane.showMessageDialog(frame, "School already exists, please choose a new one");
                        Alert alert = new Alert(Alert.AlertType.NONE);
                        alert.setTitle("Error");
                        alert.setHeaderText("School already exists, please choose a new one");
                        alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                        alert.getDialogPane().getStyleClass().add("myDialog");
                        ButtonType okButton = new ButtonType("OK");
                        alert.getButtonTypes().setAll(okButton);
                        alert.showAndWait();
                        count++;
                    }
                }
                if (count == 0) {
                    userModel.createNewSchool(newSchoolTxt.getText());
                    updateSchoolsTableView();
                    //JOptionPane.showMessageDialog(frame, "School created");
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("Process confirmation");
                    alert.setHeaderText("School created");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                    alert.getDialogPane().getStyleClass().add("myDialog");
                    ButtonType okButton = new ButtonType("OK");
                    alert.getButtonTypes().setAll(okButton);
                    alert.showAndWait();
                    newSchoolTxt.setText("");
                    updateSchoolsTableView();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
