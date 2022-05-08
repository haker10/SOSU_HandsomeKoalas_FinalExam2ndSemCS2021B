package gui.model;

import be.CitizenTemplate;
import bll.Manager;

import java.time.LocalDate;

public class CitizenTemplateModel {
    Manager manager;

    public CitizenTemplateModel(){
        manager = new Manager();
    }


    public CitizenTemplate createCitizenTemplate(int schoolId1) {
       return manager.createCitizenTemplate(schoolId1);
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) {
        manager.updateGeneralInfoCitizenTemplate(generalInfoName, generalInfoExplanation, generalInfoEditable, citizenTemplateId);
    }


    public void createFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) {
        manager.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
    }
}
