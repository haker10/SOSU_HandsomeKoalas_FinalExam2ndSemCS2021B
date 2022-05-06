package bll;

import be.User;
import dal.dao.UserDataDAO;

public class Manager {

    UserDataDAO userDataDAO;

    //constructor
    public Manager() {
        userDataDAO = new UserDataDAO();

    }

    public User login(String username, String password) {
        return userDataDAO.login(username, password);

    }
<<<<<<< Updated upstream
=======

    public List<School> getAllSchools() {
        return schoolDAO.getAllSchools();
    }

    public School createNewSchool(String school) {
        return schoolDAO.createNewSchool(school);
    }

    public List<User> getAllAdmins() {
        return userDataDAO.getAllAdmins();
    }

    public User createAdmin(int schoolId, String name, String username, String password) {
        return userDataDAO.createAdmin(schoolId, name, username, password);
    }

    public List<User> getAllStudents() {
        return userDataDAO.getAllStudents();
    }

    public User createStudent(int schoolId, String name, String username, String password) {
        return userDataDAO.createStudent(schoolId, name, username, password);
    }

    public int deleteStudent(int chosenStudentId) {
        try{
            UserDataDAO.deleteStudent(chosenStudentId);
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void editStudent(String name) {
        UserDataDAO.editStudent(name);
    }
>>>>>>> Stashed changes
}


