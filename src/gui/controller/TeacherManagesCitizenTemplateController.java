package gui.controller;

import be.CitizenTemplate;
import gui.model.CitizenModel;
import gui.model.CitizenTemplateModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherManagesCitizenTemplateController implements Initializable {


    @FXML
    private TableColumn<CitizenTemplate, Integer> citizenTemplateIDColumn;
    @FXML
    private TableColumn<CitizenTemplate, Integer> citizenTemplateSchoolColumn;
    @FXML
    private TableView<CitizenTemplate> citizenTemplateTV;
    @FXML
    private Button createBtn;

    ObservableList listOfCitizenTemplates;

    CitizenTemplateModel citizenTemplateModel;

    CitizenModel citizenModel;

    CitizenTemplate citizenTemplate;

    int schoolId1;


    public TeacherManagesCitizenTemplateController() {
        citizenTemplateModel = new CitizenTemplateModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        citizenTemplateModel = new CitizenTemplateModel();
        citizenModel = new CitizenModel();
        updateCitizenTemplateTV();

    }

    public void updateCitizenTemplateTV() {
        citizenTemplateIDColumn.setCellValueFactory(new PropertyValueFactory<>("citizenTemplateId"));
        citizenTemplateSchoolColumn.setCellValueFactory(new PropertyValueFactory<>("schoolId"));
        try {
            citizenTemplateTV.setItems(citizenTemplateModel.getAllCitizenTemplates());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onClickCreate(ActionEvent actionEvent) {
        Stage currentStage = (Stage) createBtn.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        citizenTemplate =  citizenTemplateModel.createCitizenTemplate(schoolId1);
        int citizenTemplateID = citizenTemplate.getCitizenTemplateId();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/createCitizenTemplateView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setUserData(citizenTemplateID);
            stage.show();
            //scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickEdit(ActionEvent actionEvent) {
        int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/editCitizenTemplateView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            //stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setUserData(citizenTemplateId);
            stage.show();
            //scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickDelete(ActionEvent actionEvent) {
        JFrame jFrame = new JFrame();
        int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
        citizenTemplateModel.deleteCitizenTemplate(citizenTemplateId);
        JOptionPane.showMessageDialog(jFrame, "Citizen Template DELETED !!");
        updateCitizenTemplateTV();
    }


    public void onClickCopy(ActionEvent actionEvent) {
        Stage currentStage = (Stage) createBtn.getScene().getWindow();
        schoolId1 = (Integer) currentStage.getUserData();
        JFrame jFrame = new JFrame();
        int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
        citizenTemplateModel.copyCitizenTemplate(citizenTemplateId, schoolId1);
        JOptionPane.showMessageDialog(jFrame, "Citizen Template COPIED !!");
        updateCitizenTemplateTV();
    }

    public void onClickCreateCitizen(ActionEvent actionEvent) {
        JFrame jFrame = new JFrame();
        int citizenTemplateId = citizenTemplateTV.getSelectionModel().getSelectedItem().getCitizenTemplateId();
        citizenModel.createCitizenFromTemplate(citizenTemplateId);
        JOptionPane.showMessageDialog(jFrame, "Citizen CREATED !!");
    }
}


