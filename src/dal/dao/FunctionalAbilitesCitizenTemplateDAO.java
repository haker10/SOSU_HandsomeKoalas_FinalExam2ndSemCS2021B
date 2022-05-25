package dal.dao;

import be.FunctionalAbilitie;
import be.FunctionalAbilitieCT;
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

public class FunctionalAbilitesCitizenTemplateDAO {

    DatabaseConnector databaseConnector;

   public FunctionalAbilitesCitizenTemplateDAO(){
       databaseConnector = new DatabaseConnector();
   }


    public void createFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) {
       String sql = "INSERT INTO FunctionalAbilitiesCitizenTemplate(functionalAbilitiesCitizenTemplateCategoryName, functionalAbilitiesCitizenTemplateSubCategoryName, functionalAbilitiesCitizenTemplateScore, functionalAbilitiesCitizenTemplateExpectedScore, functionalAbilitiesCitizenTemplateProfessionalNote, functionalAbilitiesCitizenTemplatePerformance, functionalAbilitiesCitizenTemplateLimitation, functionalAbilitiesCitizenTemplateGoalsNote, functionalAbilitiesCitizenTemplateObservationNote, functionalAbilitiesCitizenTemplateDate,  citizenTemplateID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, selectedCategory);
            preparedStatement.setString(2,selectedSubCategory);
            preparedStatement.setInt(3, selectedPresentLevel);
            preparedStatement.setInt(4, selectedExpectedLevel);
            preparedStatement.setString(5, professionalNote);
            preparedStatement.setString(6, selectedPerformance);
            preparedStatement.setString(7, selectedMeaningOfPerformance);
            preparedStatement.setString(8, wishesNGoals);
            preparedStatement.setString(9, observationNote);
            preparedStatement.setObject(10, date);
            preparedStatement.setInt(11, citizenTemplateId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<String> getFunctionalInformationCitizenTemplate(String category, String subCategory, int citizenTemplateId) {
       List<String> allFunctionalInfoCitizenTemplate = new ArrayList<>();
        int score = 0;
        int expectedScore = 0;
        String proffNote = "";
        String performance = "";
        String limitation = "";
        String wishesNGoals = "";
        String observationNote = "";
        String date = LocalDate.now().toString();
       String sql = "SELECT * FROM FunctionalAbilitiesCitizenTemplate WHERE citizenTemplateID = ? and  functionalAbilitiesCitizenTemplateCategoryName = ? and functionalAbilitiesCitizenTemplateSubCategoryName = ?";

       try(Connection connection = databaseConnector.getConnection()){
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(2, category);
           preparedStatement.setString(3, subCategory);
           preparedStatement.setInt(1, citizenTemplateId);
           ResultSet resultSet = preparedStatement.executeQuery();

           if(resultSet.next()){
               score = resultSet.getInt("functionalAbilitiesCitizenTemplateScore");
               expectedScore = resultSet.getInt("functionalAbilitiesCitizenTemplateExpectedScore");
               proffNote = resultSet.getString("functionalAbilitiesCitizenTemplateProfessionalNote");
               performance = resultSet.getString("functionalAbilitiesCitizenTemplatePerformance");
               limitation = resultSet.getString("functionalAbilitiesCitizenTemplateLimitation");
               wishesNGoals = resultSet.getString("functionalAbilitiesCitizenTemplateGoalsNote");
               observationNote = resultSet.getString("functionalAbilitiesCitizenTemplateObservationNote");
               date = resultSet.getString("functionalAbilitiesCitizenTemplateDate");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        allFunctionalInfoCitizenTemplate.add(String.valueOf(score));
        allFunctionalInfoCitizenTemplate.add(String.valueOf(expectedScore));
        allFunctionalInfoCitizenTemplate.add(proffNote);
        allFunctionalInfoCitizenTemplate.add(performance);
        allFunctionalInfoCitizenTemplate.add(limitation);
        allFunctionalInfoCitizenTemplate.add(wishesNGoals);
        allFunctionalInfoCitizenTemplate.add(observationNote);
        allFunctionalInfoCitizenTemplate.add(date);

        return allFunctionalInfoCitizenTemplate;
    }

    public void updateFunctionalAbilitiesCitizenTemplate(String selectedCategory, String selectedSubCategory, int selectedPresentLevel, int selectedExpectedLevel, String professionalNote, String selectedPerformance, String selectedMeaningOfPerformance, String wishesNGoals, String observationNote, LocalDate date, int citizenTemplateId) {
       String sql = "UPDATE FunctionalAbilitiesCitizenTemplate SET functionalAbilitiesCitizenTemplateScore = ?, functionalAbilitiesCitizenTemplateExpectedScore = ?, functionalAbilitiesCitizenTemplateProfessionalNote = ?, functionalAbilitiesCitizenTemplatePerformance = ?, functionalAbilitiesCitizenTemplateLimitation = ?, functionalAbilitiesCitizenTemplateGoalsNote = ?, functionalAbilitiesCitizenTemplateObservationNote = ?, functionalAbilitiesCitizenTemplateDate = ? WHERE functionalAbilitiesCitizenTemplateCategoryName = ? and functionalAbilitiesCitizenTemplateSubCategoryName = ? and citizenTemplateID = ? ";
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
           preparedStatement.setInt(11, citizenTemplateId);
           preparedStatement.executeUpdate();
       }catch (Exception e){
                e.printStackTrace();
       }
   }

    public void copyCitizenTemplate(int citizenTemplateId, int newCitizenTemplateId) {
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
                createFunctionalAbilitiesCitizenTemplate(category, subCategory, score, expectedScore, professionalNote, performance, limitation, goalsNote, observationNote, date, newCitizenTemplateId);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkFuntionalAbilitiesCTId(String category, String subCategory, int citizenTemplateId) {
        String sql = "SELECT * FROM FunctionalAbilitiesCitizenTemplate WHERE citizenTemplateID = ? and  functionalAbilitiesCitizenTemplateCategoryName = ? and functionalAbilitiesCitizenTemplateSubCategoryName = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, subCategory);
            preparedStatement.setInt(1, citizenTemplateId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public ObservableList<FunctionalAbilitieCT> getAllFunctionalAbilities(int citizenTemplateID) {
        ObservableList<FunctionalAbilitieCT> allFunctionalInfoCitizenTemplate = FXCollections.observableArrayList();
        String sql = "SELECT * FROM FunctionalAbilitiesCitizenTemplate WHERE citizenTemplateID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenTemplateID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int score = resultSet.getInt("functionalAbilitiesCitizenTemplateScore");
                int fAId = resultSet.getInt("functionalAbilitiesCitizenTemplateID");
                String category = resultSet.getString("functionalAbilitiesCitizenTemplateCategoryName");
                String subcategory = resultSet.getString("functionalAbilitiesCitizenTemplateSubCategoryName");
                int expectedScore = resultSet.getInt("functionalAbilitiesCitizenTemplateExpectedScore");
                String proffNote = resultSet.getString("functionalAbilitiesCitizenTemplateProfessionalNote");
                String performance = resultSet.getString("functionalAbilitiesCitizenTemplatePerformance");
                String limitation = resultSet.getString("functionalAbilitiesCitizenTemplateLimitation");
                String wishesNGoals = resultSet.getString("functionalAbilitiesCitizenTemplateGoalsNote");
                String observationNote = resultSet.getString("functionalAbilitiesCitizenTemplateObservationNote");
                String date = resultSet.getString("functionalAbilitiesCitizenTemplateDate");
                java.sql.Date sqlDate = java.sql.Date.valueOf(date);
                LocalDate localDate = sqlDate.toLocalDate();
                FunctionalAbilitieCT functionalAbilitieCT = new FunctionalAbilitieCT(fAId, category, subcategory, score, expectedScore, proffNote, performance, limitation, wishesNGoals, observationNote, localDate, citizenTemplateID);
                allFunctionalInfoCitizenTemplate.add(functionalAbilitieCT);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allFunctionalInfoCitizenTemplate;
    }

    public boolean checkFunctionalAbilitiesId(String selectedCategory, String selectedSubCategory, int citizenTemplateID) {
        String sql = "SELECT * FROM FunctionalAbilitiesCitizenTemplate WHERE citizenTemplateID = ? and  functionalAbilitiesCitizenTemplateCategoryName = ? and functionalAbilitiesCitizenTemplateSubCategoryName = ?";
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