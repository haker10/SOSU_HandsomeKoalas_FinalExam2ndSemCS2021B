package gui.model;

import be.School;
import be.User;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserModel {

    static Manager manager;

    private ObservableList<School> allSchools;
    private ObservableList<User> allAdmins;
    private ObservableList<User> allStudents;


    private ObservableList<School> allSchools;
    private ObservableList<User> allAdmins;

    //constructor
    public UserModel() {
        manager = new Manager();
    }




    public User login(String username, String password) {
        return manager.login(username, password);
    }

    public ObservableList<School> getAllSchools() {
        allSchools = FXCollections.observableArrayList();
        allSchools.addAll(manager.getAllSchools());
        return allSchools;
    }

    public void createNewSchool(String school) {
        manager.createNewSchool(school);
    }

    public ObservableList<User> getAllAdmins() {
        allAdmins = FXCollections.observableArrayList();
        allAdmins.addAll(manager.getAllAdmins());
        return allAdmins;
    }

    public void createAdmin(int schoolId, String name, String username, String password) {
        manager.createAdmin(schoolId, name, username, password);
    }




    public ObservableList<User> getAllStudents() {
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(manager.getAllStudents());
        return allStudents;
    }
    public void createStudent(int schoolId, String name, String username, String password) {
        manager.createStudent(schoolId, name, username, password);
    }
    public void deleteStudent(int chosenStudentId) { manager.deleteStudent(chosenStudentId); }



    public void editStudent(int userId, int school, String name, String username) {
        manager.editStudent(userId,school, name, username);

    }

}
