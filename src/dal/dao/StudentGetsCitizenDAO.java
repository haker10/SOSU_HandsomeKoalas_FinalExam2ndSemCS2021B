package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentGetsCitizenDAO {

    DatabaseConnector databaseConnector;

    public StudentGetsCitizenDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public void assignCitizenToStudent(int studentId, int citizenID) {
        String sql = "INSERT INTO StudentGetsCitizen (studentID, citizenID) VALUES (?, ?)";

        try(Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, citizenID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
