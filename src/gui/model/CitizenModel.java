package gui.model;

import be.Citizen;
import be.FunctionalAbilitie;
import be.HealthCondition;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitizenModel {

    Manager manager;

    ArrayList<Integer> getAllCitizenID1;


    public CitizenModel() {
        manager = new Manager();
    }

    public void createCitizenFromTemplate(int citizenTemplateId, String citizenName, int schoolId) throws Exception {
        manager.createCitizenFromTemplate(citizenTemplateId, citizenName, schoolId);
    }

    public ObservableList<Citizen> getAllCitizen() throws Exception {
        ObservableList<Citizen> allCitizen = FXCollections.observableArrayList();
        allCitizen.addAll(manager.getAllCitizen());
        return allCitizen;
    }

    public ArrayList<Integer> getALlCitizenId(int studentId) throws Exception {
        getAllCitizenID1 = manager.getAllCitizenId(studentId);
        return getAllCitizenID1;
    }

    public Citizen getNeededCitizen(int citizenId) throws Exception {
        return manager.getNeededCitizen(citizenId);

    }

    public String getGeneralInfoCitizen(int citizenId, String generalInfoCitizenName) throws Exception {
        return manager.getGeneralInfoCitizen(citizenId, generalInfoCitizenName);
    }

    public Object getHealthConditionCitizen(String category, String subCategory, int citizenId) throws Exception {
        return manager.getHealthConditionCitizen(category, subCategory, citizenId);
    }

    public List<String> getFunctionalInformationCitizen(String category, String subCategory, int citizenId) throws Exception {
        return manager.getFunctionalInformationCitizen(category, subCategory, citizenId);
    }

    public void updateHealthConditionsCitizen(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenId) throws Exception {
        manager.updateHealthConditionsCitizen(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenId);
    }

    public void updateFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) throws Exception {
        manager.updateFunctionalAbilitiesCitizen(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
    }

    public void updateGeneralInfoCitizen(String generalInfoName, String generalInfoEditable, int citizenId) throws Exception {
        manager.updateGeneralInfoCitizen(generalInfoName, generalInfoEditable, citizenId);
    }

    public ObservableList<FunctionalAbilitie> getALlFunctionalAbilities(int citizenId) throws Exception {
        return manager.getAllFunctionalAbilities(citizenId);
    }

    public ObservableList<HealthCondition> getAllHealthCondition(int citizenId) throws Exception {
        return manager.getAllHealthCondition(citizenId);
    }

    public void createFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) throws Exception {
        manager.createFunctionalAbilitiesCitizen(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
    }

    public void createHealthConditionsCitizen(String selectedCategory, String selectedSubCategory, String relevance, String professionalNote, String currentAssessment, String expectedLevel, String observationNote, LocalDate date, int citizenId) throws Exception {
        manager.createHealtConditionsCitizen(selectedCategory, selectedSubCategory, relevance, professionalNote, currentAssessment, expectedLevel, observationNote, date, citizenId);
    }

    public boolean checkFunctionalAbilitiesId(String selectedCategory, String selectedSubCategory, int citizenId) throws Exception {
        return manager.checkFunctionalAbilitiesId(selectedCategory, selectedSubCategory, citizenId);
    }

    public boolean checkHealthConditionsId(String selectedCategory, String selectedSubCategory, int citizenId) throws Exception {
        return manager.checkHealthConditionsId(selectedCategory, selectedSubCategory, citizenId);
    }

    public String getCitizenName(int citizenId) throws Exception {
        return manager.getCitizenName(citizenId);
    }
}
