package gui.model;

import be.User;
import bll.Manager;

public class UserModel {

    static Manager manager;

<<<<<<< Updated upstream
=======
    private ObservableList<School> allSchools;
    private ObservableList<User> allAdmins;
    private ObservableList<User> allStudents;

>>>>>>> Stashed changes
    //constructor
    public UserModel() {
        manager = new Manager();
    }




    public User login(String username, String password) {
        return manager.login(username, password);
    }
<<<<<<< Updated upstream
=======

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
    public static int deleteStudent(int chosenStudentId) {
        manager.deleteStudent(chosenStudentId);
        return 0;
    }

    public User editStudent(String name) {
        manager.editStudent(name);
        return null;
    }
>>>>>>> Stashed changes
}
