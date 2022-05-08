package gui.controller;

import gui.model.CitizenTemplateModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class VeryRelevantController implements Initializable {



    @FXML
    private Label categoryLbl;

    @FXML
    private TextArea currentAssessmentTxt;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> expectedLevelComboBox;

    @FXML
    private TextArea observationNoteTxt;

    @FXML
    private TextArea professionalNoteTxt;

    @FXML
    private Label subCategoryLbl;

    CitizenTemplateModel citizenTemplateModel;

    public VeryRelevantController(){
        citizenTemplateModel = new CitizenTemplateModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) categoryLbl.getScene().getWindow();
            String informationReceived = (String) currentStage.getUserData();
            String[] information = informationReceived.split(",");
            String category = information[0];
            String subCategory = information[1];
            categoryLbl.setText(category);
            subCategoryLbl.setText(subCategory);
        });
        expectedLevelComboBox.getItems().addAll("Disappeared", "Remains unchanged", "Got worse");
    }

    public void OnClickSave(ActionEvent event) {
        Stage currentStage = (Stage) categoryLbl.getScene().getWindow();
        String informationReceived = (String) currentStage.getUserData();
        String[] information = informationReceived.split(",");
        String category = information[0];
        String subCategory = information[1];
        String relevance = information[2];
        int citizenTemplateID = Integer.parseInt(information[3]);

        JFrame frame = new JFrame();

        if(expectedLevelComboBox.getSelectionModel().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Please fulfill all the fields");
        }
        else {
            String professionalNote;
            String observableNote;
            String assessmentNote;
            String expectedLevel;
            LocalDate date;

            if(professionalNoteTxt.getText().isEmpty()){
                professionalNote = "";
            }
            else{
                professionalNote = professionalNoteTxt.getText();
            }

            if(observationNoteTxt.getText().isEmpty()){
                observableNote = "";
            }
            else{
                observableNote = observationNoteTxt.getText();
            }

            if(currentAssessmentTxt.getText().isEmpty()){
                assessmentNote = "";
            }
            else{
                assessmentNote = currentAssessmentTxt.getText();
            }

            if(datePicker.getValue() == null){
                date = LocalDate.now();
            }
            else{
                date = datePicker.getValue();
            }

            expectedLevel = expectedLevelComboBox.getSelectionModel().getSelectedItem();
            citizenTemplateModel.createHealthConditionsCitizenTemplate(category, subCategory, relevance, professionalNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateID);
            JOptionPane.showMessageDialog(frame, "Saved");
            currentStage.close();
        }
    }


}