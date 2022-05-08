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
    private TextArea enJTxt;
    @FXML
    private TextArea assistiveDevicesTxt;
    @FXML
    private TextArea habitsTxt;
    @FXML
    private TextArea healthInfoTxt;
    @FXML
    private TextArea interiorOfHomeTxt;
    @FXML
    private TextArea lifeStoryTxt;
    @FXML
    private TextArea masteryTxt;
    @FXML
    private TextArea motivationTxt;
    @FXML
    private TextArea networkTxt;
    @FXML
    private TextArea resourcesTxt;
    @FXML
    private TextArea rollerTxt;

    @FXML
    private ComboBox<String> fACategoryComboBox;
    @FXML
    private ComboBox<String> faSubCategoryComboBox;
    @FXML
    private ComboBox<Integer> presentLevelComboBox;
    @FXML
    private ComboBox<Integer> expectedLevelComboBox;
    @FXML
    private TextArea fAProfNoteTxt;
    @FXML
    private ComboBox<String> performanceComboBox;
    @FXML
    private ComboBox<String> meaningOfPerformanceComboBox;
    @FXML
    private TextArea wishesNGoalsTxt;
    @FXML
    private TextArea observationNoteTxt;
    @FXML
    private DatePicker fADatePicker;

    @FXML
    private ComboBox<String> hCCategoryComboBox;
    @FXML
    private ComboBox<String> hCSubCategoryComboBox;
    @FXML
    private ComboBox<String> relevanceComboBox;


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



    public void OnClickFACategory(ActionEvent event) {

    }

    public void OnClickHCCategory(ActionEvent event) {

    }

    public void OnClickRelevance(ActionEvent event) {

    }

    public void OnClickSaveFunctionalAbilities(ActionEvent event) {

    }




    /*public void OnClickfirstComboBox(ActionEvent event) {

        Stage currentStage = (Stage) cLChoicebox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        if(firstComboBox.getSelectionModel().getSelectedItem().equals("Not Relevant")){
            citizenTemplateModel.updateCitizenTemplate("Function level", "Basic problems related to everyday life", "green", citizenTemplateId);
            firstLbl.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
            firstLbl.setTextFill(Color.WHITE);

        }
        else if(firstComboBox.getSelectionModel().getSelectedItem().equals("Relevant") || firstComboBox.getSelectionModel().getSelectedItem().equals("Very Relevant")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gui/view/relevantView.fxml")));
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
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
                    Parent root = FXMLLoader.load(getClass().getResource("/gui/view/relevantView.fxml"));
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
    } */


    public void OnClickSaveGeneralInfo(ActionEvent actionEvent) {

        Stage currentStage = (Stage) masteryTxt.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();
        
        ArrayList<String> generalInfoExplanation = new ArrayList<>();{
        generalInfoExplanation.add("The citizen's conscious or unconscious handling of life / illness - both challenges and opportunities.");
        generalInfoExplanation.add("The driving force behind the citizen acting in a certain way or embarking on / maintaining a task / effort.");
        generalInfoExplanation.add("The physical or mental forces that the citizen has to a certain extent available and can utilize Physical forces can, for example, be in the\n" +
                "form of physical health and strength. Mental forces can, for example, be in the form of mental health and strength, including thoughts and ways of relating to situations and other people.");
        generalInfoExplanation.add("The roles that are particularly important for the citizen in relation to family, work and society.");
        generalInfoExplanation.add("Regular behavior that the citizen has learned through constant repetition and execution completely or partially unconsciously. Habits are, for example, the circadian rhythm, the way to be addressed, contact with fellow human beings and relationships, the way of looking at the world.");
        generalInfoExplanation.add("Current or previous educational and / or professional background. For example, primary school, vocational education and higher education.");
        generalInfoExplanation.add("A description of the citizen's experience of significant events, interests and chores throughout life.");
        generalInfoExplanation.add("Persons who are close to the citizen and who provide practical and / or emotional support and care for the citizen. Networks can be public or private. A public network consists of personal helpers, health professionals and other professionals primarily caregivers. Private networks are family, relatives, friends and acquaintances.");
        generalInfoExplanation.add("Health information");
        generalInfoExplanation.add("Equipment, products and technology used by the citizen in daily activities, incl. those adapted or specially made for, implanted in, located on or near the person using them. (Including general items and aids and technology for personal use)");
        generalInfoExplanation.add("A description of the home's physical" +
                "framework and surroundings that are important" +
                "for the citizen's everyday life and ability to function.");}

        ArrayList<String> generalInfoEditable = new ArrayList<>();{
        generalInfoEditable.add(masteryTxt.getText());
        generalInfoEditable.add(motivationTxt.getText());
        generalInfoEditable.add(resourcesTxt.getText());
        generalInfoEditable.add(rollerTxt.getText());
        generalInfoEditable.add(habitsTxt.getText());
        generalInfoEditable.add(enJTxt.getText());
        generalInfoEditable.add(lifeStoryTxt.getText());
        generalInfoEditable.add(networkTxt.getText());
        generalInfoEditable.add(healthInfoTxt.getText());
        generalInfoEditable.add(assistiveDevicesTxt.getText());
        generalInfoEditable.add(interiorOfHomeTxt.getText());}

        ArrayList<String> generalInfoName = new ArrayList<>();{
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
        generalInfoName.add("The Interior of the Home");}

        for (int i = 0; i<generalInfoEditable.size(); i++){
            citizenTemplateModel.updateGeneralInfoCitizenTemplate(generalInfoName.get(i), generalInfoExplanation.get(i), generalInfoEditable.get(i), citizenTemplateId);
        }

    }

    public void OnClickfirstInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The citizen's conscious or unconscious handling of life / illness - both challenges and opportunities. !!");
    }

    public void OnClicksecondInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The driving force behind the citizen acting in a certain way or embarking on / maintaining a task / effort. !!");
    }

    public  void OnClickthirdInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The physical or mental forces that the citizen has to a certain extent available and can utilize Physical forces can, for example, be in the " +
                "form of physical health and strength. Mental forces can, for example, be in the form of mental health and strength, including thoughts and ways of relating to situations and other people. !!");
    }

    public  void OnClickfourthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The roles that are particularly important for the citizen in relation to family, work and society. !!");
    }

    public void OnClickfifthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Regular behavior that the citizen has learned through constant repetition and execution completely or partially unconsciously. Habits are, for example, the circadian rhythm, the way to be addressed, contact with fellow human beings and relationships, the way of looking at the world.  !!");
    }

    public  void OnClicksixthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Current or previous educational and / or professional background. For example, primary school, vocational education and higher education. !!");
    }

    public void OnClickseventhInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "A description of the citizen's experience of significant events, interests and chores throughout life. !!");
    }

    public void OnClickeightInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Persons who are close to the citizen and who provide practical and / or emotional support and care for the citizen. Networks can be public or private. A public network consists of personal helpers, health professionals and other professionals primarily caregivers. Private networks are family, relatives, friends and acquaintances. !!");
    }

    public void OnClickninethInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Health information !!");
    }

    public void OnClicktenthInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Equipment, products and technology used by the citizen in daily activities, incl. those adapted or specially made for, implanted in, located on or near the person using them. (Including general items and aids and technology for personal use) !!");
    }
    public void OnClickeleventhInfoBtn(ActionEvent event) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "A description of the home's physical framework and surroundings that are important for the citizen's everyday life and ability to function. !!");
    }
}

