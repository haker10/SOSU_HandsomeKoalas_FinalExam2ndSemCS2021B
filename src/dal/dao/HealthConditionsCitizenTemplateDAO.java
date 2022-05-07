package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HealthConditionsCitizenTemplateDAO {
    DatabaseConnector databaseConnector;
    public HealthConditionsCitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }


    public void updateCitizenTemplate(String categoryName, String categoryExplanation, String color, int citizenTemplateId) {
        String sql = "INSERT INTO HealthConditionsCitizenTemplate(healthConditionsCitizenTemplateName, healthConditionsCitizenTemplateInformation, " +
                "healthConditionsCitizenTemplateColor, citizenTemplateID) VALUES (?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            preparedStatement.setString(2,categoryExplanation);
            preparedStatement.setString(3, color);
            preparedStatement.setInt(4, citizenTemplateId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
