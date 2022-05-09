package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

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
}
