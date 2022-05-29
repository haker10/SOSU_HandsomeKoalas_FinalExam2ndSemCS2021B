package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GeneralInformationCitizenDAO {

    DatabaseConnector databaseConnector;

    public GeneralInformationCitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public void copyGeneralInformationCitizen(int citizenId, int citizenTemplateId) throws Exception{
        String sql = "SELECT * FROM GeneralInformationCitizenTemplate WHERE citizenTemplateID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenTemplateId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("generalInformationCitizenTemplateName");
                String explanation = resultSet.getString("generalInformationCitizenTemplateExplanation");
                String editable = resultSet.getString("generalInformationCitizenTemplateEditable");
                createGeneralInfoCitizen(name, explanation, editable, citizenId);
            }
        }
    }

    private void createGeneralInfoCitizen(String name, String explanation, String editable, int citizenId) throws Exception{
        String sql = "INSERT INTO GeneralInformationCitizen(generalInformationCitizenName, generalInformationCitizenExplanation, " +
                "generalInformationCitizenEditable, citizenID) VALUES (?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,explanation);
            preparedStatement.setString(3, editable);
            preparedStatement.setInt(4, citizenId);
            preparedStatement.executeUpdate();
        }
    }


    public String getGeneralInfoCitizen(int citizenId, String generalInfoCitizenName) throws Exception{
        String editable = null;
        String sql = "SELECT * FROM GeneralInformationCitizen WHERE citizenID = ? and generalInformationCitizenName = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,citizenId);
            preparedStatement.setString(2,generalInfoCitizenName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                editable = resultSet.getString("generalInformationCitizenEditable");
            }
        }
        return editable;
    }



    public void updateGeneralInfoCitizen(String generalInfoName, String generalInfoEditable, int citizenId) throws Exception{
        String editable = getGeneralInfoCitizen(citizenId, generalInfoName);
        if (editable == null) {
            createGeneralInfoCitizen(generalInfoName, "", generalInfoEditable, citizenId);
        }
        else {
            String sql = "UPDATE GeneralInformationCitizen SET generalInformationCitizenEditable = ? WHERE generalInformationCitizenName = ? and citizenId = ? ";
            try (Connection connection = databaseConnector.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, generalInfoEditable);
                preparedStatement.setString(2, generalInfoName);
                preparedStatement.setInt(3, citizenId);
                preparedStatement.executeUpdate();
            }
        }
    }
}
