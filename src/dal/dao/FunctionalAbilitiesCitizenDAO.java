package dal.dao;

import be.FunctionalAbilitie;
import dal.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class FunctionalAbilitiesCitizenDAO {

    DatabaseConnector databaseConnector;

    public FunctionalAbilitiesCitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public void copyFunctionalAbilitiesCitizen(int citizenId, int citizenTemplateId) {
        String sql = "SELECT * FROM FunctionalAbilitiesCitizenTemplate WHERE citizenTemplateID = ?";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenTemplateId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String category = resultSet.getString("functionalAbilitiesCitizenTemplateCategoryName");
                String subCategory = resultSet.getString("functionalAbilitiesCitizenTemplateSubCategoryName");
                int score = Integer.parseInt(resultSet.getString("functionalAbilitiesCitizenTemplateScore"));
                int expectedScore = Integer.parseInt(resultSet.getString("functionalAbilitiesCitizenTemplateExpectedScore"));
                String professionalNote = resultSet.getString("functionalAbilitiesCitizenTemplateProfessionalNote");
                String performance = resultSet.getString("functionalAbilitiesCitizenTemplatePerformance");
                String limitation = resultSet.getString("functionalAbilitiesCitizenTemplateLimitation");
                String goalsNote = resultSet.getString("functionalAbilitiesCitizenTemplateGoalsNote");
                String observationNote = resultSet.getString("functionalAbilitiesCitizenTemplateObservationNote");
                LocalDate date = resultSet.getDate("functionalAbilitiesCitizenTemplateDate").toLocalDate();
                createFunctionalAbilitiesCitizen(category, subCategory, score, expectedScore, professionalNote, performance, limitation, goalsNote, observationNote, date, citizenId);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createFunctionalAbilitiesCitizen(String category, String subCategory, int score, int expectedScore, String professionalNote, String performance, String limitation, String goalsNote, String observationNote, LocalDate date, int citizenId) {
        String sql = "INSERT INTO FunctionalAbilitiesCitizen(functionalAbilitiesCitizenCategoryName, functionalAbilitiesCitizenSubCategoryName, functionalAbilitiesCitizenScore, functionalAbilitiesCitizenExpectedScore, functionalAbilitiesCitizenProfessionalNote, functionalAbilitiesCitizenPerformance, functionalAbilitiesCitizenLimitation, functionalAbilitiesCitizenGoalsNote, functionalAbilitiesCitizenObservationNote, functionalAbilitiesCitizenTemplateDate,  citizenID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category);
            preparedStatement.setString(2,subCategory);
            preparedStatement.setInt(3, score);
            preparedStatement.setInt(4, expectedScore);
            preparedStatement.setString(5, professionalNote);
            preparedStatement.setString(6, performance);
            preparedStatement.setString(7, limitation);
            preparedStatement.setString(8, goalsNote);
            preparedStatement.setString(9, observationNote);
            preparedStatement.setObject(10, date);
            preparedStatement.setInt(11, citizenId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object getFunctionalInformationCitizen(String category, String subCategory, int citizenId) {
        List<String> allFunctionalInfoCitizen = new ArrayList<>();
        String sql = "SELECT * FROM FunctionalAbilitiesCitizen WHERE citizenID = ? and  functionalAbilitiesCitizenCategoryName = ? and functionalAbilitiesCitizenSubCategoryName = ?";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, subCategory);
            preparedStatement.setInt(1, citizenId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int score = resultSet.getInt("functionalAbilitiesCitizenScore");
                int expectedScore = resultSet.getInt("functionalAbilitiesCitizenExpectedScore");
                String proffNote = resultSet.getString("functionalAbilitiesCitizenProfessionalNote");
                String performance = resultSet.getString("functionalAbilitiesCitizenPerformance");
                String limitation = resultSet.getString("functionalAbilitiesCitizenLimitation");
                String wishesNGoals = resultSet.getString("functionalAbilitiesCitizenGoalsNote");
                String observationNote = resultSet.getString("functionalAbilitiesCitizenObservationNote");
                String date = resultSet.getString("functionalAbilitiesCitizenTemplateDate");
                allFunctionalInfoCitizen.add(String.valueOf(score));
                allFunctionalInfoCitizen.add(String.valueOf(expectedScore));
                allFunctionalInfoCitizen.add(proffNote);
                allFunctionalInfoCitizen.add(performance);
                allFunctionalInfoCitizen.add(limitation);
                allFunctionalInfoCitizen.add(wishesNGoals);
                allFunctionalInfoCitizen.add(observationNote);
                allFunctionalInfoCitizen.add(date);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allFunctionalInfoCitizen;
    }

    public void updateFunctionalAbilitiesCitizen(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenId) {
        String sql = "UPDATE FunctionalAbilitiesCitizen SET functionalAbilitiesCitizenScore = ?, functionalAbilitiesCitizenExpectedScore = ?, functionalAbilitiesCitizenProfessionalNote = ?, functionalAbilitiesCitizenPerformance = ?, functionalAbilitiesCitizenLimitation = ?, functionalAbilitiesCitizenGoalsNote = ?, functionalAbilitiesCitizenObservationNote = ?, functionalAbilitiesCitizenTemplateDate = ? WHERE functionalAbilitiesCitizenCategoryName = ? and functionalAbilitiesCitizenSubCategoryName = ? and citizenID = ? ";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,selectedPresentLevel);
            preparedStatement.setInt(2,selectedExpectedLevel);
            preparedStatement.setString(3, professionalNote);
            preparedStatement.setString(4, selectedPerformance);
            preparedStatement.setString(5, selectedMeaningOfPerformance);
            preparedStatement.setString(6, wishesNGoals);
            preparedStatement.setString(7, observationNote);
            preparedStatement.setDate(8, Date.valueOf(date));
            preparedStatement.setString(9,selectedCategory);
            preparedStatement.setString(10, selectedSubCategory);
            preparedStatement.setInt(11, citizenId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ObservableList<FunctionalAbilitie> getAllFunctionalAbilities(int citizenId) {
        ObservableList<FunctionalAbilitie> allFunctionalInfoCitizen = FXCollections.observableArrayList();
        String sql = "SELECT * FROM FunctionalAbilitiesCitizen WHERE citizenID = ?";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int score = resultSet.getInt("functionalAbilitiesCitizenScore");
                int fAId = resultSet.getInt("functionalAbilitiesCitizenID");
                String category = resultSet.getString("functionalAbilitiesCitizenCategoryName");
                String subcategory = resultSet.getString("functionalAbilitiesCitizenSubCategoryName");
                int expectedScore = resultSet.getInt("functionalAbilitiesCitizenExpectedScore");
                String proffNote = resultSet.getString("functionalAbilitiesCitizenProfessionalNote");
                String performance = resultSet.getString("functionalAbilitiesCitizenPerformance");
                String limitation = resultSet.getString("functionalAbilitiesCitizenLimitation");
                String wishesNGoals = resultSet.getString("functionalAbilitiesCitizenGoalsNote");
                String observationNote = resultSet.getString("functionalAbilitiesCitizenObservationNote");
                String date = resultSet.getString("functionalAbilitiesCitizenTemplateDate");
                java.sql.Date sqlDate = java.sql.Date.valueOf(date);
                LocalDate localDate = sqlDate.toLocalDate();
                FunctionalAbilitie functionalAbilitie = new FunctionalAbilitie(fAId, category, subcategory, score, expectedScore, proffNote, performance, limitation, wishesNGoals, observationNote, localDate, citizenId);
                allFunctionalInfoCitizen.add(functionalAbilitie);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allFunctionalInfoCitizen;
    }

}
