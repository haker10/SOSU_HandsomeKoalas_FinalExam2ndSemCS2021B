package dal.dao;

import be.School;
import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentGetsCitizenDAO {

    DatabaseConnector databaseConnector;

    public StudentGetsCitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public void assignCitizenToStudent(int studentId, int citizenID) {
        String sql = "INSERT INTO StudentGetsCitizen (studentID, citizenID) VALUES (?, ?)";

        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, citizenID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getAllCitizenId(int studentId) {
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
        }catch (Exception e) {
            e.printStackTrace();
        }

        return allCitizenId;

    }
}
