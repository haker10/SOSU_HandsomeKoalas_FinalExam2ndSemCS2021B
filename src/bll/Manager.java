package bll;

import be.User;
import dal.dao.UserDataDAO;

import java.util.List;

public class Manager {

    UserDataDAO userDataDAO;

    //constructor
    public Manager(){
        userDataDAO = new UserDataDAO();

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

    /*public List<String> getAllSchools() {
        return userDataDAO.getAllSchools();
    }*/
}
