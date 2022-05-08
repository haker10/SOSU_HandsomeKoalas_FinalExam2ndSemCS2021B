package gui.controller;

import gui.model.CitizenTemplateModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

public class CreateCitizenTemplateController implements Initializable {

    @FXML
    private Label firstLbl;
    @FXML
    private Label secondLbl;
    @FXML
    private Label thirdLbl;
    @FXML
    private Label fourthLbl;
    @FXML
    private Label fifthLbl;
    @FXML
    private Label sixthLbl;
    @FXML
    private Label seventLbl;
    @FXML
    private Label eightLbl;
    @FXML
    private Label ninethLbl;
    @FXML
    private Label tenthLbl;
    @FXML
    private Label eleventhLbl;
    @FXML
    private Label twelvethLbl;
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

    public void OnClickSave(ActionEvent actionEvent) {

        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        ArrayList<String> functionalAbilitiesInfo = new ArrayList<>();
        functionalAbilitiesInfo.add(sCTxt.getText());
        functionalAbilitiesInfo.add(pTTxt.getText());
        functionalAbilitiesInfo.add(mTxt.getText());
        functionalAbilitiesInfo.add(mFTxt.getText());
        functionalAbilitiesInfo.add(cLTxt.getText());

       ArrayList<Integer> functionalAbilitiesScore = new ArrayList<>();
       functionalAbilitiesScore.add(sCChoicebox.getValue());
       functionalAbilitiesScore.add(pTChoicebox.getValue());
       functionalAbilitiesScore.add(mChoicebox.getValue());
       functionalAbilitiesScore.add(mFChoicebox.getValue());
       functionalAbilitiesScore.add(cLChoicebox.getValue());

       ArrayList<String> functionalAbilitiesName = new ArrayList<>();
        functionalAbilitiesName.add("Self-care");
        functionalAbilitiesName.add("Practical tasks");
        functionalAbilitiesName.add("Mobility");
        functionalAbilitiesName.add("Mental functions");
        functionalAbilitiesName.add("Community life");

       ArrayList<String> generalInfoExplantion = new ArrayList<>();
        generalInfoExplantion.add(masteryTxt.getText());
        generalInfoExplantion.add(motivationTxt.getText());
        generalInfoExplantion.add(resourcesTxt.getText());
        generalInfoExplantion.add(rollerTxt.getText());
        generalInfoExplantion.add(habitsTxt.getText());
        generalInfoExplantion.add(enJTxt.getText());
        generalInfoExplantion.add(lifeStoryTxt.getText());
        generalInfoExplantion.add(networkTxt.getText());
        generalInfoExplantion.add(healthInfoTxt.getText());
        generalInfoExplantion.add(assistiveDevicesTxt.getText());
        generalInfoExplantion.add(interiorOfHomeTxt.getText());

       ArrayList<String> generalInfoName = new ArrayList<>();
        generalInfoName.add("Mastery");
        generalInfoName.add("Motivation");
        generalInfoName.add("Resources");
        generalInfoName.add("Roller");
        generalInfoName.add("Habits");
        generalInfoName.add("Education And Jobs");
        generalInfoName.add("Life Story");
        generalInfoName.add("Network");
        generalInfoName.add("Health Information");
        generalInfoName.add("Assistive Devices");
        generalInfoName.add("The Interior of the Home");






       if(sCChoicebox.getSelectionModel().isEmpty() || pTChoicebox.getSelectionModel().isEmpty() || mChoicebox.getSelectionModel().isEmpty() ||
               mFChoicebox.getSelectionModel().isEmpty() || cLChoicebox.getSelectionModel().isEmpty()){
           JFrame jFrame = new JFrame();
           JOptionPane.showMessageDialog(jFrame, "Please fulfill all score Fields  !!");
       }
       else{
           for (int i = 0; i<generalInfoExplantion.size(); i++){
               citizenTemplateModel.updateGeneralInfoCitizenTemplate(generalInfoName.get(i), generalInfoExplantion.get(i), "null", citizenTemplateId);
           }
           for (int i = 0; i<functionalAbilitiesInfo.size(); i++){
               citizenTemplateModel.updateFunctionalAbitiliesCitizenTemplate(functionalAbilitiesName.get(i), functionalAbilitiesInfo.get(i), functionalAbilitiesScore.get(i), citizenTemplateId);
           }
       }

    }


