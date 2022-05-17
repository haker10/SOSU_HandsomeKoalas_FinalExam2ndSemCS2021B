package dal.dao;

import be.User;
import dal.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDataDAO {

    DatabaseConnector databaseConnector;

    //constructor
    public UserDataDAO() {
        databaseConnector = new DatabaseConnector();

    }



    //users
    public User login(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM UserData WHERE username = ? and password = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                int typeOfUser = resultSet.getInt("typeOfUser");
                int school = resultSet.getInt("school");
                String name = resultSet.getString("name");
                user = new User(userID, typeOfUser, school, name, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM UserData WHERE userID = ?";

        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editUser(int userId, String name, String username, String password) {
        String sql = "UPDATE UserData SET name = ?, username = ?, password = ? WHERE userID = ?";

        try(Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, userId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsernames() {
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM UserData";
        try(Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                int typeOfUser = resultSet.getInt("typeOfUser");
                int school = resultSet.getInt("school");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(userID, typeOfUser, school, name, username, password);
                allUsers.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }



    //admins
    public void createAdmin(int schoolId, String name, String username, String password) {
        String sql = "INSERT INTO UserData (typeOfUser, school, name, username, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, schoolId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllAdmins() {
        List<User> allAdmins = new ArrayList<>();
        String sql = "SELECT * FROM UserData WHERE typeOfUser = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                int school = resultSet.getInt("school");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(userID, 1, school, name, username, password);
                allAdmins.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allAdmins;
    }



    //teachers
    public void createTeacher(Integer school, String name, String username, String password) {
        String sql = "INSERT INTO UserData(typeOfUser, school, name, username, password) VALUES(2,?,?,?,?)";

        try(Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, school);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllTeachers(int schoolId) {
        List<User> allTeachers = new ArrayList<>();
        String sql = "SELECT * FROM UserData WHERE typeOfUser = 2 AND school = ?";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, schoolId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                int userId = resultSet.getInt("userID");
                int typeOfUser = resultSet.getInt("typeOfUser");
                int school = resultSet.getInt("school");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User teacher = new User(userId, typeOfUser, school, name, username, password);
                allTeachers.add(teacher);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allTeachers;
    }



    //students
    public User createStudent ( int schoolId, String name, String username, String password) {
        User student = null;
        String sql = "INSERT INTO UserData (typeOfUser, school, name, username, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, schoolId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                int userID = resultSet.getInt(1);
                student = new User(userID, 3, schoolId, name, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<User> getAllStudents(int schoolId) {
        List<User> allStudents = new ArrayList<>();
        String sql = "SELECT * FROM UserData WHERE typeOfUser = ? AND school = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, schoolId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                int school = resultSet.getInt("school");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(userID, 3, school, name, username, password);
                allStudents.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allStudents;
    }

}
