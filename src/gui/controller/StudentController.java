package gui.controller;

import be.Citizen;
import gui.model.CitizenModel;
import gui.model.UserModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private TableColumn<Citizen, String> citizenNameColumn;
    @FXML
    private TextField filterTxt;
    @FXML
    private TableView<Citizen> citizenTV;
    @FXML
    private Label schoolLbl;

    ArrayList<Integer> citizenId;
    ObservableList<Citizen> neededCitizen;
    UserModel userModel;
    CitizenModel citizenModel;
    ObservableList<String> allNames;

    String info;

    public StudentController() {
          userModel = new UserModel();
          citizenModel = new CitizenModel();
          neededCitizen = FXCollections.observableArrayList();
          allNames = FXCollections.observableArrayList();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            Stage currentStage = (Stage) schoolLbl.getScene().getWindow();
            info = (String) currentStage.getUserData();
            String[] splitter = info.split(",");
            int schoolId1 = Integer.parseInt(splitter[0]);
            int studentId = Integer.parseInt(splitter[1]);
            schoolLbl.setText(userModel.getSchoolName(schoolId1));
            citizenId = citizenModel.getALlCitizenId(studentId);

            for (int i = 0; i<citizenId.size(); i++){
                Citizen name = citizenModel.getNeededCitizen(citizenId.get(i));
                neededCitizen.add(name);
                allNames.add(name.getCitizenName());
            }
            updateCitizenTableView();
        });

    }
    public void updateCitizenTableView(){
        citizenNameColumn.setCellValueFactory(new PropertyValueFactory<>("citizenName"));
        try {
            citizenTV.setItems(neededCitizen);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void OnClickOpenView(ActionEvent actionEvent) {
        int citizenId = citizenTV.getSelectionModel().getSelectedItem().getCitizenId();
        Stage currentStage = (Stage) citizenTV.getScene().getWindow();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/studentEditCitizenView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setUserData(citizenId);
            stage.show();
            scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
