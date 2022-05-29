package bll;

import be.*;

import bll.exceptions.DatabaseException;
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
    public User login(String username, String password) throws DatabaseException {
        try {
            return userDataDAO.login(username, password);
        } catch (Exception exception) {
            throw new DatabaseException("Login failed! Check database connection!", exception);
        }
    }

    public void editUser(int userId, String name, String username, String password) throws DatabaseException {
        try {
            userDataDAO.editUser(userId, name, username, password);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't edit! Check database connection!", exception);
        }
    }

    public void deleteUser(int userId) throws DatabaseException {
        try {
            userDataDAO.deleteUser(userId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't delete! Check database connection!", exception);
        }
    }

    public List<User> getAllUsernames() throws DatabaseException {
        try {
            return userDataDAO.getAllUsernames();
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all usernames! Check database connection!", exception);
        }
    }



    //schools
    public List<School> getAllSchools() throws DatabaseException {
        try {
            return schoolDAO.getAllSchools();
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all schools! Check database connection!", exception);
        }
    }

    public void createNewSchool(String school) throws DatabaseException {
        try {
            schoolDAO.createNewSchool(school);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create new school! Check database connection!", exception);
        }
    }

    public String getSchoolName(int schoolId1) throws DatabaseException {
        try {
            return schoolDAO.getSchoolName(schoolId1);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get school name! Check database connection!", exception);
        }
    }

    public List<School> getAllSchoolsNotAssigned() throws DatabaseException {
        try {
            return schoolDAO.getAllSchoolsNotAssigned();
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get schools that are not assigned! Check database connection!", exception);
        }
    }



    //admins
    public List<User> getAllAdmins() throws DatabaseException {
        try {
            return userDataDAO.getAllAdmins();
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all admins! Check database connection!", exception);
        }
    }

    public void createAdmin(int schoolId, String name, String username, String password) throws DatabaseException {
        try {
            userDataDAO.createAdmin(schoolId, name, username, password);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create new admin! Check database connection!", exception);
        }
    }



    //teachers
    public List<User> getAllTeachers(int schoolId) throws DatabaseException {
        try {
            return userDataDAO.getAllTeachers(schoolId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all teachers! Check database connection!", exception);
        }
    }

    public void createTeacher(int school, String name, String username, String password) throws DatabaseException {
        try {
            userDataDAO.createTeacher(school, name, username, password);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create new teacher! Check database connection!", exception);
        }
    }



    //students
    public List<User> getAllStudents(int schoolId) throws DatabaseException {
        try {
            return userDataDAO.getAllStudents(schoolId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all students! Check database connection!", exception);
        }
    }

    public User createStudent(int schoolId, String name, String username, String password) throws DatabaseException {
        try {
            List<CitizenTemplate> allTemplates = citizenTemplateDAO.getALlCitizenTemplates(schoolId);
            User student = null;
            if (allTemplates.size() == 0) {
                student = userDataDAO.createStudent(schoolId, name, username, password);
            } else {
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
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create new student! Check database connection!", exception);
        }
    }



    //citizenTemplate
    public CitizenTemplate createCitizenTemplate(int schoolId1, String citizenTemplateName) throws DatabaseException {
        try {
            return citizenTemplateDAO.createCitizenTemplate(schoolId1, citizenTemplateName);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create Citizen Template! Check database connection!", exception);
        }
    }

    public List<CitizenTemplate> getAllCitizenTemplates(int schoolId) throws DatabaseException {
        try {
            return citizenTemplateDAO.getALlCitizenTemplates(schoolId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all Citizen Templates! Check database connection!", exception);
        }

    }

    public void deleteCitizenTemplate(int citizenTemplateId) throws DatabaseException {
        try {
            citizenTemplateDAO.deleteCitizenTemplate(citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't delete Citizen Template! Check database connection!", exception);
        }
    }

    public void copyCitizenTemplate(int citizenTemplateId, int schoolID, String citizenTemplateName) throws DatabaseException {
        try {
            CitizenTemplate citizenTemplate = citizenTemplateDAO.createCitizenTemplate(schoolID, citizenTemplateName);
            int citizenTemplateId2 = citizenTemplate.getCitizenTemplateId();
            healthConditionsCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
            functionalAbilitesCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
            generalInformationCitizenTemplateDAO.copyCitizenTemplate(citizenTemplateId, citizenTemplateId2);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't copy Citizen Template! Check database connection!", exception);
        }
    }

    public String getCitizenTemplateName(int citizenTemplateID) throws DatabaseException {
        try {
            return citizenTemplateDAO.getCitizenTemplateName(citizenTemplateID);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get Citizen Template name! Check database connection!", exception);
        }
    }

    public List<CitizenTemplate> getAllCitizenTemplateNames() throws DatabaseException {
        try {
            return citizenTemplateDAO.getAllCitizenTemplateNames();
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all Citizen Template names! Check database connection!", exception);
        }
    }



    //general info citizenTemplate
    public void createGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) throws DatabaseException {
        try {
            generalInformationCitizenTemplateDAO.createGeneralInfoCitizenTemplate(generalInfoName, generalInfoExplanation, generalInfoEditable, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create general info for Citizen Template! Check database connection!", exception);
        }
    }

    public String getGeneralInfoCitizenTemplate(int citizenTemplateId, String generalInfoCitizenTemplateName) throws DatabaseException {
        try {
            return generalInformationCitizenTemplateDAO.getGeneralInfoCitizenTemplate(citizenTemplateId, generalInfoCitizenTemplateName);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get general info for Citizen Template! Check database connection!", exception);
        }
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoEditable, int citizenTemplateId) throws DatabaseException {
        try {
            generalInformationCitizenTemplateDAO.updateGeneralInfoCitizenTemplate(generalInfoName, generalInfoEditable, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't update general info for Citizen Template! Check database connection!", exception);
        }
    }



    //functional abilities citizenTemplate
    public void createFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) throws DatabaseException {
        try {
            functionalAbilitesCitizenTemplateDAO.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create functional ability for Citizen Template! Check database connection!", exception);
        }
    }

    public List<String> getFunctionalInformationCitizenTemplate(String category, String subCategory, int citizenTemplateId) throws DatabaseException {
        try {
            return functionalAbilitesCitizenTemplateDAO.getFunctionalInformationCitizenTemplate(category, subCategory, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get functional ability for Citizen Template! Check database connection!", exception);
        }
    }

    public void updateFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) throws DatabaseException {
        try {
            functionalAbilitesCitizenTemplateDAO.updateFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't update functional ability for Citizen Template! Check database connection!", exception);
        }
    }

    public boolean checkFunctionalAbilitiesCTId(String selectedCategory, String selectedSubCategory, int citizenTemplateId) throws DatabaseException {
        try {
            return functionalAbilitesCitizenTemplateDAO.checkFuntionalAbilitiesCTId(selectedCategory, selectedSubCategory, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't check functional abilities for Citizen Template! Check database connection!", exception);
        }
    }

    public ObservableList<FunctionalAbilitieCT> getAllFunctionalAbilitiesTemplate(int citizenTemplateID) throws DatabaseException {
        try {
            return functionalAbilitesCitizenTemplateDAO.getAllFunctionalAbilities(citizenTemplateID);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all functional abilities for Citizen Template! Check database connection!", exception);
        }
    }

    public boolean checkFunctionalAbilitiesTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) throws DatabaseException {
        try {
            return functionalAbilitesCitizenTemplateDAO.checkFunctionalAbilitiesId(selectedCategory, selectedSubCategory, citizenTemplateID);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't check functional abilities for Citizen Template! Check database connection!", exception);
        }
    }



    //health conditions citizenTemplate
    public void createHealthConditionsCitizenTemplate(String selectedCategory, String selectedSubCategory, String selectedRelevance, String professionalNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws DatabaseException {
        try {
            healthConditionsCitizenTemplateDAO.createHealthConditionsCitizenTemplate(selectedCategory, selectedSubCategory, selectedRelevance, professionalNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create health conditions for Citizen Template! Check database connection!", exception);
        }
    }

    public List<String> getHealthConditionCitizenTemplate(String category, String subCategory, int citizenTemplateId) throws DatabaseException {
        try {
            return healthConditionsCitizenTemplateDAO.getHealthConditionCitizenTemplate(category, subCategory, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get health conditions for Citizen Template! Check database connection!", exception);
        }
    }

    public void updateHealthConditionsCitizenTemplate(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws DatabaseException {
        try {
            healthConditionsCitizenTemplateDAO.updateHealthConditionsCitizenTemplate(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't update health conditions for Citizen Template! Check database connection!", exception);
        }
    }

    public boolean checkHealthConditionsCTId(String selectedCategory, String selectedSubCategory, int citizenTemplateId) throws DatabaseException {
        try {
            return healthConditionsCitizenTemplateDAO.checkHealthConditionsCTId(selectedCategory, selectedSubCategory, citizenTemplateId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't check health conditions for Citizen Template! Check database connection!", exception);
        }
    }

    public ObservableList<HealthConditionCT> getAllHealthConditionTemplate(int citizenTemplateID) throws DatabaseException {
        try {
            return healthConditionsCitizenTemplateDAO.getAllHealthCondition(citizenTemplateID);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all health conditions for Citizen Template! Check database connection!", exception);
        }
    }

    public boolean checkHealthConditionsTemplateId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) throws DatabaseException {
        try {
            return healthConditionsCitizenTemplateDAO.checkHealtConditionsId(selectedCategory, selectedSubCategory, citizenTemplateID);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't check health conditions for Citizen Template! Check database connection!", exception);
        }
    }



    //citizen
    public void createCitizenFromTemplate(int citizenTemplateId, String citizenName, int schoolId) throws DatabaseException {
        try {
            List<User> allStudents = getAllStudents(schoolId);
            for (User student : allStudents) {
                Citizen citizen = citizenDAO.createCitizenFromTemplate(citizenTemplateId, citizenName);
                int citizenId = citizen.getCitizenId();
                healthConditionsCitizenDAO.copyHealthConditionsCitizen(citizenId, citizenTemplateId);
                functionalAbilitiesCitizenDAO.copyFunctionalAbilitiesCitizen(citizenId, citizenTemplateId);
                generalInformationCitizenDAO.copyGeneralInformationCitizen(citizenId, citizenTemplateId);
                assignCitizenToStudent(student.getUserId(), citizenId);
            }
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create Citizen from Citizen Template! Check database connection!", exception);
        }
    }

    public List<Citizen> getAllCitizen() throws DatabaseException {
        try {
            return citizenDAO.getAllCitizen();
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all Citizens! Check database connection!", exception);
        }
    }

    public Citizen getNeededCitizen(int citizenId) throws DatabaseException {
        try {
            return citizenDAO.getNeededCitizen(citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get Citizen! Check database connection!", exception);
        }
    }

    public String getCitizenName(int citizenId) throws DatabaseException {
        try {
            return citizenDAO.getCitizenName(citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get Citizen name! Check database connection!", exception);
        }
    }



    //general info citizen
    public String getGeneralInfoCitizen(int citizenId, String generalInfoCitizenName) throws DatabaseException {
        try {
            return generalInformationCitizenDAO.getGeneralInfoCitizen(citizenId, generalInfoCitizenName);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get general info for Citizen! Check database connection!", exception);
        }
    }

    public void updateGeneralInfoCitizen(String generalInfoName, String generalInfoEditable, int citizenId) throws DatabaseException {
        try {
            generalInformationCitizenDAO.updateGeneralInfoCitizen(generalInfoName, generalInfoEditable, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't update general info for Citizen! Check database connection!", exception);
        }
    }



    //functional abilities citizen
    public void createFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) throws DatabaseException {
        try {
            functionalAbilitiesCitizenDAO.createFunctionalAbilitiesCitizen(selectedCategory,selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create functional abilities for Citizen! Check database connection!", exception);
        }
    }

    public List<String> getFunctionalInformationCitizen(String category, String subCategory, int citizenId) throws DatabaseException {
        try {
            return functionalAbilitiesCitizenDAO.getFunctionalInformationCitizen(category, subCategory, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get functional abilities for Citizen! Check database connection!", exception);
        }
    }

    public void updateFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) throws DatabaseException {
        try {
            functionalAbilitiesCitizenDAO.updateFunctionalAbilitiesCitizen(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't update functional abilities for Citizen! Check database connection!", exception);
        }
    }

    public boolean checkFunctionalAbilitiesId(String selectedCategory, String selectedSubCategory, int citizenId) throws DatabaseException {
        try {
            return functionalAbilitiesCitizenDAO.checkFunctionalAbilitiesId(selectedCategory, selectedSubCategory, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't check functional abilities for Citizen! Check database connection!", exception);
        }
    }

    public ObservableList<FunctionalAbilitie> getAllFunctionalAbilities(int citizenId) throws DatabaseException {
        try {
            return functionalAbilitiesCitizenDAO.getAllFunctionalAbilities(citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all functional abilities for Citizen! Check database connection!", exception);
        }
    }



    //health conditions citizen
    public void createHealtConditionsCitizen(String selectedCategory, String selectedSubCategory, String relevance, String professionalNote, String currentAssessment, String expectedLevel, String observationNote, LocalDate date, int citizenId) throws DatabaseException {
        try {
            healthConditionsCitizenDAO.createHealthConditionsCitizen(selectedCategory, selectedSubCategory, relevance, professionalNote, currentAssessment, expectedLevel, observationNote, date, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't create health conditions for Citizen! Check database connection!", exception);
        }
    }

    public Object getHealthConditionCitizen(String category, String subCategory, int citizenId) throws DatabaseException {
        try {
            return healthConditionsCitizenDAO.getHealthConditionCitizen(category, subCategory, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get health conditions for Citizen! Check database connection!", exception);
        }
    }

    public void updateHealthConditionsCitizen(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenId) throws DatabaseException {
        try {
            healthConditionsCitizenDAO.updateHealthConditionsCitizen(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observableNote, date, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't update health conditions for Citizen! Check database connection!", exception);
        }
    }

    public boolean checkHealthConditionsId(String selectedCategory, String selectedSubCategory, int citizenId) throws DatabaseException {
        try {
            return healthConditionsCitizenDAO.checkHealtConditionsId(selectedCategory, selectedSubCategory, citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't check health conditions for Citizen! Check database connection!", exception);
        }
    }

    public ObservableList<HealthCondition> getAllHealthCondition(int citizenId) throws DatabaseException {
        try {
            return healthConditionsCitizenDAO.getAllHealthCondition(citizenId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all health conditions for Citizen! Check database connection!", exception);
        }
    }



    //citizen assigned to student
    public ArrayList<Integer> getAllCitizenId(int studentId) throws DatabaseException {
        try {
            return studentGetsCitizenDAO.getAllCitizenId(studentId);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't get all citizens assigned to Student! Check database connection!", exception);
        }
    }

    public void assignCitizenToStudent(int studentId, int citizenID) throws DatabaseException {
        try {
            studentGetsCitizenDAO.assignCitizenToStudent(studentId, citizenID);
        } catch (Exception exception) {
            throw new DatabaseException("Couldn't assign citizen to Student! Check database connection!", exception);
        }
    }

}


