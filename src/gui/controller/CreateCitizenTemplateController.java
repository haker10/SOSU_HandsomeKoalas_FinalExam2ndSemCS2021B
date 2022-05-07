package gui.controller;

import gui.model.CitizenTemplateModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCitizenTemplateController implements Initializable {


    @FXML
    private ChoiceBox<Integer> cLChoicebox;
    @FXML
    private TextField cLTxt;
    @FXML
    private TextField enJTxt;
    @FXML
    private ChoiceBox<Integer> mChoicebox;
    @FXML
    private ChoiceBox<Integer> mFChoicebox;
    @FXML
    private TextField mFTxt;
    @FXML
    private TextField mTxt;
    @FXML
    private ChoiceBox<Integer> pTChoicebox;
    @FXML
    private TextField pTTxt;
    @FXML
    private ChoiceBox<Integer> sCChoicebox;
    @FXML
    private TextField sCTxt;
    @FXML
    private TextField assistiveDevicesTxt;
    @FXML
    private ComboBox<String> eightComboBox;
    @FXML
    private Button eightInfoBtn;
    @FXML
    private ComboBox<String> eleventhComboBox;
    @FXML
    private Button eleventhInfoBtn;
    @FXML
    private ComboBox<String> fifthComboBox;
    @FXML
    private Button fifthInfoBtn;
    @FXML
    private ComboBox<String> firstComboBox;
    @FXML
    private Button firstInfoBtn;
    @FXML
    private ComboBox<String> fourthComboBox;
    @FXML
    private Button fourthInfoBtn;
    @FXML
    private TextField habitsTxt;
    @FXML
    private TextField healthInfoTxt;
    @FXML
    private TextField interiorOfHomeTxt;
    @FXML
    private TextField lifeStoryTxt;
    @FXML
    private TextField masteryTxt;
    @FXML
    private TextField motivationTxt;
    @FXML
    private TextField networkTxt;
    @FXML
    private ComboBox<String> ninethComboBox;
    @FXML
    private Button ninethInfoBtn;
    @FXML
    private TextField resourcesTxt;
    @FXML
    private TextField rollerTxt;
    @FXML
    private ComboBox<String> secondComboBox;
    @FXML
    private Button secondInfoBtn;
    @FXML
    private ComboBox<String> seventComboBox;
    @FXML
    private Button seventhInfoBtn;
    @FXML
    private ComboBox<String> sixthComboBox;
    @FXML
    private Button sixthInfoBtn;
    @FXML
    private ComboBox<String> tenthComboBox;
    @FXML
    private Button tenthInfoBtn;
    @FXML
    private ComboBox<String> thirdComboBox;
    @FXML
    private Button thirdInfoBtn;
    @FXML
    private ComboBox<String> twelvethComboBox;
    @FXML
    private Button twelvethInfoBtn;

    private ObservableList<String> relevance;
    private ObservableList<Integer> score;

    CitizenTemplateModel citizenTemplateModel;


    public CreateCitizenTemplateController(){
        citizenTemplateModel = new CitizenTemplateModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        relevance = FXCollections.observableArrayList("Not Relevant", "Relevant", "Very Relevant");
        firstComboBox.setItems(relevance); secondComboBox.setItems(relevance); thirdComboBox.setItems(relevance);fourthComboBox.setItems(relevance); fifthComboBox.setItems(relevance); sixthComboBox.setItems(relevance);
        seventComboBox.setItems(relevance); eightComboBox.setItems(relevance);ninethComboBox.setItems(relevance); tenthComboBox.setItems(relevance); eleventhComboBox.setItems(relevance); twelvethComboBox.setItems(relevance);

        score = FXCollections.observableArrayList(0, 1, 2, 3, 4);
        sCChoicebox.setItems(score); pTChoicebox.setItems(score); mChoicebox.setItems(score); mFChoicebox.setItems(score); cLChoicebox.setItems(score);

    }
    public void OnClickfirstComboBox(ActionEvent event) {

        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        if(firstComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
            citizenTemplateModel.updateCitizenTemplate("Function level", "Basic problems related to everyday life", "green", citizenTemplateId);

        }
        else if(firstComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || firstComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClicksecondComboBox(ActionEvent event) {
        if(secondComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || secondComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void OnClickthirdComboBox(ActionEvent event) {
        if(thirdComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || thirdComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClickfourthComboBox(ActionEvent event) {
        if(fourthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || fourthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClickfifthComboBox(ActionEvent event) {
        if(fifthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || fifthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClicksixthComboBox(ActionEvent event) {
        if(sixthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || sixthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClickseventComboBox(ActionEvent event) {
        if(seventComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || seventComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClickeightComboBox(ActionEvent event) {
        if(eightComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || eightComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void OnClickninethComboBox(ActionEvent event) {
        if(ninethComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || ninethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    public  void OnClicktenthComboBox(ActionEvent event) {
        if(tenthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || tenthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClickeleventhComboBox(ActionEvent event) {
        if(eleventhComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || eleventhComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void OnClicktwelvethComboBox(ActionEvent event) {
        if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }





    public void OnClickfirstInfoBtn(ActionEvent event) {

    }

    public void OnClickeightInfoBtn(ActionEvent event) {

    }

    public void OnClickeleventhInfoBtn(ActionEvent event) {

    }

    public void OnClickfifthInfoBtn(ActionEvent event) {

    }

    public  void OnClickfourthInfoBtn(ActionEvent event) {

    }

    public void OnClickninethInfoBtn(ActionEvent event) {

    }

    public void OnClicksecondInfoBtn(ActionEvent event) {

    }

    public void OnClickseventhInfoBtn(ActionEvent event) {

    }

    public  void OnClicksixthInfoBtn(ActionEvent event) {

    }

    public void OnClicktenthInfoBtn(ActionEvent event) {

    }

    public  void OnClickthirdInfoBtn(ActionEvent event) {

    }



    public void OnClicktwelvethInfoBtn(ActionEvent event) {

    }

}

