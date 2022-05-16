package gui.model;

import be.Citizen;
import be.FunctionalAbilitie;
import be.HealthCondition;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class CitizenModel {

    Manager manager;

    private ObservableList<Citizen> allCitizen;
    ArrayList<Integer> getAllCitizenID1;


    public CitizenModel() {
        manager = new Manager();
    }

    public void createCitizenFromTemplate(int citizenTemplateId, String citizenName, int schoolId) {
        manager.createCitizenFromTemplate(citizenTemplateId, citizenName, schoolId);
    }

    public ObservableList<Citizen> getAllCitizen() {
        allCitizen = FXCollections.observableArrayList();
        allCitizen.addAll(manager.getAllCitizen());
        return allCitizen;
    }

    public ArrayList<Integer> getALlCitizenId(int studentId) {
        getAllCitizenID1 = manager.getAllCitizenId(studentId);
        return getAllCitizenID1;
    }


    public Citizen getNeededCitizen(int citizenId) {
        return manager.getNeededCitizen(citizenId);

    }


    public String getGeneralInfoCitizen(int citizenId, String generalInfoCitizenName) {
        return manager.getGeneralInfoCitizen(citizenId, generalInfoCitizenName);
    }

    public Object getHealthConditionCitizen(String category, String subCategory, int citizenId) {
        return manager.getHealthConditionCitizen(category, subCategory, citizenId);
    }

    public void updateHealthConditionsCitizen(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenId) {
        manager.updateHealthConditionsCitizen(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenId);
    }

    public Object getFunctionalInformationCitizen(String category, String subCategory, int citizenId) {
        return manager.getFunctionalInformationCitizen(category, subCategory, citizenId);
    }

    public void updateFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) {
        manager.updateFunctionalAbilitiesCitizen(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
    }

    public void updateGeneralInfoCitizen(String generalInfoName, String generalInfoEditable, int citizenId) {
        manager.updateGeneralInfoCitizen(generalInfoName, generalInfoEditable, citizenId);
    }

    public ObservableList<FunctionalAbilitie> getALlFunctionalAbilities(int citizenId) {
        return manager.getAllFunctionalAbilities(citizenId);
    }

    public ObservableList<HealthCondition> getAllHealthCondition(int citizenId) {
        return manager.getAllHealthCondition(citizenId);
    }

    public void createFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) {
        manager.createFunctionalAbilitiesCitizen(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
    }
}
