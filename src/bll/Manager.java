package bll;

import be.School;
import be.User;
import dal.dao.SchoolDAO;
import dal.dao.UserDataDAO;

import java.util.List;

public class Manager {

    SchoolDAO schoolDAO;
    UserDataDAO userDataDAO;

    //constructor
    public Manager(){
        userDataDAO = new UserDataDAO();
        schoolDAO = new SchoolDAO();

    }

    public User login(String username, String password) {
       return userDataDAO.login(username, password);

    }

    public List<User> getAllTeachers() {
        return userDataDAO.getAllTeachers();
    }

    public User createTeacher(Integer school, String name, String username, String password) {
        return userDataDAO.createTeacher(school, name, username, password);
    }

    public void deleteTeacher(int userId) {
        try {
            userDataDAO.deleteTeacher(userId);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editStudent(int userId, int school, String name, String username, String password) {
        userDataDAO.editStudent(userId, school, name, username, password);
    }

    public List<School> getAllSchools() {
        return schoolDAO.getAllSchools();
    }

    /*public List<String> getAllSchools() {
        return userDataDAO.getAllSchools();
    }*/
}
