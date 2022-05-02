package gui.model;

import be.User;
import bll.Manager;

public class UserModel {

    Manager manager;

    //constructor
    public UserModel() {
        manager = new Manager();
    }

    public User login(String username, String password) {
        return manager.login(username, password);
    }
}
