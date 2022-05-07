package bll;

import be.School;
import be.User;


import dal.dao.SchoolClassDAO;


import dal.dao.SchoolDAO;
import dal.dao.UserDataDAO;
import be.School;

import java.util.List;

import java.util.List;

import java.util.List;

public class Manager {

    SchoolDAO schoolDAO;


    UserDataDAO userDataDAO;
    SchoolDAO schoolDAO;

    //constructor
    public Manager() {
        userDataDAO = new UserDataDAO();
        schoolDAO = new SchoolDAO();

    }

    public User login(String username, String password) {
        return userDataDAO.login(username, password);

    }

    public List<School> getAllSchools() {
        return schoolDAO.getAllSchools();
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


    public void deleteStudent(int chosenStudentId) {
        try{
            userDataDAO.deleteStudent(chosenStudentId);
        } catch(Exception e){

            e.printStackTrace();
        }
    }


    public void editStudent(int userId, int school, String name, String username, String password) {
        userDataDAO.editStudent(userId, school, name, username, password);
    }

    public void editStudent(int userId,int school, String name, String username) { userDataDAO.editStudent(userId,school, name, username); }


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


