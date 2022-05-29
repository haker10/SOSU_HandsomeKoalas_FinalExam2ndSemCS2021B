package gui.model;

import be.School;
import be.User;
import bll.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class UserModel {

    static Manager manager;

    //constructor
    public UserModel() {
        manager = new Manager();
    }



    //users
    public User login(String username, String password) throws Exception {
        return manager.login(username, password);
    }

    public void deleteUser(int userId) throws Exception {
        manager.deleteUser(userId);
    }

    public void editUser(int userId, String name, String username, String password) throws Exception {
        manager.editUser(userId, name, username, password);
    }

    public List<User> getAllUsernames() throws Exception {
        return manager.getAllUsernames();
    }



    //schools
    public void createNewSchool(String school) throws Exception {
        manager.createNewSchool(school);
    }

    public ObservableList<School> getAllSchools() throws Exception {
        ObservableList<School> allSchools = FXCollections.observableArrayList();
        allSchools.addAll(manager.getAllSchools());
        return allSchools;
    }

    public String getSchoolName(int schoolId1) throws Exception {
        return manager.getSchoolName(schoolId1);
    }

    public ObservableList<School> getAllSchoolsNotAssigned() throws Exception {
        ObservableList<School> allSchoolsNotAssigned = FXCollections.observableArrayList();
        allSchoolsNotAssigned.addAll(manager.getAllSchoolsNotAssigned());
        return allSchoolsNotAssigned;
    }



    //admins
    public void createAdmin(int schoolId, String name, String username, String password) throws Exception {
        manager.createAdmin(schoolId, name, username, password);
    }

    public ObservableList<User> getAllAdmins() throws Exception {
        ObservableList<User> allAdmins = FXCollections.observableArrayList();
        allAdmins.addAll(manager.getAllAdmins());
        return allAdmins;
    }



    //teachers
    public void createTeacher(Integer school, String name, String username, String password) throws Exception {
        manager.createTeacher(school, name, username, password);
    }

    public ObservableList<User> getAllTeachers(int schoolId) throws Exception {
        ObservableList<User> allTeachers = FXCollections.observableArrayList();
        allTeachers.addAll(manager.getAllTeachers(schoolId));
        return allTeachers;
    }



    //students
    public void createStudent(int schoolId, String name, String username, String password) throws Exception {
        manager.createStudent(schoolId, name, username, password);
    }

    public ObservableList<User> getAllStudents(int schoolId) throws Exception {
        ObservableList<User> allStudents = FXCollections.observableArrayList();
        allStudents.addAll(manager.getAllStudents(schoolId));
        return allStudents;
    }

}
