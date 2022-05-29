package bll;

import be.*;

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

    //users
    public User login(String username, String password) throws Exception {
        return userDataDAO.login(username, password);
    }

    public void editUser(int userId, String name, String username, String password) throws Exception {
        userDataDAO.editUser(userId, name, username, password);
    }

    public void deleteUser(int userId) throws Exception {
        userDataDAO.deleteUser(userId);
    }

    public List<User> getAllUsernames() throws Exception {
        return userDataDAO.getAllUsernames();
    }



    //schools
    public List<School> getAllSchools() throws Exception {
        return schoolDAO.getAllSchools();
    }

    public void createNewSchool(String school) throws Exception {
        schoolDAO.createNewSchool(school);
    }

    public String getSchoolName(int schoolId1) throws Exception {
        return schoolDAO.getSchoolName(schoolId1);
    }

    public List<School> getAllSchoolsNotAssigned() throws Exception {
        return schoolDAO.getAllSchoolsNotAssigned();
    }



    //admins
    public List<User> getAllAdmins() throws Exception {
        return userDataDAO.getAllAdmins();
    }

    public void createAdmin(int schoolId, String name, String username, String password) throws Exception {
        userDataDAO.createAdmin(schoolId, name, username, password);
    }



    //teachers
    public List<User> getAllTeachers(int schoolId) throws Exception {
        return userDataDAO.getAllTeachers(schoolId);
    }

    public void createTeacher(int school, String name, String username, String password) throws Exception {
        userDataDAO.createTeacher(school, name, username, password);
    }



    //students
    public List<User> getAllStudents(int schoolId) throws Exception {
        return userDataDAO.getAllStudents(schoolId);
    }

    public User createStudent(int schoolId, String name, String username, String password) throws Exception {
        List<CitizenTemplate> allTemplates = citizenTemplateDAO.getALlCitizenTemplates(schoolId);
        User student = null;
        if(allTemplates.size() == 0) {
            student = userDataDAO.createStudent(schoolId, name, username, password);
        }
        else {
            student = userDataDAO.createStudent(schoolId, name, username, password);
            for (CitizenTemplate citizenTemplate : allTemplates) {
                Citizen citizen = citizenDAO.createCitizenFromTemplate(citizenTemplate.getCitizenTemplateId(), citizenTemplate.getCitizenTemplateName());
                int citizenId = citizen.getCitizenId();
                healthConditionsCitizenDAO.copyHealthConditionsCitizen(citizenId, citizenTemplate.getCitizenTemplateId());
                functionalAbilitiesCitizenDAO.copyFunctionalAbilitiesCitizen(citizenId, citizenTemplate.getCitizenTemplateId());
                generalInformationCitizenDAO.copyGeneralInformationCitizen(citizenId, citizenTemplate.getCitizenTemplateId());
                assignCitizenToStudent(student.getUserId(), citizenId);
            }
        }
        return student;
        // go to all citizen template from this school, create citizen copy, add citizen to student gets citizen
    }



    //citizenTemplate
    public CitizenTemplate createCitizenTemplate(int schoolId1, String citizenTemplateName) throws Exception {
        return citizenTemplateDAO.createCitizenTemplate(schoolId1, citizenTemplateName);
    }

    public List<CitizenTemplate> getAllCitizenTemplates(int schoolId) throws Exception {
        return citizenTemplateDAO.getALlCitizenTemplates(schoolId);
    }

    public void deleteCitizenTemplate(int citizenTemplateId) throws Exception {
        citizenTemplateDAO.deleteCitizenTemplate(citizenTemplateId);
    }

    public void copyCitizenTemplate(int citizenTemplateId, int schoolID, String citizenTemplateName) throws Exception {
        CitizenTemplate citizenTemplate = citizenTemplateDAO.createCitizenTemplate(schoolID, citizenTemplateName);
        int citizenTemplateId2 = citizenTemplate.getCitizenTemplateId();
        healthConditionsCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
        functionalAbilitesCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
        generalInformationCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
    }

    public String getCitizenTemplateName(int citizenTemplateID) throws Exception {
        return citizenTemplateDAO.getCitizenTemplateName(citizenTemplateID);
    }

    public List<CitizenTemplate> getAllCitizenTemplateNames() throws Exception {
        return citizenTemplateDAO.getAllCitizenTemplateNames();
    }



    //general info citizenTemplate
    public void createGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) throws Exception {
        generalInformationCitizenTemplateDAO.createGeneralInfoCitizenTemplate(generalInfoName, generalInfoExplanation, generalInfoEditable, citizenTemplateId);
    }

    public String getGeneralInfoCitizenTemplate(int citizenTemplateId, String generalInfoCitizenTemplateName) throws Exception {
        return generalInformationCitizenTemplateDAO.getGeneralInfoCitizenTemplate(citizenTemplateId, generalInfoCitizenTemplateName);
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoEditable, int citizenTemplateId) throws Exception {
        generalInformationCitizenTemplateDAO.updateGeneralInfoCitizenTemplate(generalInfoName, generalInfoEditable, citizenTemplateId);
    }



    //functional abilities citizenTemplate
    public void createFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) throws Exception {
        functionalAbilitesCitizenTemplateDAO.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public List<String> getFunctionalInformationCitizenTemplate(String category, String subCategory, int citizenTemplateId) throws Exception {
        return functionalAbilitesCitizenTemplateDAO.getFunctionalInformationCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) throws Exception {
        functionalAbilitesCitizenTemplateDAO.updateFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
    }

    public boolean checkFunctionalAbilitiesCTId(String selectedCategory, String selectedSubCategory, int citizenTemplateId) throws Exception {
        return functionalAbilitesCitizenTemplateDAO.checkFuntionalAbilitiesCTId(selectedCategory, selectedSubCategory, citizenTemplateId);
    }

    public ObservableList<FunctionalAbilitieCT> getAllFunctionalAbilitiesTemplate(int citizenTemplateID) throws Exception {
        return functionalAbilitesCitizenTemplateDAO.getAllFunctionalAbilities(citizenTemplateID);
    }

    public boolean checkFunctionalAbilitiesTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) throws Exception {
        return functionalAbilitesCitizenTemplateDAO.checkFunctionalAbilitiesId(selectedCategory, selectedSubCategory, citizenTemplateID);
    }



    //health conditions citizenTemplate
    public void createHealthConditionsCitizenTemplate(String selectedCategory, String selectedSubCategory, String selectedRelevance, String professionalNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws Exception {
        healthConditionsCitizenTemplateDAO.createHealthConditionsCitizenTemplate(selectedCategory, selectedSubCategory, selectedRelevance, professionalNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public List<String> getHealthConditionCitizenTemplate(String category, String subCategory, int citizenTemplateId) throws Exception {
        return healthConditionsCitizenTemplateDAO.getHealthConditionCitizenTemplate(category, subCategory, citizenTemplateId);
    }

    public void updateHealthConditionsCitizenTemplate(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws Exception {
        healthConditionsCitizenTemplateDAO.updateHealthConditionsCitizenTemplate(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
    }

    public boolean checkHealthConditionsCTId(String selectedCategory, String selectedSubCategory, int citizenTemplateId) throws Exception {
        return healthConditionsCitizenTemplateDAO.checkHealthConditionsCTId(selectedCategory, selectedSubCategory, citizenTemplateId);
    }

    public ObservableList<HealthConditionCT> getAllHealthConditionTemplate(int citizenTemplateID) throws Exception {
        return healthConditionsCitizenTemplateDAO.getAllHealthCondition(citizenTemplateID);
    }

    public boolean checkHealthConditionsTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) throws Exception {
        return healthConditionsCitizenTemplateDAO.checkHealtConditionsId(selectedCategory, selectedSubCategory, citizenTemplateID);
    }



    //citizen
    public void createCitizenFromTemplate(int citizenTemplateId, String citizenName, int schoolId) throws Exception {
        List<User> allStudents = getAllStudents(schoolId);
        for (User student : allStudents) {
            Citizen citizen = citizenDAO.createCitizenFromTemplate(citizenTemplateId, citizenName);
            int citizenId = citizen.getCitizenId();
            healthConditionsCitizenDAO.copyHealthConditionsCitizen(citizenId, citizenTemplateId);
            functionalAbilitiesCitizenDAO.copyFunctionalAbilitiesCitizen(citizenId, citizenTemplateId);
            generalInformationCitizenDAO.copyGeneralInformationCitizen(citizenId, citizenTemplateId);
            assignCitizenToStudent(student.getUserId(), citizenId);
        }
    }

    public List<Citizen> getAllCitizen() throws Exception {
        return citizenDAO.getAllCitizen();
    }

    public Citizen getNeededCitizen(int citizenId) throws Exception {
        return citizenDAO.getNeededCitizen(citizenId);
    }

    public String getCitizenName(int citizenId) throws Exception {
        return citizenDAO.getCitizenName(citizenId);
    }



    //general info citizen
    //create
    public String getGeneralInfoCitizen(int citizenId, String generalInfoCitizenName) throws Exception {
        return generalInformationCitizenDAO.getGeneralInfoCitizen(citizenId, generalInfoCitizenName);
    }

    public void updateGeneralInfoCitizen(String generalInfoName, String generalInfoEditable, int citizenId) throws Exception {
        generalInformationCitizenDAO.updateGeneralInfoCitizen(generalInfoName, generalInfoEditable, citizenId);
    }



    //functional abilities citizen
    public void createFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) throws Exception {
        functionalAbilitiesCitizenDAO.createFunctionalAbilitiesCitizen(selectedCategory,selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
    }

    public List<String> getFunctionalInformationCitizen(String category, String subCategory, int citizenId) throws Exception {
        return functionalAbilitiesCitizenDAO.getFunctionalInformationCitizen(category, subCategory, citizenId);
    }

    public void updateFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) throws Exception {
        functionalAbilitiesCitizenDAO.updateFunctionalAbilitiesCitizen(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
    }

    public boolean checkFunctionalAbilitiesId(String selectedCategory, String selectedSubCategory, int citizenId) throws Exception {
        return functionalAbilitiesCitizenDAO.checkFunctionalAbilitiesId(selectedCategory, selectedSubCategory, citizenId);
    }

    public ObservableList<FunctionalAbilitie> getAllFunctionalAbilities(int citizenId) throws Exception {
        return functionalAbilitiesCitizenDAO.getAllFunctionalAbilities(citizenId);
    }



    //health conditions citizen
    public void createHealtConditionsCitizen(String selectedCategory, String selectedSubCategory, String relevance, String professionalNote, String currentAssessment, String expectedLevel, String observationNote, LocalDate date, int citizenId) throws Exception {
        healthConditionsCitizenDAO.createHealthConditionsCitizen(selectedCategory, selectedSubCategory, relevance, professionalNote, currentAssessment, expectedLevel, observationNote, date, citizenId);
    }

    public Object getHealthConditionCitizen(String category, String subCategory, int citizenId) throws Exception {
        return healthConditionsCitizenDAO.getHealthConditionCitizen(category, subCategory, citizenId);
    }

    public void updateHealthConditionsCitizen(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenId) throws Exception {
        healthConditionsCitizenDAO.updateHealthConditionsCitizen(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenId);
    }

    public boolean checkHealthConditionsId(String selectedCategory, String selectedSubCategory, int citizenId) throws Exception {
        return healthConditionsCitizenDAO.checkHealtConditionsId(selectedCategory, selectedSubCategory, citizenId);
    }

    public ObservableList<HealthCondition> getAllHealthCondition(int citizenId) throws Exception {
        return healthConditionsCitizenDAO.getAllHealthCondition(citizenId);
    }



    //citizen assigned to student
    public ArrayList<Integer> getAllCitizenId(int studentId) throws Exception {
        return studentGetsCitizenDAO.getAllCitizenId(studentId);
    }

    public void assignCitizenToStudent(int studentId, int citizenID) throws Exception {
        studentGetsCitizenDAO.assignCitizenToStudent(studentId, citizenID);
    }

}


