package gui.model;

import bll.Manager;

public class CitizenModel {

    Manager manager;

    public CitizenModel() {
        manager = new Manager();
    }

    public void createCitizenFromTemplate(int citizenTemplateId) {
        manager.createCitizenFromTemplate(citizenTemplateId);
    }
}
