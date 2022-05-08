package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class RelevantController implements Initializable {

    @FXML
    private Label categoryLbl;
    @FXML
    private TextArea profesionalNoteTxt;
    @FXML
    private Label subCategoryLbl;


    public RelevantController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void OnClickSave(ActionEvent event) {

    }
}
