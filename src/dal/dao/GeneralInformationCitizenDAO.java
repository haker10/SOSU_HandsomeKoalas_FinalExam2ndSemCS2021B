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

    public void copyGeneralInformationCitizen(int citizenId, int citizenTemplateId) {
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
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createGeneralInfoCitizen(String name, String explanation, String editable, int citizenId) {
        String sql = "INSERT INTO GeneralInformationCitizen(generalInformationCitizenName, generalInformationCitizenExplanation, " +
                "generalInformationCitizenEditable, citizenID) VALUES (?, ?, ?, ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,explanation);
            preparedStatement.setString(3, editable);
            preparedStatement.setInt(4, citizenId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
