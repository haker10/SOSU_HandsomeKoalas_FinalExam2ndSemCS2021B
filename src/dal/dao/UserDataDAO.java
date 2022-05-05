package dal.dao;

import be.User;
import dal.DatabaseConnector;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDataDAO {

    DatabaseConnector databaseConnector;


    //constructor
    public UserDataDAO(){
        databaseConnector = new DatabaseConnector();

    }


    public User login(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM UserData WHERE username = ? and password = ?";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int userID = resultSet.getInt("userID");
                int typeOfUser = resultSet.getInt("typeOfUser");
                int school = resultSet.getInt("school");
                String name = resultSet.getString("name");
                user = new User(userID, typeOfUser, school, name, username, password);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public List<User> getAllAdmins() {
        List<User> allAdmins = new ArrayList<>();
        String sql = "SELECT * FROM UserData WHERE typeOfUser = ?";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                int userID = resultSet.getInt("userID");
                int school = resultSet.getInt("school");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(userID, 1, school, name, username, password);
                allAdmins.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return allAdmins;
    }

    public User createAdmin(int schoolId, String name, String username, String password) {
        User admin = null;
        String sql = "INSERT INTO UserData (typeOfUser, school, name, username, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, schoolId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                int userID = resultSet.getInt(1);
                admin = new User(userID, 1, schoolId, name, username, password);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return admin;
    }
}
