package gui.model;

import be.CitizenTemplate;
import bll.Manager;

public class CitizenTemplateModel {
    Manager manager;

    public CitizenTemplateModel(){
        manager = new Manager();
    }


    public CitizenTemplate createCitizenTemplate(int schoolId1) {
       return manager.createCitizenTemplate(schoolId1);
    }

    public void updateCitizenTemplate(String categoryName, String categoryExplanation, String color, int citizenTemplateId) {
        manager.updateCitizenTemplate(categoryName, categoryExplanation,color, citizenTemplateId);
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) {
        manager.updateGeneralInfoCitizenTemplate(generalInfoName, generalInfoExplanation, generalInfoEditable, citizenTemplateId);
    }

    public void updateFunctionalAbitiliesCitizenTemplate(String functionalAbilitesName, String functionalAbilitesInfo, Integer functionalAbilitesScore, int citizenTemplateId) {
        manager.updateFunctionalAbilitiesCitizenTemplate(functionalAbilitesName, functionalAbilitesInfo, functionalAbilitesScore, citizenTemplateId);
    }
}
