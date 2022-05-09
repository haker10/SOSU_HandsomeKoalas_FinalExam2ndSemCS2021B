package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class HealthConditionsCitizenDAO {

    DatabaseConnector databaseConnector;

    public HealthConditionsCitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public void copyHealthConditionsCitizen(int citizenId, int citizenTemplateId) {
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
                createHealthConditionsCitizen(category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observationNote, date, citizenId);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createHealthConditionsCitizen(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observationNote, LocalDate date, int citizenId) {
        String sql = "INSERT INTO HealthConditionsCitizen(healthConditionsCitizenCategory, healthConditionsCitizenSubCategory, healthConditionsCitizenColor, healthConditionsCitizenProfessionalNote, healthConditionsCitizenAssessmentNote, healthConditionsCitizenExpectedLevel, healthConditionsCitizenObservableNote, healthConditionsCitizenDate, citizenID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category);
            preparedStatement.setString(2, subCategory);
            preparedStatement.setString(3, relevance);
            preparedStatement.setString(4, proffNote);
            preparedStatement.setString(5, assessmentNote);
            preparedStatement.setString(6, expectedLevel);
            preparedStatement.setString(7, observationNote);
            preparedStatement.setObject(8, date);
            preparedStatement.setInt(9, citizenId);
            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
