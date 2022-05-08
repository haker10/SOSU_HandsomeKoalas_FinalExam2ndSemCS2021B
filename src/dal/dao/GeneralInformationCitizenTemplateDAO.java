package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GeneralInformationCitizenTemplateDAO {
    DatabaseConnector databaseConnector;

     public   GeneralInformationCitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) {
        String sql = "INSERT INTO GeneralInformationCitizenTemplate(generalInformationCitizenTemplateName, generalInformationCitizenTemplateExplanation, " +
                "generalInformationCitizenTemplateEditable, citizenTemplateID) VALUES (?, ?, ?, ?)";
        try(
                Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, generalInfoName);
            preparedStatement.setString(2,generalInfoExplanation);
            preparedStatement.setString(3, generalInfoEditable);
            preparedStatement.setInt(4, citizenTemplateId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
