package dal.dao;

import be.HealthCondition;
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
    public Object getHealthConditionCitizen(String category, String subCategory, int citizenId) {
        List<String> allHealthConditionsCitizen = new ArrayList<>();

        String sql = "SELECT * FROM HealthConditionsCitizen WHERE citizenID = ? and  healthConditionsCitizenCategory = ? and healthConditionsCitizenSubCategory = ?";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, subCategory);
            preparedStatement.setInt(1, citizenId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                String relevance = resultSet.getString("healthConditionsCitizenColor");
                String proffNote = resultSet.getString("healthConditionsCitizenProfessionalNote");
                String assessmentNote = resultSet.getString("healthConditionsCitizenAssessmentNote");
                String expectedLevel = resultSet.getString("healthConditionsCitizenExpectedLevel");
                String observationNote = resultSet.getString("healthConditionsCitizenObservableNote");
                String date = resultSet.getString("healthConditionsCitizenDate");
                allHealthConditionsCitizen.add(relevance);
                allHealthConditionsCitizen.add(proffNote);
                allHealthConditionsCitizen.add(assessmentNote);
                allHealthConditionsCitizen.add(expectedLevel);
                allHealthConditionsCitizen.add(observationNote);
                allHealthConditionsCitizen.add(date);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allHealthConditionsCitizen;
    }

    public void updateHealthConditionsCitizen(String category, String subCategory, String relevance, String proffNote, String assessmentNote, String expectedLevel, String observableNote, LocalDate date, int citizenId) {
        String sql = "UPDATE HealthConditionsCitizen SET healthConditionsCitizenColor = ?, healthConditionsCitizenProfessionalNote = ?, healthConditionsCitizenAssessmentNote = ?, healthConditionsCitizenExpectedLevel = ?, healthConditionsCitizenObservableNote = ?, healthConditionsCitizenDate = ? WHERE healthConditionsCitizenCategory = ? and healthConditionsCitizenSubCategory = ? and citizenID = ?";

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
            preparedStatement.setInt(9, citizenId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ObservableList<HealthCondition> getAllHealthCondition(int citizenId) {
        ObservableList<HealthCondition> allHealthConditionsCitizen = FXCollections.observableArrayList();

        String sql = "SELECT * FROM HealthConditionsCitizen WHERE citizenID = ?";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int hCId = resultSet.getInt("healthConditionsCitizenID");
                String category = resultSet.getString("healthConditionsCitizenCategory");
                String subCategory = resultSet.getString("healthConditionsCitizenSubCategory");
                String relevance = resultSet.getString("healthConditionsCitizenColor");
                String proffNote = resultSet.getString("healthConditionsCitizenProfessionalNote");
                String assessmentNote = resultSet.getString("healthConditionsCitizenAssessmentNote");
                String expectedLevel = resultSet.getString("healthConditionsCitizenExpectedLevel");
                String observationNote = resultSet.getString("healthConditionsCitizenObservableNote");
                //String date = resultSet.getString("healthConditionsCitizenDate");
                HealthCondition healthCondition = new HealthCondition(hCId, category, subCategory, relevance, proffNote, assessmentNote, expectedLevel, observationNote, null, citizenId);
                allHealthConditionsCitizen.add(healthCondition);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allHealthConditionsCitizen;
    }
}