    public void OnClickfirstComboBox(ActionEvent event) {

        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        if(firstComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
            citizenTemplateModel.updateCitizenTemplate("Function level", "Basic problems related to everyday life", "green", citizenTemplateId);
            firstLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
            firstLbl.setTextFill(Color.WHITE);

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
            if (firstComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                firstLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
            } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                firstLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                firstLbl.setTextFill(Color.WHITE);
            }
        }

    }

    public void OnClicksecondComboBox(ActionEvent event) {
        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        if(secondComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
            citizenTemplateModel.updateCitizenTemplate("Movement device", "Problems related to mobility and movement", "green", citizenTemplateId);
            secondLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
            secondLbl.setTextFill(Color.WHITE);

        }
        else if(secondComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || secondComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
            if (secondComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                secondLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
            } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                secondLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                secondLbl.setTextFill(Color.WHITE);
            }
        }
    }

    public void OnClickthirdComboBox(ActionEvent event) {
        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        if(thirdComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
            citizenTemplateModel.updateCitizenTemplate("Nutrition", "Problems related to food, drink and weight", "green", citizenTemplateId);
            thirdLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
            thirdLbl.setTextFill(Color.WHITE);

        }
        else if(thirdComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || thirdComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
            if (thirdComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                thirdLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
            } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                thirdLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                thirdLbl.setTextFill(Color.WHITE);
            }
        }
    }

    public void OnClickfourthComboBox(ActionEvent event) {
        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        if (fourthComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")) {
            citizenTemplateModel.updateCitizenTemplate("Skin and mucous membranes", "Problems related to skin, flesh wounds, ulcers and mucous", "green", citizenTemplateId);
            fourthLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
            fourthLbl.setTextFill(Color.WHITE);

        } else if (fourthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || fourthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gui/view/subcategoryView.fxml")));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fourthComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                fourthLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
            } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                fourthLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                fourthLbl.setTextFill(Color.WHITE);
            }
        }
    }

    public void OnClickfifthComboBox (ActionEvent event){
            Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
            int citizenTemplateId = (Integer) currentStage.getUserData();

            if (fifthComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")) {
                citizenTemplateModel.updateCitizenTemplate("Communication", "Problems related to speaking, understanding and reading", "green", citizenTemplateId);
                fifthLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
                fifthLbl.setTextFill(Color.WHITE);
            } else if (fifthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || fifthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    //stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();
                    //scene.setFill(Color.TRANSPARENT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fifthComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                    fifthLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
                } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                    fifthLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                    fifthLbl.setTextFill(Color.WHITE);
                }

            }
        }

    public void OnClicksixthComboBox(ActionEvent event) {
            Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
            int citizenTemplateId = (Integer) currentStage.getUserData();

            if(sixthComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
                citizenTemplateModel.updateCitizenTemplate("Psychosocial conditions", "Problems related to emotions, absence of social skills, abuses and mental problems", "green", citizenTemplateId);
                sixthLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
                sixthLbl.setTextFill(Color.WHITE);

            }
            else if(sixthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || sixthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
                if (sixthComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                    sixthLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
                } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                    sixthLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                    sixthLbl.setTextFill(Color.WHITE);
                }
            }
    }

    public void OnClickseventComboBox(ActionEvent event) {
            Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
            int citizenTemplateId = (Integer) currentStage.getUserData();

            if(seventComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
                citizenTemplateModel.updateCitizenTemplate("Respiration and circulation", "Problems related to breathing, the heart and the vascular system", "green", citizenTemplateId);
                seventLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
                seventLbl.setTextFill(Color.WHITE);

            }
            else if(seventComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || seventComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
                if (seventComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                    seventLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
                } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                    seventLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                    seventLbl.setTextFill(Color.WHITE);
                }
            }
    }

    public void OnClickeightComboBox(ActionEvent event) {
        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        if (eightComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")) {
            citizenTemplateModel.updateCitizenTemplate("Sexuality", "Problems related to sexual oragns and its dysfunctions", "green", citizenTemplateId);
            eightLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
            eightLbl.setTextFill(Color.WHITE);
        } else if (eightComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || eightComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/subcategoryView.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                //scene.setFill(Color.TRANSPARENT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (eightComboBox.getSelectionModel().getSelectedItem().equals("Relevant")) {
                eightLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
            } else if (twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")) {
                eightLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                eightLbl.setTextFill(Color.WHITE);
            }
        }
    }

    public void OnClickninethComboBox(ActionEvent event) {
            Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
            int citizenTemplateId = (Integer) currentStage.getUserData();

            if(ninethComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
                citizenTemplateModel.updateCitizenTemplate("Pain and sensory impressions", "Problems related with physical pain and all five senses", "green", citizenTemplateId);
                ninethLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
                ninethLbl.setTextFill(Color.WHITE);
            }
            else if(ninethComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || ninethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
                if(ninethComboBox.getSelectionModel().getSelectedItem().equals("Relevant")){
                    ninethLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
                }
                else if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
                    ninethLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                    ninethLbl.setTextFill(Color.WHITE);
                }
            }

    }

    public  void OnClicktenthComboBox(ActionEvent event) {
            Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
            int citizenTemplateId = (Integer) currentStage.getUserData();

            if(tenthComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
                citizenTemplateModel.updateCitizenTemplate("Sleep and rest", "Problems related to inhability to sleep and so getting rest", "green", citizenTemplateId);
                tenthLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
                tenthLbl.setTextFill(Color.WHITE);
            }
            else if(tenthComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || tenthComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
                if(tenthComboBox.getSelectionModel().getSelectedItem().equals("Relevant")){
                    tenthLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
                }
                else if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
                    tenthLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                    tenthLbl.setTextFill(Color.WHITE);
                }
            }
    }

    public void OnClickeleventhComboBox(ActionEvent event) {
            Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
            int citizenTemplateId = (Integer) currentStage.getUserData();

            if(eleventhComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
                citizenTemplateModel.updateCitizenTemplate("Knowledge and development", "Problems related to memory, perception, knowledge about treatments and cognitive problems", "green", citizenTemplateId);
                eleventhLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
                eleventhLbl.setTextFill(Color.WHITE);

            }
            else if(eleventhComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || eleventhComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
                if(eleventhComboBox.getSelectionModel().getSelectedItem().equals("Relevant")){
                    eleventhLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
                }
                else if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
                    eleventhLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                    eleventhLbl.setTextFill(Color.WHITE);
                }
            }
    }

    public void OnClicktwelvethComboBox(ActionEvent event) {
            Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
            int citizenTemplateId = (Integer) currentStage.getUserData();

            if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
                citizenTemplateModel.updateCitizenTemplate("Separation of waste products", " Problems related to urination, stool incontinence, stomach and intestine", "green", citizenTemplateId);
                twelvethLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
                twelvethLbl.setTextFill(Color.WHITE);

            }
            else if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
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
                if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Relevant")){
                    twelvethLbl.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, new Insets(3))));
                }
                else if(twelvethComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
                    twelvethLbl.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(3))));
                    twelvethLbl.setTextFill(Color.WHITE);
                }
            }
    }


    public void OnClickfirstInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Basic problems related to everyday life !!");

    }

    public void OnClicksecondInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to mobility and movement !!");

    }

    public  void OnClickthirdInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to food, drink and weight !!");

    }

    public  void OnClickfourthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to skin, flesh wounds, ulcers and mucous !!");

    }

    public void OnClickfifthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to speaking, understanding and reading !!");

    }

    public  void OnClicksixthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to emotions, absence of social skills, abuses and mental problems !!");

    }

    public void OnClickseventhInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to breathing, the heart and the vascular system !!");

    }

    public void OnClickeightInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to sexual oragns and its dysfunctions !!");

    }

    public void OnClickninethInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related with physical pain and all five senses !!");

    }

    public void OnClicktenthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to inhability to sleep and so getting rest !!");

    }
    public void OnClickeleventhInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to memory, perception, knowledge about treatments and cognitive problems !!");

    }

    public void OnClicktwelvethInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Problems related to urination, stool incontinence, stomach and intestine  !!");

    }
}

