package dal.dao;

import be.School;
import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {

    DatabaseConnector databaseConnector;

    public SchoolDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public List<School> getAllSchools() {
        List<School> allSchools = new ArrayList<>();
        String sql = "SELECT * FROM School";
        try(Connection connection = databaseConnector.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next()){
                int id = resultSet.getInt("schoolID");
                String school = resultSet.getString("school");
                School newSchool = new School(id, school);
                allSchools.add(newSchool);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allSchools;
    }

    public School createNewSchool(String school) {
        School newSchool = null;
        String sql = "INSERT INTO School (school) VALUES (?)";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, school);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                newSchool = new School(id, school);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newSchool;
    }

    public String getSchoolName(int schoolId1) {
        String schoolName = null;
        String sql = "SELECT school FROM School WHERE schoolID = ?";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, schoolId1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                schoolName = resultSet.getString("school");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   return schoolName;
    }

    public List<School> getAllSchoolsNotAssigned() {
        List<School> allSchoolsNotAssigned = new ArrayList();
        String sql = "SELECT * FROM School WHERE schoolID NOT IN (SELECT school FROM UserData WHERE typeOfUser = ?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("schoolID");
                String school = resultSet.getString("school");
                School newSchool = new School(id, school);
                allSchoolsNotAssigned.add(newSchool);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  return allSchoolsNotAssigned;
    }
}

