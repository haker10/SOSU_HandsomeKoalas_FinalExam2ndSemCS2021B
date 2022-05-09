package dal.dao;

import be.Citizen;
import be.CitizenTemplate;
import dal.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {

    DatabaseConnector databaseConnector;

    public CitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }
    public Citizen createCitizenFromTemplate(int citizenTemplateId) {
        Citizen citizen = null;

        String sql = "INSERT INTO Citizen(citizenTemplateID) VALUES (?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, citizenTemplateId);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                int citizenID = resultSet.getInt(1);
                citizen = new Citizen(citizenID, citizenTemplateId);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return citizen;
    }

    public List<Citizen> getAllCitizen() {
        List<Citizen> allCitizen = new ArrayList<>();
        String sql = "SELECT * FROM Citizen";

        try(Connection connection = databaseConnector.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("citizenID");
                int citizenID = resultSet.getInt("citizenTemplateID");
                Citizen citizen = new Citizen(id, citizenID);
                allCitizen.add(citizen);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return  allCitizen;
    }
}
