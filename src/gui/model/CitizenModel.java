package gui.model;

import be.Citizen;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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


}
