package gui.model;

import be.Citizen;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CitizenModel {

    Manager manager;

    private ObservableList<Citizen> allCitizen;


    public CitizenModel() {
        manager = new Manager();
    }

    public void createCitizenFromTemplate(int citizenTemplateId, String citizenName) {
        manager.createCitizenFromTemplate(citizenTemplateId, citizenName);
    }

    public ObservableList<Citizen> getAllCitizen() {
        allCitizen = FXCollections.observableArrayList();
        allCitizen.addAll(manager.getAllCitizen());
        return allCitizen;
    }

}
