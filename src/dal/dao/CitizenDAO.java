package dal.dao;

import be.Citizen;
import dal.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {

    DatabaseConnector databaseConnector;

    public CitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public Citizen createCitizenFromTemplate(int citizenTemplateId, String citizenName) throws Exception{
        Citizen citizen = null;
        String sql = "INSERT INTO Citizen(citizenTemplateID, citizenName) VALUES (?,?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, citizenTemplateId);
            preparedStatement.setString(2, citizenName);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                int citizenID = resultSet.getInt(1);
                citizen = new Citizen(citizenID, citizenTemplateId, citizenName);
            }
        }
        return citizen;
    }

    public List<Citizen> getAllCitizen() throws Exception{
        List<Citizen> allCitizen = new ArrayList<>();
        String sql = "SELECT * FROM Citizen";
        try(Connection connection = databaseConnector.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("citizenID");
                int citizenID = resultSet.getInt("citizenTemplateID");
                String citizenName = resultSet.getString("citizenName");
                Citizen citizen = new Citizen(id, citizenID, citizenName);
                allCitizen.add(citizen);
            }
        }
        return  allCitizen;
    }

    public Citizen getNeededCitizen(int citizenId) throws Exception{
        String sql = "Select * FROM Citizen WHERE citizenID = ?";
        Citizen citizen = null;
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                int citizenTemplateId = resultSet.getInt("citizenTemplateID");
                String  name = resultSet.getString("citizenName");
                citizen = new Citizen(citizenId, citizenTemplateId, name);
            }
        }
        return citizen;
    }

    public String getCitizenName(int citizenId) throws Exception{
        String citizenName = null;
        String sql = "SELECT * FROM Citizen WHERE citizenID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, citizenId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                citizenName = resultSet.getString("citizenName");
            }
        }
        return  citizenName;
    }
}
