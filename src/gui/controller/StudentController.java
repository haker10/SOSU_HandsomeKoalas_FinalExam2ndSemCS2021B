package gui.controller;

import be.Citizen;
import gui.model.CitizenModel;
import gui.model.UserModel;
import gui.view.util.PopUp;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    String infoToEdit;

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
            try {
                schoolLbl.setText(userModel.getSchoolName(schoolId1));
                citizenId = citizenModel.getALlCitizenId(studentId);
            } catch (Exception e) {
                PopUp.showError(e.getMessage());
            }


            for (Integer integer : citizenId) {
                Citizen name = null;
                try {
                    name = citizenModel.getNeededCitizen(integer);
                } catch (Exception e) {
                    PopUp.showError(e.getMessage());
                }
                neededCitizen.add(name);
                allNames.add(name.getCitizenName());
            }
            updateCitizenTableView();
            OnDoubleClickTableViewRow();
            filterStudentTableView();
        });

    }
    public void updateCitizenTableView(){
        citizenNameColumn.setCellValueFactory(new PropertyValueFactory<>("citizenName"));
        try {
            citizenTV.setItems(neededCitizen);
            filterStudentTableView();
        } catch (Exception e){
            PopUp.showError(e.getMessage());
        }
    }

    public void filterStudentTableView() {

        ObservableList<Citizen> citizenList = neededCitizen;
        FilteredList<Citizen> filteredData = null;
        try {
            filteredData = new FilteredList<>(citizenList, b -> true);
        } catch (Exception e) {
            PopUp.showError(e.getMessage());
        }

        FilteredList<Citizen> finalFilteredData = filteredData;
        filterTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            finalFilteredData.setPredicate(citizen -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (citizen.getCitizenName().toLowerCase().contains(lowerCaseFilter))
                    return true;
                else
                    return false;
            });
        });

        SortedList<Citizen> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(citizenTV.comparatorProperty());

        citizenTV.setItems(sortedData);
    }

    public void OnDoubleClickTableViewRow(){
        citizenTV.setRowFactory(tv -> {
            TableRow<Citizen> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    int citizenId = citizenTV.getSelectionModel().getSelectedItem().getCitizenId();
                    infoToEdit = citizenId + "," + schoolLbl.getText();
                    Stage currentStage = (Stage) citizenTV.getScene().getWindow();
                    try{
                        Parent root = FXMLLoader.load(getClass().getResource("/gui/view/studentEditCitizenView.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(scene);
                        stage.setUserData(infoToEdit);
                        stage.show();
                        scene.setFill(Color.TRANSPARENT);
                    }catch (Exception e){
                        PopUp.showError(e.getMessage());
                    }
                }
            });
            return row ;
        });
    }

    public void onClickLogOutBtn(ActionEvent actionEvent) {
        Stage currentStage = (Stage) citizenTV.getScene().getWindow();
        currentStage.close();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/loginView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setUserData(citizenId);
            stage.show();
            scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            PopUp.showError(e.getMessage());
        }
    }

    public void OnClickXBtn(ActionEvent actionEvent) {
        Platform.exit();
    }

}
