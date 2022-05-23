package dal.dao;

import be.CitizenTemplate;
import dal.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenTemplateDAO {
    DatabaseConnector databaseConnector;

    public CitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public List<CitizenTemplate> getALlCitizenTemplates(int schoolId) {
        List<CitizenTemplate> allCitizenTemplates = new ArrayList<>();
        String sql = "SELECT * FROM CitizenTemplate WHERE school = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, schoolId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("citizenTemplateID");
                String citizenTemplateName = resultSet.getString("citizenTemplateName");
                CitizenTemplate citizenTemplate = new CitizenTemplate(id, schoolId, citizenTemplateName);
                allCitizenTemplates.add(citizenTemplate);
            }
       } catch(SQLException throwables) {
            throwables.printStackTrace();
       }
          return  allCitizenTemplates;
    }

    public CitizenTemplate createCitizenTemplate(int schoolId1, String citizenTemplateName) {
        CitizenTemplate citizenTemplate = null;
        String sql = "INSERT INTO CitizenTemplate(school, citizenTemplateName) VALUES (?,?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, schoolId1);
            preparedStatement.setString(2, citizenTemplateName);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                int Id = resultSet.getInt(1);
                citizenTemplate = new CitizenTemplate(Id, schoolId1, citizenTemplateName);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return citizenTemplate;
    }

    public void deleteCitizenTemplate(int citizenTemplateId) {
        String sql = "DELETE FROM CitizenTemplate WHERE citizenTemplateID = ?";
        try(Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenTemplateId);
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
