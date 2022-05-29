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


    public CitizenTemplate createCitizenTemplate(int schoolId1, String citizenTemplateName) throws Exception {
       return manager.createCitizenTemplate(schoolId1, citizenTemplateName);
    }

    public void createFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) throws Exception {
        manager.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public void createHealthConditionsCitizenTemplate(String selectedCategory, String selectedSubCategory, String selectedRelevance, String professionalNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws Exception {
        manager.createHealthConditionsCitizenTemplate(selectedCategory, selectedSubCategory, selectedRelevance, professionalNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public ObservableList<CitizenTemplate> getAllCitizenTemplates(int schoolId) throws Exception {
        ObservableList<CitizenTemplate> allCitizenTemplates = FXCollections.observableArrayList();
        allCitizenTemplates.addAll(manager.getAllCitizenTemplates(schoolId));
        return allCitizenTemplates;
    }

   public String getGeneralInfoCitizenTemplate(int citizenTemplateId, String generalInfoCitizenTemplateName) throws Exception {
       return manager.getGeneralInfoCitizenTemplate(citizenTemplateId, generalInfoCitizenTemplateName);
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoEditable, int citizenTemplateId) throws Exception {
        manager.updateGeneralInfoCitizenTemplate(generalInfoName, generalInfoEditable, citizenTemplateId);
    }

    public List<String> getFunctionalInformationCitizenTemplate(String category, String subCategory, int citizenTemplateId) throws Exception {
        return manager.getFunctionalInformationCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) throws Exception {
        manager.updateFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance,wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public List<String> getHealthConditionCitizenTemplate(String category, String subCategory, int citizenTemplateId) throws Exception {
        return manager.getHealthConditionCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateHealthConditionsCitizenTemplate(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws Exception {
        manager.updateHealthConditionsCitizenTemplate(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public void deleteCitizenTemplate(int citizenTemplateId) throws Exception {
        manager.deleteCitizenTemplate(citizenTemplateId);
    }

    public void copyCitizenTemplate(int citizenTemplateId, int schoolID, String citizenTemplateName) throws Exception {
        manager.copyCitizenTemplate(citizenTemplateId, schoolID, citizenTemplateName);
    }

    public ObservableList<HealthConditionCT> getAllHealthConditionTemplate(int citizenTemplateID) throws Exception {
        return manager.getAllHealthConditionTemplate(citizenTemplateID);
    }

    public ObservableList<FunctionalAbilitieCT> getALlFunctionalAbilitiesTemplate(int citizenTemplateID) throws Exception {
        return manager.getAllFunctionalAbilitiesTemplate(citizenTemplateID);
    }

    public boolean checkHealthConditionsTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) throws Exception {
        return manager.checkHealthConditionsTemplateId(selectedCategory, selectedSubCategory, citizenTemplateID);
    }

    public boolean checkFunctionalAbilitiesTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) throws Exception {
        return manager.checkFunctionalAbilitiesTemplateId(selectedCategory, selectedSubCategory, citizenTemplateID);
    }

    public String getCitizenTemplateName(int citizenTemplateID) throws Exception {
        return manager.getCitizenTemplateName(citizenTemplateID);
    }

    public List<CitizenTemplate> getAllCitizenTemplateNames() throws Exception {
        return manager.getAllCitizenTemplateNames();
    }
}
