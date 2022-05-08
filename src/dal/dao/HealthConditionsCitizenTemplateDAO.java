package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class HealthConditionsCitizenTemplateDAO {
    DatabaseConnector databaseConnector;
    public HealthConditionsCitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public void createHealthConditionsCitizenTemplate(String selectedCategory, String selectedSubCategory, String selectedRelevance, String professionalNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenTemplateId) {
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
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
