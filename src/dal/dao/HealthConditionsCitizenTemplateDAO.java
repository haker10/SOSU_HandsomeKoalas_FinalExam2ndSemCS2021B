package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HealthConditionsCitizenTemplateDAO {
    DatabaseConnector databaseConnector;
    public HealthConditionsCitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }


    public void updateCitizenTemplate(Object o, String categoryName, String categoryExplanation, String color, int citizenTemplateId) {
        String sql = "INSERT INTO HealthConditionsCitizenTemplate(healthConditionsCitizenTemplateParentID, healthConditionsCitizenTemplateName, healthConditionsCitizenTemplateInformation, " +
                "healthConditionsCitizenTemplateColor, citizenTemplateID) VALUES (?, ?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (Integer) o);
            preparedStatement.setString(2, categoryName);
            preparedStatement.setString(3,categoryExplanation);
            preparedStatement.setString(4, color);
            preparedStatement.setInt(5, citizenTemplateId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
