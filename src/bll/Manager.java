package bll;

import be.School;
import be.User;
import dal.dao.SchoolClassDAO;
import dal.dao.SchoolDAO;
import dal.dao.UserDataDAO;

import java.util.List;

public class Manager {

    UserDataDAO userDataDAO;
    SchoolDAO schoolDAO;

    //constructor
    public Manager(){
        userDataDAO = new UserDataDAO();
        schoolDAO = new SchoolDAO();
    }

    public User login(String username, String password) {
       return userDataDAO.login(username, password);

    }

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
}
