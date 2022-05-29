package dal.dao;

import be.HealthConditionCT;
import dal.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HealthConditionsCitizenTemplateDAO {
    DatabaseConnector databaseConnector;
    public HealthConditionsCitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public void createHealthConditionsCitizenTemplate(String selectedCategory, String selectedSubCategory, String selectedRelevance, String professionalNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws Exception{
        String sql = "INSERT INTO HealthConditionsCitizenTemplate(healthConditionsCitizenTemplateCategory, healthConditionsCitizenTemplateSubCategory, healthConditionsCitizenTemplateColor, healthConditionsCitizenTemplateProfessionalNote, healthConditionsCitizenTemplateAssessmentNote, healthConditionsCitizenTemplateExpectedLevel, healthConditionsCitizenTemplateObservableNote, healthConditionsCitizenTemplateDate, citizenTemplateID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, selectedCategory);
            preparedStatement.setString(2, selectedSubCategory);
            preparedStatement.setString(3, selectedRelevance);
            preparedStatement.setString(4, professionalNote);
            preparedStatement.setString(5, assessmentNote);
            preparedStatement.setString(6, expectedLevel);
            preparedStatement.setString(7, observableNote);
            preparedStatement.setObject(8, date);
            preparedStatement.setInt(9, citizenTemplateId);
            preparedStatement.executeUpdate();
        }
    }

    public List<String> getHealthConditionCitizenTemplate(String category, String subCategory, int citizenTemplateId) throws Exception{
        List<String> allHealthConditionsCitizenTemplate = new ArrayList<>();
        String relevance = "Not relevant";
        String proffNote = "";
        String assessmentNote = "";
        String expectedLevel = "";
        String observationNote = "";
        String date = LocalDate.now().toString();

        String sql = "SELECT * FROM HealthConditionsCitizenTemplate WHERE citizenTemplateID = ? and  healthConditionsCitizenTemplateCategory = ? and healthConditionsCitizenTemplateSubCategory = ?";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, subCategory);
            preparedStatement.setInt(1, citizenTemplateId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                relevance = resultSet.getString("healthConditionsCitizenTemplateColor");
                proffNote = resultSet.getString("healthConditionsCitizenTemplateProfessionalNote");
                assessmentNote = resultSet.getString("healthConditionsCitizenTemplateAssessmentNote");
                expectedLevel = resultSet.getString("healthConditionsCitizenTemplateExpectedLevel");
                observationNote = resultSet.getString("healthConditionsCitizenTemplateObservableNote");
                date = resultSet.getString("healthConditionsCitizenTemplateDate");

            }
        }

        allHealthConditionsCitizenTemplate.add(relevance);
        allHealthConditionsCitizenTemplate.add(proffNote);
        allHealthConditionsCitizenTemplate.add(assessmentNote);
        allHealthConditionsCitizenTemplate.add(expectedLevel);
        allHealthConditionsCitizenTemplate.add(observationNote);
        allHealthConditionsCitizenTemplate.add(date);

        return allHealthConditionsCitizenTemplate;
    }

    public void updateHealthConditionsCitizenTemplate(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) throws Exception{
        String sql = "UPDATE HealthConditionsCitizenTemplate SET healthConditionsCitizenTemplateColor = ?, healthConditionsCitizenTemplateProfessionalNote = ?, healthConditionsCitizenTemplateAssessmentNote = ?, healthConditionsCitizenTemplateExpectedLevel = ?, healthConditionsCitizenTemplateObservableNote = ?, healthConditionsCitizenTemplateDate = ? WHERE healthConditionsCitizenTemplateCategory = ? and healthConditionsCitizenTemplateSubCategory = ? and citizenTemplateID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, relevance);
            preparedStatement.setString(2, proffNote);
            preparedStatement.setString(3, assessmentNote);
            preparedStatement.setString(4, expectedLevel);
            preparedStatement.setString(5, observableNote);
            preparedStatement.setDate(6, Date.valueOf(date));
            preparedStatement.setString(7, category);
            preparedStatement.setString(8, subCategory);
            preparedStatement.setInt(9, citizenTemplateId);
            preparedStatement.executeUpdate();
        }
    }

    public void copyCitizenTemplate(int citizenTemplateId, int newCitizenTemplateId) throws Exception{
        String sql = "SELECT * FROM HealthConditionsCitizenTemplate WHERE citizenTemplateID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenTemplateId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String category = resultSet.getString("healthConditionsCitizenTemplateCategory");
                String subCategory = resultSet.getString("healthConditionsCitizenTemplateSubCategory");
                String relevance = resultSet.getString("healthConditionsCitizenTemplateColor");
                String proffNote = resultSet.getString("healthConditionsCitizenTemplateProfessionalNote");
                String assessmentNote = resultSet.getString("healthConditionsCitizenTemplateAssessmentNote");
                String expectedLevel = resultSet.getString("healthConditionsCitizenTemplateExpectedLevel");
                String observationNote = resultSet.getString("healthConditionsCitizenTemplateObservableNote");
                LocalDate date = resultSet.getDate("healthConditionsCitizenTemplateDate").toLocalDate();
                createHealthConditionsCitizenTemplate(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observationNote, date, newCitizenTemplateId);
            }
        }
    }

    public boolean checkHealthConditionsCTId(String category, String subCategory, int citizenTemplateId) throws Exception{
        String sql = "SELECT * FROM HealthConditionsCitizenTemplate WHERE citizenTemplateID = ? and  healthConditionsCitizenTemplateCategory = ? and healthConditionsCitizenTemplateSubCategory = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, subCategory);
            preparedStatement.setInt(1, citizenTemplateId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }
        return false;
    }

    public ObservableList<HealthConditionCT> getAllHealthCondition(int citizenTemplateID) throws Exception{
        ObservableList<HealthConditionCT> allHealthConditionsCitizenTemplate = FXCollections.observableArrayList();
        String sql = "SELECT * FROM HealthConditionsCitizenTemplate WHERE citizenTemplateID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenTemplateID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int hCId = resultSet.getInt("healthConditionsCitizenTemplateID");
                String category = resultSet.getString("healthConditionsCitizenTemplateCategory");
                String subCategory = resultSet.getString("healthConditionsCitizenTemplateSubCategory");
                String relevance = resultSet.getString("healthConditionsCitizenTemplateColor");
                String proffNote = resultSet.getString("healthConditionsCitizenTemplateProfessionalNote");
                String assessmentNote = resultSet.getString("healthConditionsCitizenTemplateAssessmentNote");
                String expectedLevel = resultSet.getString("healthConditionsCitizenTemplateExpectedLevel");
                String observationNote = resultSet.getString("healthConditionsCitizenTemplateObservableNote");
                String date = resultSet.getString("healthConditionsCitizenTemplateDate");
                java.sql.Date sqlDate = java.sql.Date.valueOf(date);
                LocalDate localDate = sqlDate.toLocalDate();
                HealthConditionCT healthConditionCT = new HealthConditionCT(hCId, category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observationNote, localDate, citizenTemplateID);
                allHealthConditionsCitizenTemplate.add(healthConditionCT);
            }
        }
        return allHealthConditionsCitizenTemplate;
    }

    public boolean checkHealtConditionsId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) throws Exception{
        String sql = "SELECT * FROM HealthConditionsCitizenTemplate WHERE citizenTemplateID = ? and  healthConditionsCitizenTemplateCategory = ? and healthConditionsCitizenTemplateSubCategory = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, selectedCategory);
            preparedStatement.setString(3, selectedSubCategory);
            preparedStatement.setInt(1, citizenTemplateID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}