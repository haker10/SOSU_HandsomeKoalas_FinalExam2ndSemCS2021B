package gui.model;

import be.School;
import be.User;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserModel {

    Manager manager;

    private ObservableList<User> allTeachers;
    private ObservableList<School> allSchools;

    //constructor
    public UserModel() {
        manager = new Manager();
    }

    public User login(String username, String password) {
        return manager.login(username, password);
    }

    public ObservableList getAllTeachers() {
        allTeachers = FXCollections.observableArrayList();
        allTeachers.addAll(manager.getAllTeachers());
        return allTeachers;
    }

    public void createTeacher(Integer school, String name, String username, String password) {

        manager.createTeacher(school, name, username, password);
    }

    public void deleteTeacher(int userId) {
        manager.deleteTeacher(userId);
    }

   /* public ObservableList getAllSchools() {
        allSchools = FXCollections.observableArrayList();
        allSchools.addAll(manager.getAllSchools());
        return allSchools;
    }*/
}
