package bll;

import be.User;
import dal.dao.UserDataDAO;

public class Manager {

    UserDataDAO userDataDAO;

    //constructor
    public Manager(){
        userDataDAO = new UserDataDAO();

    }

    public User login(String username, String password) {
       return userDataDAO.login(username, password);

    }
}
