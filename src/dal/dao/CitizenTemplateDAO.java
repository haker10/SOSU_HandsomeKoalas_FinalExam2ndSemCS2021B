package dal.dao;

import be.CitizenTemplate;
import be.User;
import dal.DatabaseConnector;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CitizenTemplateDAO {
    DatabaseConnector databaseConnector;

    public CitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public List<CitizenTemplate> getALlCitizenTemplates() {
        List<CitizenTemplate> allCitizenTemplates = new ArrayList<>();
        String sql = "SELECT * FROM CitizenTemplate";

        try(Connection connection = databaseConnector.getConnection()){
        Statement statement = connection.createStatement();
        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("citizenTemplateID");
            int school = resultSet.getInt("school");
            CitizenTemplate citizenTemplate = new CitizenTemplate(id, school);
            allCitizenTemplates.add(citizenTemplate);
        }
       } catch(SQLException throwables) {
            throwables.printStackTrace();
       }
          return  allCitizenTemplates;
    }

    public CitizenTemplate createCitizenTemplate(int schoolId1) {
        CitizenTemplate citizenTemplate = null;

        String sql = "INSERT INTO CitizenTemplate(school) VALUES (?)";
        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, schoolId1);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                int Id = resultSet.getInt(1);
                citizenTemplate = new CitizenTemplate(Id, schoolId1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return citizenTemplate;
    }
}
