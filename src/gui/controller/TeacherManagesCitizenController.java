package gui.controller;

import be.Citizen;
import be.CitizenTemplate;
import be.User;
import gui.model.CitizenModel;
import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherManagesCitizenController implements Initializable {


    @FXML
    private TableColumn<CitizenTemplate, Integer> citizenTemplateIDColumn;
    @FXML
    private TableColumn<Citizen, Integer> citizenIDColumn;
    @FXML
    private TableView<User> studentTv;
    @FXML
    private TableColumn<User, Integer> studentIDColumn;
    @FXML
    private TableColumn<User, String> studentNameColumn;
    @FXML
    private TableView<Citizen> citizenTV;

    CitizenModel citizenModel;

    UserModel userModel;


    public TeacherManagesCitizenController() {
        citizenModel = new CitizenModel();
        userModel = new UserModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateCitizenTemplateTV();

    }

    public void updateCitizenTemplateTV() {
        citizenTemplateIDColumn.setCellValueFactory(new PropertyValueFactory<>("citizenTemplateId"));
        citizenIDColumn.setCellValueFactory(new PropertyValueFactory<>("citizenId"));
        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        try {
            citizenTV.setItems(citizenModel.getAllCitizen());
            studentTv.setItems(userModel.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void onClickAssign(ActionEvent actionEvent) {
        JFrame frame = new JFrame();
        if(citizenTV.getSelectionModel().getSelectedItem() == null || studentTv.getSelectionModel().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(frame, "Please select both parties");
        }
        else {
            int studentId = studentTv.getSelectionModel().getSelectedItem().getUserId();
            int citizenID = citizenTV.getSelectionModel().getSelectedItem().getCitizenId();
            userModel.assignCitizenToStudent(studentId, citizenID);
            JOptionPane.showMessageDialog(frame, "Citizen assigned to student");
        }
    }
}

