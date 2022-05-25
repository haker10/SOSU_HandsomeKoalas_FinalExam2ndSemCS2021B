package gui.controller;

import be.CitizenTemplate;
import be.User;
import gui.model.CitizenModel;
import gui.model.CitizenTemplateModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherManagesCitizenTemplateController implements Initializable {

    @FXML
    private TextField citizenTemplateNameTxt;

    @FXML
    private TableColumn<CitizenTemplate, String> citizenTemplateNameColumn;

    @FXML
    private TableView<CitizenTemplate> citizenTemplateTV;

    @FXML
    private Button createBtn;

    CitizenTemplateModel citizenTemplateModel;

    CitizenModel citizenModel;

    CitizenTemplate citizenTemplate;

    int schoolId1;

    public TeacherManagesCitizenTemplateController() {
        citizenTemplateModel = new CitizenTemplateModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) createBtn.getScene().getWindow();
            schoolId1 = (Integer) currentStage.getUserData();
            citizenTemplateModel = new CitizenTemplateModel();
            citizenModel = new CitizenModel();
            updateCitizenTemplateTV();
        });
    }

    public void updateCitizenTemplateTV() {
        citizenTemplateNameColumn.setCellValueFactory(new PropertyValueFactory<>("citizenTemplateName"));
        try {
            citizenTemplateTV.setItems(citizenTemplateModel.getAllCitizenTemplates(schoolId1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //might change this to only create in database and don't open create window, just edit to "create"
    public void onClickCreate(ActionEvent actionEvent) {
        //JFrame jFrame = new JFrame();
        int count = 0;
        Stage currentStage = (Stage) createBtn.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        if (citizenTemplateNameTxt.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(jFrame, "Please enter a name for the citizen template");
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter a name for the citizen template");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
        } else {
            try {
                count = 0;
                List<CitizenTemplate> allCitizenTemplateNames = citizenTemplateModel.getAllCitizenTemplateNames();
                for (int i = 0; i < allCitizenTemplateNames.size(); i++) {
                    if (allCitizenTemplateNames.get(i).getCitizenTemplateName().equals(citizenTemplateNameTxt.getText())) {
                        //JOptionPane.showMessageDialog(jFrame, "Username already exists, please choose a new one");
                        Alert alert = new Alert(Alert.AlertType.NONE);
                        alert.setTitle("Error");
                        alert.setHeaderText("CitizenTemplate with this name already exists, please choose a new one");
                        alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                        alert.getDialogPane().getStyleClass().add("myDialog");
                        ButtonType okButton = new ButtonType("OK");
                        alert.getButtonTypes().setAll(okButton);
                        alert.showAndWait();
                        count++;
                    }
                }
                if (count == 0) {
                    citizenTemplate = citizenTemplateModel.createCitizenTemplate(schoolId1, citizenTemplateNameTxt.getText());
                    //JOptionPane.showMessageDialog(jFrame, "Citizen Template created");
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("Process confirmation");
                    alert.setHeaderText("Citizen Template created");
                    alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
                    alert.getDialogPane().getStyleClass().add("myDialog");
                    ButtonType okButton = new ButtonType("OK");
                    alert.getButtonTypes().setAll(okButton);
                    alert.showAndWait();
                    updateCitizenTemplateTV();
                    int citizenTemplateID = citizenTemplate.getCitizenTemplateId();
                    try{
                        Parent root = FXMLLoader.load(getClass().getResource("/gui/view/teacherEditCitizenTemplateView.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(scene);
                        stage.setUserData(citizenTemplateID);
                        stage.show();
                        scene.setFill(Color.TRANSPARENT);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickEdit(ActionEvent actionEvent) {
        int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/teacherEditCitizenTemplateView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setUserData(citizenTemplateId);
            stage.show();
            scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickDelete(ActionEvent actionEvent) {
        //JFrame jFrame = new JFrame();
        if(citizenTemplateTV.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Please choose a CitizenTemplate");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
        }
        else {
            int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
            citizenTemplateModel.deleteCitizenTemplate(citizenTemplateId);
            //JOptionPane.showMessageDialog(jFrame, "Citizen Template DELETED !!");
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Process confirmation");
            alert.setHeaderText("Citizen Template DELETED !!");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
            updateCitizenTemplateTV();
        }
    }


    public void onClickCopy(ActionEvent actionEvent) {
        if(citizenTemplateTV.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Please choose a CitizenTemplate");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
        }
        else {
            Stage currentStage = (Stage) createBtn.getScene().getWindow();
            schoolId1 = (Integer) currentStage.getUserData();
            //JFrame jFrame = new JFrame();
            int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
            String citizenTemplateName = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateName() + "Copy";
            citizenTemplateModel.copyCitizenTemplate(citizenTemplateId, schoolId1, citizenTemplateName);
            //JOptionPane.showMessageDialog(jFrame, "Citizen Template COPIED !!");
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Process confirmation");
            alert.setHeaderText("Citizen Template COPIED !!");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
            updateCitizenTemplateTV();
        }
    }

    public void onClickCreateCitizen(ActionEvent actionEvent) {
        if(citizenTemplateTV.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Please choose a CitizenTemplate");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
        }
        else {
            //JFrame jFrame = new JFrame();
            int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
            String citizenTemplateName = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateName();
            citizenModel.createCitizenFromTemplate(citizenTemplateId, citizenTemplateName, schoolId1);
            //JOptionPane.showMessageDialog(jFrame, "Citizen CREATED !!");
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Process confirmation");
            alert.setHeaderText("Citizen CREATED !!");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/gui/view/css/myDialogs.css").toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialog");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);
            alert.showAndWait();
        }
    }

}


