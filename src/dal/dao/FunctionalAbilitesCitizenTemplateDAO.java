package dal.dao;

import dal.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FunctionalAbilitesCitizenTemplateDAO {

    DatabaseConnector databaseConnector;

   public FunctionalAbilitesCitizenTemplateDAO(){
       databaseConnector = new DatabaseConnector();
   }


    public void updateFunctionalAbilitiesCitizenTemplate(String functionalAbilitesName, String functionalAbilitesInfo, int functionalAbilitesScore, int citizenTemplateId) {

        String sql = "INSERT INTO FunctionalAbilitiesCitizenTemplate(functionalAbilitiesCitizenTemplateName, functionalAbilitiesCitizenTemplateInformation, functionalAbilitiesCitizenTemplateScore, citizenTemplateID) VALUES (?, ?, ?, ?)";
        try(
                Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, functionalAbilitesName);
            preparedStatement.setString(2,functionalAbilitesInfo);
            preparedStatement.setInt(3, functionalAbilitesScore);
            preparedStatement.setInt(4, citizenTemplateId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
