package dal.dao;

import be.CitizenTemplate;
import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CitizenTemplateDAO {
    DatabaseConnector databaseConnector;

    public CitizenTemplateDAO(){
        databaseConnector = new DatabaseConnector();
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
