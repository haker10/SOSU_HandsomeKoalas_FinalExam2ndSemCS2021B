package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentGetsCitizenDAO {

    DatabaseConnector databaseConnector;

    public StudentGetsCitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public void assignCitizenToStudent(int studentId, int citizenID) throws Exception{
        String sql = "INSERT INTO StudentGetsCitizen (studentID, citizenID) VALUES (?, ?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, citizenID);
            preparedStatement.executeUpdate();
        }
    }

    public ArrayList<Integer> getAllCitizenId(int studentId) throws Exception{
        ArrayList<Integer> allCitizenId = new ArrayList<>();
        String sql = "SELECT * FROM StudentGetsCitizen WHERE studentID = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,studentId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("citizenID");
                allCitizenId.add(id);
            }
        }
        return allCitizenId;
    }
}
