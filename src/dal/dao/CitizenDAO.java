package dal.dao;

import be.Citizen;
import be.CitizenTemplate;
import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
}
