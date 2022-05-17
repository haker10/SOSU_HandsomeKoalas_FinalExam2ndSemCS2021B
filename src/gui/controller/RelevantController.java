package gui.controller;

import gui.model.CitizenTemplateModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RelevantController implements Initializable {

    @FXML
    private Label categoryLbl;
    @FXML
    private TextArea professionalNoteTxt;
    @FXML
    private Label subCategoryLbl;

    CitizenTemplateModel citizenTemplateModel;

    public RelevantController(){
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
    }

    public void OnClickSave(ActionEvent event) {
        Stage currentStage = (Stage) categoryLbl.getScene().getWindow();
        String informationReceived = (String) currentStage.getUserData();
        String[] information = informationReceived.split(",");
        String category = information[0];
        String subCategory = information[1];
        String relevance = information[2];
        String assessmentNote = "";
        String expectedLevel = "";
        String observableNote = "";
        LocalDate date = LocalDate.now();
        int citizenTemplateID = Integer.parseInt(information[3]);

        JFrame frame = new JFrame();

        if(professionalNoteTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Please enter a professional note");
        }
        else {
            String professionalNote = professionalNoteTxt.getText();
            citizenTemplateModel.createHealthConditionsCitizenTemplate(category, subCategory, relevance, professionalNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateID);
            JOptionPane.showMessageDialog(frame, "Saved");
            currentStage.close();
        }
    }

}
