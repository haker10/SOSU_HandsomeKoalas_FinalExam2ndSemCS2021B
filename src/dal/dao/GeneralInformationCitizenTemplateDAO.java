package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GeneralInformationCitizenTemplateDAO {
    DatabaseConnector databaseConnector;

     public   GeneralInformationCitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public void createGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoExplanation, String generalInfoEditable, int citizenTemplateId) throws Exception{
        String sql = "INSERT INTO GeneralInformationCitizenTemplate(generalInformationCitizenTemplateName, generalInformationCitizenTemplateExplanation, " +
                "generalInformationCitizenTemplateEditable, citizenTemplateID) VALUES (?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, generalInfoName);
            preparedStatement.setString(2,generalInfoExplanation);
            preparedStatement.setString(3, generalInfoEditable);
            preparedStatement.setInt(4, citizenTemplateId);
            preparedStatement.executeUpdate();
        }
    }

    public String getGeneralInfoCitizenTemplate(int citizenTemplateId, String generalInfoCitizenTemplateName) throws Exception{
         String editable = null;
         String sql = "SELECT * FROM GeneralInformationCitizenTemplate WHERE citizenTemplateID = ? and generalInformationCitizenTemplateName = ?";
         try(Connection connection = databaseConnector.getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1,citizenTemplateId);
             preparedStatement.setString(2,generalInfoCitizenTemplateName);
             ResultSet resultSet = preparedStatement.executeQuery();
             if(resultSet.next()){
                 String text = resultSet.getString("generalInformationCitizenTemplateEditable");
                 editable = text;
             }
         }
         return editable;
    }

    public void updateGeneralInfoCitizenTemplate(String generalInfoName, String generalInfoEditable, int citizenTemplateId) throws Exception{
        String editable = getGeneralInfoCitizenTemplate(citizenTemplateId, generalInfoName);
        if (editable == null) {
            createGeneralInfoCitizenTemplate(generalInfoName, "", generalInfoEditable, citizenTemplateId);
        }
        else {
            String sql = "UPDATE GeneralInformationCitizenTemplate SET generalInformationCitizenTemplateEditable = ? WHERE generalInformationCitizenTemplateName = ? and citizenTemplateId = ? ";
            try (Connection connection = databaseConnector.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, generalInfoEditable);
                preparedStatement.setString(2, generalInfoName);
                preparedStatement.setInt(3, citizenTemplateId);
                preparedStatement.executeUpdate();
            }
        }
    }

    public void copyCitizenTemplate(int citizenTemplateId, int newCitizenTemplateId) throws Exception{
        String sql = "SELECT * FROM GeneralInformationCitizenTemplate WHERE citizenTemplateID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenTemplateId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("generalInformationCitizenTemplateName");
                String explanation = resultSet.getString("generalInformationCitizenTemplateExplanation");
                String editable = resultSet.getString("generalInformationCitizenTemplateEditable");
                createGeneralInfoCitizenTemplate(name, explanation, editable, newCitizenTemplateId);
            }
        }
    }
}
