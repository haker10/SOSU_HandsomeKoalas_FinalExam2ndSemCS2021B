package dal.dao;

import dal.DatabaseConnector;

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
        int score = 1000;
        int expectedScore;
        String proffNote;
        String performance;
        String limitation;
        String wishesNGoals;
        String observationNote;
        String date;
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
               allFunctionalInfoCitizenTemplate.add(String.valueOf(score));
               allFunctionalInfoCitizenTemplate.add(String.valueOf(expectedScore));
               allFunctionalInfoCitizenTemplate.add(proffNote);
               allFunctionalInfoCitizenTemplate.add(performance);
               allFunctionalInfoCitizenTemplate.add(limitation);
               allFunctionalInfoCitizenTemplate.add(wishesNGoals);
               allFunctionalInfoCitizenTemplate.add(observationNote);
               allFunctionalInfoCitizenTemplate.add(date);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        if (score == 1000){
            score = 0;
            expectedScore = 0;
            proffNote = "";
            performance = "";
            limitation = "";
            wishesNGoals = "";
            observationNote = "";
            date = LocalDate.now().toString();
            allFunctionalInfoCitizenTemplate.add(String.valueOf(score));
            allFunctionalInfoCitizenTemplate.add(String.valueOf(expectedScore));
            allFunctionalInfoCitizenTemplate.add(proffNote);
            allFunctionalInfoCitizenTemplate.add(performance);
            allFunctionalInfoCitizenTemplate.add(limitation);
            allFunctionalInfoCitizenTemplate.add(wishesNGoals);
            allFunctionalInfoCitizenTemplate.add(observationNote);
            allFunctionalInfoCitizenTemplate.add(date);
        }
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
    
}