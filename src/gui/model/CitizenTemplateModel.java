package gui.model;

import be.CitizenTemplate;
import be.FunctionalAbilitieCT;
import be.HealthConditionCT;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class CitizenTemplateModel {

    Manager manager;

    public CitizenTemplateModel(){
        manager = new Manager();
    }


    public CitizenTemplate createCitizenTemplate(int schoolId1, String citizenTemplateName) {
       return manager.createCitizenTemplate(schoolId1, citizenTemplateName);
    }

    public void createGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) {
        manager.createGeneralInfoCitizenTemplate(generalInfoName, generalInfoExplanation, generalInfoEditable, citizenTemplateId);
    }

    public void createFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) {
        manager.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public void createHealthConditionsCitizenTemplate(String selectedCategory, String selectedSubCategory, String selectedRelevance, String professionalNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) {
        manager.createHealthConditionsCitizenTemplate(selectedCategory, selectedSubCategory, selectedRelevance, professionalNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public ObservableList<CitizenTemplate> getAllCitizenTemplates(int schoolId) {
        ObservableList<CitizenTemplate> allCitizenTemplates = FXCollections.observableArrayList();
        allCitizenTemplates.addAll(manager.getAllCitizenTemplates(schoolId));
        return allCitizenTemplates;
    }

   public String getGeneralInfoCitizenTemplate(int citizenTemplateId, String generalInfoCitizenTemplateName) {
       return manager.getGeneralInfoCitizenTemplate(citizenTemplateId, generalInfoCitizenTemplateName);
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoEditable, int citizenTemplateId) {
        manager.updateGeneralInfoCitizenTemplate(generalInfoName, generalInfoEditable, citizenTemplateId);
    }

    public List<String> getFunctionalInformationCitizenTemplate(String category, String subCategory, int citizenTemplateId) {
        return manager.getFunctionalInformationCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) {
        manager.updateFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance,wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public List<String> getHealthConditionCitizenTemplate(String category, String subCategory, int citizenTemplateId) {
        return manager.getHealthConditionCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateHealthConditionsCitizenTemplate(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId){
        manager.updateHealthConditionsCitizenTemplate(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public void deleteCitizenTemplate(int citizenTemplateId) {
        manager.deleteCitizenTemplate(citizenTemplateId);
    }

    public void copyCitizenTemplate(int citizenTemplateId, int schoolID, String citizenTemplateName) {
        manager.copyCitizenTemplate(citizenTemplateId, schoolID, citizenTemplateName);
    }

    public boolean checkHealtConditionsId(String selectedCategory, String selectedSubCategory, int citizenTemplateId) {
        return manager.checkHealthConditionsCTId(selectedCategory, selectedSubCategory, citizenTemplateId);
    }

    public boolean checkFunctionalAbilitiesId(String selectedCategory, String selectedSubCategory, int citizenTemplateId) {
        return manager.checkFunctionalAbilitiesCTId(selectedCategory, selectedSubCategory, citizenTemplateId);
    }

    public ObservableList<HealthConditionCT> getAllHealthConditionTemplate(int citizenTemplateID) {
        return manager.getAllHealthConditionTemplate(citizenTemplateID);
    }

    public ObservableList<FunctionalAbilitieCT> getALlFunctionalAbilitiesTemplate(int citizenTemplateID) {
        return manager.getAllFunctionalAbilitiesTemplate(citizenTemplateID);
    }

    public boolean checkHealthConditionsTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) {
        return manager.checkHealthConditionsTemplateId(selectedCategory, selectedSubCategory, citizenTemplateID);
    }

    public boolean checkFunctionalAbilitiesTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) {
        return manager.checkFunctionalAbilitiesTemplateId(selectedCategory, selectedSubCategory, citizenTemplateID);
    }

    public String getCitizenTemplateName(int citizenTemplateID) {
        return manager.getCitizenTemplateName(citizenTemplateID);
    }

    public List<CitizenTemplate> getAllCitizenTemplateNames() {
        return manager.getAllCitizenTemplateNames();
    }
}
