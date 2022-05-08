package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

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
}
