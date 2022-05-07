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

    public void updateCitizenTemplate(Object o, String categoryName, String categoryExplanation, String color, int citizenTemplateId) {
        manager.updateCitizenTemplate(o, categoryName, categoryExplanation,color, citizenTemplateId);
    }
}
