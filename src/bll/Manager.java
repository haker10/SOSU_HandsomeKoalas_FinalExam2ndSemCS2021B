package bll;

import be.Citizen;
import be.CitizenTemplate;
import be.School;
import be.User;

import dal.dao.*;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    SchoolDAO schoolDAO;
    UserDataDAO userDataDAO;
    CitizenTemplateDAO citizenTemplateDAO;
    CitizenDAO citizenDAO;
    HealthConditionsCitizenTemplateDAO healthConditionsCitizenTemplateDAO;
    GeneralInformationCitizenTemplateDAO generalInformationCitizenTemplateDAO;
    FunctionalAbilitesCitizenTemplateDAO functionalAbilitesCitizenTemplateDAO;
    HealthConditionsCitizenDAO healthConditionsCitizenDAO;
    GeneralInformationCitizenDAO generalInformationCitizenDAO;
    FunctionalAbilitiesCitizenDAO functionalAbilitiesCitizenDAO;
    StudentGetsCitizenDAO studentGetsCitizenDAO;

    //constructor
    public Manager() {
        userDataDAO = new UserDataDAO();
        schoolDAO = new SchoolDAO();
        citizenTemplateDAO = new CitizenTemplateDAO();
        citizenDAO = new CitizenDAO();
        healthConditionsCitizenTemplateDAO = new HealthConditionsCitizenTemplateDAO();
        generalInformationCitizenTemplateDAO = new GeneralInformationCitizenTemplateDAO();
        functionalAbilitesCitizenTemplateDAO = new FunctionalAbilitesCitizenTemplateDAO();
        healthConditionsCitizenDAO = new HealthConditionsCitizenDAO();
        generalInformationCitizenDAO = new GeneralInformationCitizenDAO();
        functionalAbilitiesCitizenDAO = new FunctionalAbilitiesCitizenDAO();
        studentGetsCitizenDAO = new StudentGetsCitizenDAO();
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

    public List<User> getAllAdmins() {
        return userDataDAO.getAllAdmins();
    }

    public List<User> getAllStudents() {
        return userDataDAO.getAllStudents();
    }


    public User createTeacher(Integer school, String name, String username, String password) {
        return userDataDAO.createTeacher(school, name, username, password);
    }

    public School createNewSchool(String school) {
        return schoolDAO.createNewSchool(school);
    }

    public User createAdmin(int schoolId, String name, String username, String password) {
        return userDataDAO.createAdmin(schoolId, name, username, password);
    }

    public User createStudent(int schoolId, String name, String username, String password) {
        return userDataDAO.createStudent(schoolId, name, username, password);
    }

    public void deleteTeacher(int userId) {
        try {
            userDataDAO.deleteTeacher(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int chosenStudentId) {
        try{
            userDataDAO.deleteStudent(chosenStudentId);
        } catch(Exception e){

            e.printStackTrace();
        }
    }

    public void editTeacher(int userId, int school, String name, String username, String password) {
        userDataDAO.editTeacher(userId, school, name, username, password);
    }

    public void editStudent(int userId, int school, String name, String username) {
        userDataDAO.editStudent(userId, school, name, username);
    }

    public CitizenTemplate createCitizenTemplate(int schoolId1) {
       return citizenTemplateDAO.createCitizenTemplate(schoolId1);

    }

    public void createGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) {
        generalInformationCitizenTemplateDAO.createGeneralInfoCitizenTemplate(generalInfoName, generalInfoExplanation, generalInfoEditable, citizenTemplateId);
    }

    public void createFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) {
        functionalAbilitesCitizenTemplateDAO.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public void createHealthConditionsCitizenTemplate(String selectedCategory, String selectedSubCategory, String selectedRelevance, String professionalNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) {
        healthConditionsCitizenTemplateDAO.createHealthConditionsCitizenTemplate(selectedCategory, selectedSubCategory, selectedRelevance, professionalNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public List<CitizenTemplate> getAllCitizenTemplates() {
        return citizenTemplateDAO.getALlCitizenTemplates();

    }

    public String getGeneralInfoCitizenTemplate(int citizenTemplateId, String generalInfoCitizenTemplateName) {
       return generalInformationCitizenTemplateDAO.getGeneralInfoCitizenTemplate(citizenTemplateId, generalInfoCitizenTemplateName);
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoEditable, int citizenTemplateId) {
        generalInformationCitizenTemplateDAO.updateGeneralInfoCitizenTemplate(generalInfoName, generalInfoEditable, citizenTemplateId);
    }

    public List<String> getFunctionalInformationCitizenTemplate(String category, String subCategory, int citizenTemplateId) {
        return functionalAbilitesCitizenTemplateDAO.getFunctionalInformationCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) {
        functionalAbilitesCitizenTemplateDAO.updateFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public List<String> getHealthConditionCitizenTemplate(String category, String subCategory, int citizenTemplateId) {
        return healthConditionsCitizenTemplateDAO.getHealthConditionCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateHealthConditionsCitizenTemplate(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) {
        healthConditionsCitizenTemplateDAO.updateHealthConditionsCitizenTemplate(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public void deleteCitizenTemplate(int citizenTemplateId) {
        citizenTemplateDAO.deleteCitizenTemplate(citizenTemplateId);
    }

    public void copyCitizenTemplate(int citizenTemplateId, int schoolID) {
        CitizenTemplate citizenTemplate = citizenTemplateDAO.createCitizenTemplate(schoolID);
        int citizenTemplateId2 = citizenTemplate.getCitizenTemplateId();
        healthConditionsCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
        functionalAbilitesCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
        generalInformationCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
    }

    public void createCitizenFromTemplate(int citizenTemplateId) {
        Citizen citizen = citizenDAO.createCitizenFromTemplate(citizenTemplateId);
        int citizenId = citizen.getCitizenId();
        healthConditionsCitizenDAO.copyHealthConditionsCitizen(citizenId, citizenTemplateId);
        functionalAbilitiesCitizenDAO.copyFunctionalAbilitiesCitizen(citizenId, citizenTemplateId);
        generalInformationCitizenDAO.copyGeneralInformationCitizen(citizenId, citizenTemplateId);
    }

    public List<Citizen> getAllCitizen() {
        return citizenDAO.getAllCitizen();
    }

    public void assignCitizenToStudent(int studentId, int citizenID) {
        studentGetsCitizenDAO.assignCitizenToStudent(studentId, citizenID);
    }
}


