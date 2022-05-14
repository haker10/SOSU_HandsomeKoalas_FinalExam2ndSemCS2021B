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
    private ObservableList<User> allTeachers;
    private ObservableList<School> allSchoolsNotAssigned;

    //constructor
    public UserModel() {
        manager = new Manager();
    }


    public User login(String username, String password) {
        return manager.login(username, password);
    }


    public ObservableList getAllTeachers(int schoolId) {
        allTeachers = FXCollections.observableArrayList();
        allTeachers.addAll(manager.getAllTeachers(schoolId));
        return allTeachers;
    }


    public void createTeacher(Integer school, String name, String username, String password) {
        manager.createTeacher(school, name, username, password);
    }

    public void deleteUser(int userId) {
        manager.deleteUser(userId);
    }

    public void editUser(int userId, String name, String username, String password) {
        manager.editUser(userId, name, username, password);
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

    public ObservableList<User> getAllStudents(int schoolId) {
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(manager.getAllStudents(schoolId));
        return allStudents;
    }
    public void createStudent(int schoolId, String name, String username, String password) {
        manager.createStudent(schoolId, name, username, password);
    }

    public String getSchoolName(int schoolId1) {
        return manager.getSchoolName(schoolId1);
    }

    public ObservableList<School> getAllSchoolsNotAssigned() {
        allSchoolsNotAssigned = FXCollections.observableArrayList();
        allSchoolsNotAssigned.addAll(manager.getAllSchoolsNotAssigned());
        return allSchoolsNotAssigned;
    }
}
