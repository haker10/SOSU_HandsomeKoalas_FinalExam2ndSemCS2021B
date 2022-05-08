package gui.controller;

import gui.model.CitizenTemplateModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    String hc_category1 = "Function level";
    String hc_subcategory1_1 = "Problems with personal care";
    String hc_subcategory1_2 = "Problems with daily activities";

    private ObservableList<String> hc_subcategory1_list = FXCollections.observableArrayList(hc_subcategory1_1, hc_subcategory1_2);

    String hc_category2 = "Movement device";
    String hc_subcategory2_1 = "Problems with mobility and movement";

    private ObservableList<String> hc_subcategory2_list = FXCollections.observableArrayList(hc_subcategory2_1);

    String hc_category3 = "Nutrition";
    String hc_subcategory3_1 = "Problems with fluid intake";
    String hc_subcategory3_2 = "Problems with food intake";
    String hc_subcategory3_3 = "Inappropriate weight change";
    String hc_subcategory3_4 = "Problems with obesity";
    String hc_subcategory3_5 = "Problems with underweight";

    private ObservableList<String> hc_subcategory3_list = FXCollections.observableArrayList(hc_subcategory3_1, hc_subcategory3_2, hc_subcategory3_3, hc_subcategory3_4, hc_subcategory3_5);

    String hc_category4 = "Skin and mucous membranes";
    String hc_subcategory4_1 = "Problems with surgical wounds";
    String hc_subcategory4_2 = "Problems with diabetic ulcers";
    String hc_subcategory4_3 = "Problems with cancerous lesions";
    String hc_subcategory4_4 = "Problems with pressure ulcers";
    String hc_subcategory4_5 = "Problems with arterial ulcer";
    String hc_subcategory4_6 = "Problems with venous ulcer";
    String hc_subcategory4_7 = "Problems with mixed wounds";
    String hc_subcategory4_8 = "Problems with trauma wounds";
    String hc_subcategory4_9 = "Other skin and mucous membrane problems";

    private ObservableList<String> hc_subcategory4_list = FXCollections.observableArrayList(hc_subcategory4_1, hc_subcategory4_2, hc_subcategory4_3, hc_subcategory4_4, hc_subcategory4_5, hc_subcategory4_6, hc_subcategory4_7, hc_subcategory4_8, hc_subcategory4_9);

    String hc_category5 = "Communication";
    String hc_subcategory5_1 = "Problems with communication";

    private ObservableList<String> hc_subcategory5_list = FXCollections.observableArrayList(hc_subcategory5_1);

    String hc_category6 = "Psychosocial conditions";
    String hc_subcategory6_1 = "Problems with socializing";
    String hc_subcategory6_2 = "Emotional problems";
    String hc_subcategory6_3 = "Problems with abuse";
    String hc_subcategory6_4 = "Mental problems";

    private ObservableList<String> hc_subcategory6_list = FXCollections.observableArrayList(hc_subcategory6_1, hc_subcategory6_2, hc_subcategory6_3, hc_subcategory6_4);

    String hc_category7 = "Respiration and circulation";
    String hc_subcategory7_1 = "Respiratory problems";
    String hc_subcategory7_2 = "Circulatory problems";

    private ObservableList<String> hc_subcategory7_list = FXCollections.observableArrayList(hc_subcategory7_1, hc_subcategory7_2);

    String hc_category8 = "Sexuality";
    String hc_subcategory8_1 = "Problems with sexuality";

    private ObservableList<String> hc_subcategory8_list = FXCollections.observableArrayList(hc_subcategory8_1);

    String hc_category9 = "Pain and sensory impressions";
    String hc_subcategory9_1 = "Acute pain";
    String hc_subcategory9_2 = "Periodic pain";
    String hc_subcategory9_3 = "Chronic pain";
    String hc_subcategory9_4 = "Problems with the sense of sight";
    String hc_subcategory9_5 = "Problems with the sense of smell";
    String hc_subcategory9_6 = "Hearing problems";
    String hc_subcategory9_7 = "Problems with the sense of taste";
    String hc_subcategory9_8 = "Problems with the sense of touch";

    private ObservableList<String> hc_subcategory9_list = FXCollections.observableArrayList(hc_subcategory9_1, hc_subcategory9_2, hc_subcategory9_3, hc_subcategory9_4, hc_subcategory9_5, hc_subcategory9_6, hc_subcategory9_7, hc_subcategory9_8);

    String hc_category10 = "Sleep and rest";
    String hc_subcategory10_1 = "Circadian rhythm problems";
    String hc_subcategory10_2 = "Sleep problems";

    private ObservableList<String> hc_subcategory10_list = FXCollections.observableArrayList(hc_subcategory10_1, hc_subcategory10_2);

    String hc_category11 = "Knowledge and development";
    String hc_subcategory11_1 = "Memory problems";
    String hc_subcategory11_2 = "Problems with disease insight";
    String hc_subcategory11_3 = "Problems with insight into treatment purposes";
    String hc_subcategory11_4 = "Cognitive problems";

    private ObservableList<String> hc_subcategory11_list = FXCollections.observableArrayList(hc_subcategory11_1, hc_subcategory11_2, hc_subcategory11_3, hc_subcategory11_4);

    String hc_category12 = "Separation of waste products";
    String hc_subcategory12_1 = "Problems with urination";
    String hc_subcategory12_2 = "Problems with urinary incontinence";
    String hc_subcategory12_3 = "Problems with stool incontinence";
    String hc_subcategory12_4 = "Stomach and intestinal problems";

    private ObservableList<String> hc_subcategory12_list = FXCollections.observableArrayList(hc_subcategory12_1, hc_subcategory12_2, hc_subcategory12_3, hc_subcategory12_4);

    private ObservableList<String> hc_category_list = FXCollections.observableArrayList(hc_category1, hc_category2, hc_category3, hc_category4, hc_category5, hc_category6, hc_category7, hc_category8, hc_category9, hc_category10, hc_category11, hc_category12);

    String fa_category1 = "Self-care";
    String fa_subcategory1_1 = "Wash";
    String fa_subcategory1_2 = "Go to the bathroom";
    String fa_subcategory1_3 = "Body care";
    String fa_subcategory1_4 = "Undressing and dressing";
    String fa_subcategory1_5 = "Eat";
    String fa_subcategory1_6 = "Drinking";
    String fa_subcategory1_7 = "Take care of your own health";
    String fa_subcategory1_8 = "Food intake";

    private ObservableList<String> fa_subcategory1_list = FXCollections.observableArrayList(fa_subcategory1_1, fa_subcategory1_2, fa_subcategory1_3, fa_subcategory1_4, fa_subcategory1_5, fa_subcategory1_6, fa_subcategory1_7, fa_subcategory1_8);

    String fa_category2 = "Practical tasks";
    String fa_subcategory2_1 = "Perform daily routines";
    String fa_subcategory2_2 = "Acquire goods and services";
    String fa_subcategory2_3 = "Cook";
    String fa_subcategory2_4 = "Do housework";

    private ObservableList<String> fa_subcategory2_list = FXCollections.observableArrayList(fa_subcategory2_1, fa_subcategory2_2, fa_subcategory2_3, fa_subcategory2_4);

    String fa_category3 = "Mobility";
    String fa_subcategory3_1 = "Change body position";
    String fa_subcategory3_2 = "Move";
    String fa_subcategory3_3 = "Lift and carry";
    String fa_subcategory3_4 = "Go";
    String fa_subcategory3_5 = "Move around";
    String fa_subcategory3_6 = "The journey in different surroundings";
    String fa_subcategory3_7 = "Use means of transport";
    String fa_subcategory3_8 = "Endurance";
    String fa_subcategory3_9 = "Muscle Strenght";

    private ObservableList<String> fa_subcategory3_list = FXCollections.observableArrayList(fa_subcategory3_1, fa_subcategory3_2, fa_subcategory3_3, fa_subcategory3_4, fa_subcategory3_5, fa_subcategory3_6, fa_subcategory3_7, fa_subcategory3_8, fa_subcategory3_9);

    String fa_category4 = "Mental functions";
    String fa_subcategories4_1 = "Acquire skills";
    String fa_subcategories4_2 = "Problem solving";
    String fa_subcategories4_3 = "Apply communication equipment and techniques";
    String fa_subcategories4_4 = "Orientation ability";
    String fa_subcategories4_5 = "Energy and action";
    String fa_subcategories4_6 = "Memory";
    String fa_subcategories4_7 = "Emotional functions";
    String fa_subcategories4_8 = "Overall cognitives functions";

    private ObservableList<String> fa_subcategories4_list = FXCollections.observableArrayList(fa_subcategories4_1, fa_subcategories4_2, fa_subcategories4_3, fa_subcategories4_4, fa_subcategories4_5, fa_subcategories4_6, fa_subcategories4_7, fa_subcategories4_8);

    String fa_category5 = "Community life";
    String fa_subcategories5_1 = "Have paid employment";

    private ObservableList<String> fa_subcategories5_list = FXCollections.observableArrayList(fa_subcategories5_1);

    private ObservableList<String> fa_category_list = FXCollections.observableArrayList(fa_category1, fa_category2, fa_category3, fa_category4, fa_category5);


    private ObservableList<String> hc_relevance = FXCollections.observableArrayList("Not relevant", "Relevant", "Very relevant");
    private ObservableList<Integer> score = FXCollections.observableArrayList(0, 1, 2, 3, 4);
    private ObservableList<String> fa_performance = FXCollections.observableArrayList("Self performed", "Self performed partly", "Does not perform itself", "Not relevant");
    private ObservableList<String> fa_meaning_of_performance = FXCollections.observableArrayList("Does not experience limitations", "Experience limitations");

    CitizenTemplateModel citizenTemplateModel;

    public CreateCitizenTemplateController(){
        citizenTemplateModel = new CitizenTemplateModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fACategoryComboBox.setItems(fa_category_list);
        presentLevelComboBox.setItems(score);
        expectedLevelComboBox.setItems(score);
        performanceComboBox.setItems(fa_performance);
        meaningOfPerformanceComboBox.setItems(fa_meaning_of_performance);
        hCCategoryComboBox.setItems(hc_category_list);
        relevanceComboBox.setItems(hc_relevance);
    }

    // Functional Abilities

    public void OnClickFACategory(ActionEvent event) {
        if(fACategoryComboBox.getValue() != null) {
            String selectedCategory = fACategoryComboBox.getSelectionModel().getSelectedItem();
            if (selectedCategory.equals(fa_category1)) {
                faSubCategoryComboBox.setItems(fa_subcategory1_list);
            } else if (selectedCategory.equals(fa_category2)) {
                faSubCategoryComboBox.setItems(fa_subcategory2_list);
            } else if (selectedCategory.equals(fa_category3)) {
                faSubCategoryComboBox.setItems(fa_subcategory3_list);
            } else if (selectedCategory.equals(fa_category4)) {
                faSubCategoryComboBox.setItems(fa_subcategories4_list);
            } else if (selectedCategory.equals(fa_category5)) {
                faSubCategoryComboBox.setItems(fa_subcategories5_list);
            } else {
                faSubCategoryComboBox.setItems(null);
            }
        }
    }

    public void OnClickSaveFunctionalAbilities(ActionEvent event) {
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenTemplateId = (Integer) currentStage.getUserData();

        JFrame frame = new JFrame();
        if (fACategoryComboBox.getValue() == null || faSubCategoryComboBox.getValue() == null || performanceComboBox.getValue() == null || meaningOfPerformanceComboBox.getValue() == null || presentLevelComboBox.getValue() == null || expectedLevelComboBox.getValue() == null) {
            JOptionPane.showMessageDialog(frame, "Please fulfill all fields");
        }
        else {
            String selectedCategory = fACategoryComboBox.getSelectionModel().getSelectedItem();
            String selectedSubCategory = faSubCategoryComboBox.getSelectionModel().getSelectedItem();
            int selectedPresentLevel = presentLevelComboBox.getSelectionModel().getSelectedIndex();
            int selectedExpectedLevel = expectedLevelComboBox.getSelectionModel().getSelectedIndex();
            String professionalNote = fAProfNoteTxt.getText();
            String selectedPerformance = performanceComboBox.getSelectionModel().getSelectedItem();
            String selectedMeaningOfPerformance = meaningOfPerformanceComboBox.getSelectionModel().getSelectedItem();
            String wishesNGoals = wishesNGoalsTxt.getText();
            String observationNote = observationNoteTxt.getText();
            LocalDate date = fADatePicker.getValue();
            citizenTemplateModel.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateId);
            fACategoryComboBox.getSelectionModel().clearSelection();
            faSubCategoryComboBox.getSelectionModel().clearSelection();
            presentLevelComboBox.getSelectionModel().clearSelection();
            expectedLevelComboBox.getSelectionModel().clearSelection();
            fAProfNoteTxt.clear();
            performanceComboBox.getSelectionModel().clearSelection();
            meaningOfPerformanceComboBox.getSelectionModel().clearSelection();
            wishesNGoalsTxt.clear();
            observationNoteTxt.clear();
            fADatePicker.setValue(LocalDate.now());
            //fADatePicker.setValue(null);
            JOptionPane.showMessageDialog(frame, "Saved");
        }

    }

    // Health Conditions

    public void OnClickHCCategory(ActionEvent event) {

    }

    public void OnClickRelevance(ActionEvent event) {

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

    // General Information

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

