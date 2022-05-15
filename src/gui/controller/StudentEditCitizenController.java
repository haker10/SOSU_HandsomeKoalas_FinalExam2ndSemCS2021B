package gui.controller;

import be.Citizen;
import be.FunctionalAbilitie;
import be.HealthCondition;
import gui.model.CitizenModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentEditCitizenController implements Initializable{
    //Health Conditions
    @FXML
    private ComboBox<String> relevanceComboBox;
    @FXML
    private TextArea currentAssessmentTxt;
    @FXML
    private TableColumn<HealthCondition, String> hCCategoryColumn;
    @FXML
    private ComboBox<String> hCCategoryComboBox;
    @FXML
    private ComboBox<String> hCExpectedLevelComboBox;
    @FXML
    private TextArea hCObservationNoteTxt;
    @FXML
    private TableColumn<HealthCondition, String> hCRelevanceColumn;
    @FXML
    private TableColumn<HealthCondition, String> hCSubCategoryColumn;
    @FXML
    private ComboBox<String> hCSubCategoryComboBox;
    @FXML
    private DatePicker hCdatePicker;
    @FXML
    private TextArea hCprofessionalNoteTxt;
    @FXML
    private TableView<HealthCondition> healthConditionTV;

    //Functional Abilities
    @FXML
    private ComboBox<String> performanceComboBox;
    @FXML
    private ComboBox<Integer> presentLevelComboBox;
    @FXML
    private TextArea observationNoteTxt;
    @FXML
    private TextArea wishesNGoalsTxt;
    @FXML
    private ComboBox<String> meaningOfPerformanceComboBox;
    @FXML
    private ComboBox<Integer> expectedLevelComboBox;
    @FXML
    private TableColumn<FunctionalAbilitie, String> fACategoryColumn;
    @FXML
    private ComboBox<String> fACategoryComboBox;
    @FXML
    private DatePicker fADatePicker;
    @FXML
    private TextArea fAProfNoteTxt;
    @FXML
    private TableColumn<FunctionalAbilitie, String> fASubCategoryColumn;
    @FXML
    private ComboBox<String> faSubCategoryComboBox;
    @FXML
    private TableView<FunctionalAbilitie> functionalAbilitiesTV;

    //General Information
    @FXML
    private TextArea rollerTxt;
    @FXML
    private TextArea resourcesTxt;
    @FXML
    private TextArea motivationTxt;
    @FXML
    private TextArea networkTxt;
    @FXML
    private TextArea healthInfoTxt;
    @FXML
    private TextArea interiorOfHomeTxt;
    @FXML
    private TextArea lifeStoryTxt;
    @FXML
    private TextArea masteryTxt;
    @FXML
    private TextArea assistiveDevicesTxt;
    @FXML
    private TextArea habitsTxt;
    @FXML
    private TextArea enJTxt;

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
    String fa_subcategory3_9 = "Muscle Strength";

    private ObservableList<String> fa_subcategory3_list = FXCollections.observableArrayList(fa_subcategory3_1, fa_subcategory3_2, fa_subcategory3_3, fa_subcategory3_4, fa_subcategory3_5, fa_subcategory3_6, fa_subcategory3_7, fa_subcategory3_8, fa_subcategory3_9);

    String fa_category4 = "Mental functions";
    String fa_subcategories4_1 = "Acquire skills";
    String fa_subcategories4_2 = "Problem solving";
    String fa_subcategories4_3 = "Apply communication equipment and techniques";
    String fa_subcategories4_4 = "Orientation ability";
    String fa_subcategories4_5 = "Energy and action";
    String fa_subcategories4_6 = "Memory";
    String fa_subcategories4_7 = "Emotional functions";
    String fa_subcategories4_8 = "Overall cognitive functions";

    private ObservableList<String> fa_subcategories4_list = FXCollections.observableArrayList(fa_subcategories4_1, fa_subcategories4_2, fa_subcategories4_3, fa_subcategories4_4, fa_subcategories4_5, fa_subcategories4_6, fa_subcategories4_7, fa_subcategories4_8);

    String fa_category5 = "Community life";
    String fa_subcategories5_1 = "Have paid employment";

    private ObservableList<String> fa_subcategories5_list = FXCollections.observableArrayList(fa_subcategories5_1);

    private ObservableList<String> fa_category_list = FXCollections.observableArrayList(fa_category1, fa_category2, fa_category3, fa_category4, fa_category5);


    private ObservableList<String> hc_relevance = FXCollections.observableArrayList("Not relevant", "Relevant", "Very relevant");
    private ObservableList<Integer> score = FXCollections.observableArrayList(0, 1, 2, 3, 4);
    private ObservableList<String> fa_performance = FXCollections.observableArrayList("Self performed", "Self performed partly", "Does not perform itself", "Not relevant");
    private ObservableList<String> fa_meaning_of_performance = FXCollections.observableArrayList("Does not experience limitations", "Experience limitations");

    private ObservableList<String> expectedLevelList = FXCollections.observableArrayList("Disappeared", "Remains unchanged", "Got worse");

    ArrayList<String> generalInfoName = new ArrayList<>();
    {
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
    }

    ArrayList<String> functionalAbilities = new ArrayList<>();
    ArrayList<String> healthConditions = new ArrayList<>();
    CitizenModel citizenModel;

    public StudentEditCitizenController(){
        citizenModel = new CitizenModel();

    }

    public void updateCitizenTableView(){
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenId = (Integer) currentStage.getUserData();
        hCCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("healthConditionsCitizenCategory"));
        hCSubCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("healthConditionsCitizenSubCategory"));
        hCRelevanceColumn.setCellValueFactory(new PropertyValueFactory<>("healthConditionsCitizenColor"));
        fACategoryColumn.setCellValueFactory(new PropertyValueFactory<>("functionalAbilitiesCitizenCategoryName"));
        fASubCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("functionalAbilitiesCitizenSubCategoryName"));
        try {
            healthConditionTV.setItems(citizenModel.getAllHealthCondition(citizenId));
            functionalAbilitiesTV.setItems(citizenModel.getALlFunctionalAbilities(citizenId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        healthConditionTV.setRowFactory(tr -> new  TableRow<HealthCondition>(){
            @Override
            protected void updateItem(HealthCondition item, boolean empty) {
                super.updateItem(item, empty);
                if (empty == true){
                    setStyle("-fx-background-color: #DAD5D6");
                    return;
                }
                if(item != null && item.getHealthConditionsCitizenColor().equals("Very relevant")) {
                    setStyle("-fx-background-color: #C54B6C;");
                }
                else if(item != null && item.getHealthConditionsCitizenColor().equals("Relevant")){
                    setStyle("-fx-background-color: #FFCCB6;");
                }
                else {
                    setStyle("-fx-background-color: #8DA47E;");
                }


            }
        });
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
        Platform.runLater(() -> {
            Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
            int citizenId = (Integer) currentStage.getUserData();



            //general information
            masteryTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(0)));
            motivationTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(1)));
            resourcesTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(2)));
            rollerTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(3)));
            habitsTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(4)));
            enJTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(5)));
            lifeStoryTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(6)));
            networkTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(7)));
            healthInfoTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(8)));
            assistiveDevicesTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(9)));
            interiorOfHomeTxt.setText(citizenModel.getGeneralInfoCitizen(citizenId, generalInfoName.get(10)));

            updateCitizenTableView();
            try {
                OnDoubleClickTableViewRow();
            } catch (Exception e) {
                e.printStackTrace();
            }
          /*  healthConditionTV.setRowFactory(tr -> new  TableRow<HealthCondition>(){
                @Override
                protected void updateItem(HealthCondition item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty == true){
                        setStyle("-fx-background-color: #DAD5D6");
                        return;
                    }
                    if(item != null && item.getHealthConditionsCitizenColor().equals("Very relevant")) {
                        setStyle("-fx-background-color: #C54B6C;");
                    }
                    else if(item != null && item.getHealthConditionsCitizenColor().equals("Relevant")){
                        setStyle("-fx-background-color: #FFCCB6;");
                    }
                    else {
                        setStyle("-fx-background-color: #8DA47E;");
                    }


                }
            });*/




        });


    }
    public void OnDoubleClickTableViewRow() throws Exception{
        healthConditionTV.setRowFactory(tv -> {
            TableRow<HealthCondition> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    HealthCondition rowData = row.getItem();
                    Stage currentStage = (Stage) hCCategoryComboBox.getScene().getWindow();
                    int citizenId = (Integer) currentStage.getUserData();
                    try{
                        healthConditions = (ArrayList<String>) citizenModel.getHealthConditionCitizen(rowData.getHealthConditionsCitizenCategory(), rowData.getHealthConditionsCitizenSubCategory(), citizenId);
                        hCCategoryComboBox.setValue(rowData.getHealthConditionsCitizenCategory());
                        hCSubCategoryComboBox.setValue(rowData.getHealthConditionsCitizenSubCategory());
                        relevanceComboBox.setValue(rowData.getHealthConditionsCitizenColor());
                        hCprofessionalNoteTxt.setText(healthConditions.get(1));
                        currentAssessmentTxt.setText(healthConditions.get(2));
                        hCExpectedLevelComboBox.setValue(healthConditions.get(3));
                        hCObservationNoteTxt.setText(healthConditions.get(4));
                        hCdatePicker.setValue(LocalDate.parse(healthConditions.get(5)));
                        hCCategoryComboBox.setDisable(true);
                        hCSubCategoryComboBox.setDisable(true);
                    }catch(NullPointerException e){
                        try {
                            throw new Exception("Does not exist");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            return row ;
        });
        functionalAbilitiesTV.setRowFactory(tv -> {
            TableRow<FunctionalAbilitie> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    FunctionalAbilitie rowData = row.getItem();
                    Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
                    int citizenId = (Integer) currentStage.getUserData();
                    try{
                        functionalAbilities = (ArrayList<String>) citizenModel.getFunctionalInformationCitizen(rowData.getFunctionalAbilitiesCitizenCategoryName(),rowData.getFunctionalAbilitiesCitizenSubCategoryName(), citizenId);
                        fACategoryComboBox.setValue(rowData.getFunctionalAbilitiesCitizenCategoryName());
                        faSubCategoryComboBox.setValue(rowData.getFunctionalAbilitiesCitizenSubCategoryName());
                        expectedLevelComboBox.setValue(Integer.valueOf(functionalAbilities.get(1)));
                        fAProfNoteTxt.setText(functionalAbilities.get(2));
                        performanceComboBox.setValue(functionalAbilities.get(3));
                        meaningOfPerformanceComboBox.setValue(functionalAbilities.get(4));
                        wishesNGoalsTxt.setText(functionalAbilities.get(5));
                        observationNoteTxt.setText(functionalAbilities.get(6));
                        fADatePicker.setValue(LocalDate.parse(functionalAbilities.get(7)));
                        fACategoryComboBox.setDisable(true);
                        faSubCategoryComboBox.setDisable(true);
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            });
            return row ;
        });
    }
    //Health Conditions
    public void OnClickedHCSubCategory(ActionEvent actionEvent) throws Exception {
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenId = (Integer) currentStage.getUserData();
        try{
            healthConditions = (ArrayList<String>) citizenModel.getHealthConditionCitizen(hCCategoryComboBox.getSelectionModel().getSelectedItem(), hCSubCategoryComboBox.getSelectionModel().getSelectedItem(), citizenId);
            relevanceComboBox.setValue(healthConditions.get(0));
            hCprofessionalNoteTxt.setText(healthConditions.get(1));
            currentAssessmentTxt.setText(healthConditions.get(2));
            hCExpectedLevelComboBox.setValue(healthConditions.get(3));
            hCObservationNoteTxt.setText(healthConditions.get(4));
            hCdatePicker.setValue(LocalDate.parse(healthConditions.get(5)));
            hCCategoryComboBox.setDisable(true);
            hCSubCategoryComboBox.setDisable(true);
        }catch(NullPointerException e){
            throw new Exception("Does not exist");
        }
    }

    public void OnClickedHCRelevance(ActionEvent actionEvent) {
        Stage currentStage = (Stage) hCCategoryComboBox.getScene().getWindow();
        int citizenId = (Integer) currentStage.getUserData();

        healthConditions = (ArrayList<String>) citizenModel.getHealthConditionCitizen(hCCategoryComboBox.getSelectionModel().getSelectedItem(), hCSubCategoryComboBox.getSelectionModel().getSelectedItem(), citizenId);

        if(relevanceComboBox.getSelectionModel().getSelectedItem().equals("Not relevant") && relevanceComboBox.getSelectionModel().getSelectedItem().equals(healthConditions.get(0))){
            hCprofessionalNoteTxt.setDisable(true);
            currentAssessmentTxt.setDisable(true);
            hCdatePicker.setDisable(true);
            hCObservationNoteTxt.setDisable(true);
            hCExpectedLevelComboBox.setDisable(true);
        }
        else if(relevanceComboBox.getSelectionModel().getSelectedItem().equals("Not relevant") && relevanceComboBox.getSelectionModel().getSelectedItem() != healthConditions.get(0)){
            hCprofessionalNoteTxt.setDisable(true);
            hCprofessionalNoteTxt.setText("");
            currentAssessmentTxt.setDisable(true);
            currentAssessmentTxt.setText("");
            hCdatePicker.setDisable(true);
            hCdatePicker.setValue(LocalDate.now());
            hCObservationNoteTxt.setDisable(true);
            hCObservationNoteTxt.setText("");
            hCExpectedLevelComboBox.getSelectionModel().clearSelection();
            hCExpectedLevelComboBox.setDisable(true);
        }

        if((relevanceComboBox.getSelectionModel().getSelectedItem().equals("Relevant") && relevanceComboBox.getSelectionModel().getSelectedItem().equals(healthConditions.get(0))) || (relevanceComboBox.getSelectionModel().getSelectedItem().equals("Relevant") && healthConditions.get(0).equals("Not relevant") && relevanceComboBox.getSelectionModel().getSelectedItem() != healthConditions.get(0))){
            hCprofessionalNoteTxt.setDisable(false);
            currentAssessmentTxt.setDisable(true);
            hCdatePicker.setDisable(true);
            hCObservationNoteTxt.setDisable(true);
            hCExpectedLevelComboBox.setDisable(true);
        }
        else if(relevanceComboBox.getSelectionModel().getSelectedItem().equals("Relevant") && relevanceComboBox.getSelectionModel().getSelectedItem() != healthConditions.get(0) && healthConditions.get(0).equals("Very relevant")){
            currentAssessmentTxt.setDisable(true);
            currentAssessmentTxt.setText("");
            hCdatePicker.setDisable(true);
            hCdatePicker.setValue(LocalDate.now());
            hCObservationNoteTxt.setDisable(true);
            hCObservationNoteTxt.setText("");
            hCExpectedLevelComboBox.setDisable(true);
            hCExpectedLevelComboBox.getSelectionModel().clearSelection();
        }

        if(relevanceComboBox.getSelectionModel().getSelectedItem().equals("Very relevant")){
            hCprofessionalNoteTxt.setDisable(false);
            currentAssessmentTxt.setDisable(false);
            hCdatePicker.setDisable(false);
            hCObservationNoteTxt.setDisable(false);
            hCExpectedLevelComboBox.setItems(expectedLevelList);
            hCExpectedLevelComboBox.setDisable(false);
        }
    }

    public void OnClickHCCategory(ActionEvent actionEvent) {
        if(hCCategoryComboBox.getValue() != null) {
            String selectedCategory = hCCategoryComboBox.getSelectionModel().getSelectedItem();
            if (selectedCategory.equals(hc_category1)) {
                hCSubCategoryComboBox.setItems(hc_subcategory1_list);
            } else if (selectedCategory.equals(hc_category2)) {
                hCSubCategoryComboBox.setItems(hc_subcategory2_list);
            } else if (selectedCategory.equals(hc_category3)) {
                hCSubCategoryComboBox.setItems(hc_subcategory3_list);
            } else if (selectedCategory.equals(hc_category4)) {
                hCSubCategoryComboBox.setItems(hc_subcategory4_list);
            } else if (selectedCategory.equals(hc_category5)) {
                hCSubCategoryComboBox.setItems(hc_subcategory5_list);
            } else if (selectedCategory.equals(hc_category6)) {
                hCSubCategoryComboBox.setItems(hc_subcategory6_list);
            } else if (selectedCategory.equals(hc_category7)) {
                hCSubCategoryComboBox.setItems(hc_subcategory7_list);
            } else if (selectedCategory.equals(hc_category8)) {
                hCSubCategoryComboBox.setItems(hc_subcategory8_list);
            } else if (selectedCategory.equals(hc_category9)) {
                hCSubCategoryComboBox.setItems(hc_subcategory9_list);
            } else if (selectedCategory.equals(hc_category10)) {
                hCSubCategoryComboBox.setItems(hc_subcategory10_list);
            } else if (selectedCategory.equals(hc_category11)) {
                hCSubCategoryComboBox.setItems(hc_subcategory11_list);
            } else if (selectedCategory.equals(hc_category12)) {
                hCSubCategoryComboBox.setItems(hc_subcategory12_list);
            } else {
                hCSubCategoryComboBox.setItems(null);
            }
        }
        hCExpectedLevelComboBox.equals(expectedLevelList);
    }

    public void OnClickSaveRelevance(ActionEvent actionEvent) {
        JFrame frame = new JFrame();

        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenId = (Integer) currentStage.getUserData();

        String selectedCategory = hCCategoryComboBox.getSelectionModel().getSelectedItem();
        String selectedSubCategory = hCSubCategoryComboBox.getSelectionModel().getSelectedItem();
        String relevance = relevanceComboBox.getSelectionModel().getSelectedItem();
        String professionalNote = hCprofessionalNoteTxt.getText();
        String currentAssessment = currentAssessmentTxt.getText();
        String expectedLevel = hCExpectedLevelComboBox.getSelectionModel().getSelectedItem();
        String observationNote = hCObservationNoteTxt.getText();
        LocalDate date = hCdatePicker.getValue();
        citizenModel.updateHealthConditionsCitizen(selectedCategory, selectedSubCategory, relevance, professionalNote, currentAssessment, expectedLevel, observationNote, date, citizenId);
        presentLevelComboBox.getSelectionModel().clearSelection();
        hCCategoryComboBox.setDisable(false);
        hCSubCategoryComboBox.setDisable(false);
        hCdatePicker.setValue(LocalDate.now());
        hCObservationNoteTxt.clear();
        hCExpectedLevelComboBox.getSelectionModel().clearSelection();
        currentAssessmentTxt.clear();
        hCprofessionalNoteTxt.clear();
        relevanceComboBox.getSelectionModel().clearSelection();
        hCSubCategoryComboBox.getSelectionModel().clearSelection();
        hCCategoryComboBox.getSelectionModel().clearSelection();
        JOptionPane.showMessageDialog(frame, "Saved");
        updateCitizenTableView();
    }
    //Functional Abilities
    public void OnClickFACategory(ActionEvent actionEvent) {

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

    public void OnClickedFASubCategory(ActionEvent actionEvent) throws Exception {
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenId = (Integer) currentStage.getUserData();
        try{
            functionalAbilities = (ArrayList<String>) citizenModel.getFunctionalInformationCitizen(fACategoryComboBox.getSelectionModel().getSelectedItem(), faSubCategoryComboBox.getSelectionModel().getSelectedItem(), citizenId);
            presentLevelComboBox.setValue(Integer.valueOf(functionalAbilities.get(0)));
            expectedLevelComboBox.setValue(Integer.valueOf(functionalAbilities.get(1)));
            fAProfNoteTxt.setText(functionalAbilities.get(2));
            performanceComboBox.setValue(functionalAbilities.get(3));
            meaningOfPerformanceComboBox.setValue(functionalAbilities.get(4));
            wishesNGoalsTxt.setText(functionalAbilities.get(5));
            observationNoteTxt.setText(functionalAbilities.get(6));
            fADatePicker.setValue(LocalDate.parse(functionalAbilities.get(7)));
            fACategoryComboBox.setDisable(true);
            faSubCategoryComboBox.setDisable(true);
        }catch(NullPointerException e){
            throw new Exception("Does not exist");
        }
    }

    public void OnClickSaveFunctionalAbilities(ActionEvent actionEvent) {
        JFrame frame = new JFrame();
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenId = (Integer) currentStage.getUserData();

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
        citizenModel.updateFunctionalAbilitiesCitizen(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenId);
        presentLevelComboBox.getSelectionModel().clearSelection();
        expectedLevelComboBox.getSelectionModel().clearSelection();
        fACategoryComboBox.setDisable(false);
        faSubCategoryComboBox.setDisable(false);
        fAProfNoteTxt.clear();
        performanceComboBox.getSelectionModel().clearSelection();
        meaningOfPerformanceComboBox.getSelectionModel().clearSelection();
        wishesNGoalsTxt.clear();
        observationNoteTxt.clear();
        fADatePicker.setValue(LocalDate.now());
        //fADatePicker.setValue(null);
        JOptionPane.showMessageDialog(frame, "Saved");
    }

    public void OnClickPopImage(ActionEvent actionEvent) {
        JFrame frame = new JFrame();
        frame.add(new JLabel((Icon) new ImageIcon("/images/01234.png").getImage()));

    }

    //General Information
    public void OnClickSaveGeneralInfo(ActionEvent actionEvent) {
        JFrame frame = new JFrame();

        Stage currentStage = (Stage) masteryTxt.getScene().getWindow();
        int citizenId = (Integer) currentStage.getUserData();

        ArrayList<String> generalInfoEditable = new ArrayList<>();

        {
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
            generalInfoEditable.add(interiorOfHomeTxt.getText());
        }

        for (int i = 0; i < generalInfoEditable.size(); i++) {

            citizenModel.updateGeneralInfoCitizen(generalInfoName.get(i), generalInfoEditable.get(i), citizenId);
        }
        JOptionPane.showMessageDialog(frame, "Saved");

    }
    public void OnClickfirstInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The citizen's conscious or unconscious handling of life / illness - both challenges and opportunities. !!");
    }

    public void OnClicksecondInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The driving force behind the citizen acting in a certain way or embarking on / maintaining a task / effort. !!");
    }

    public void OnClickthirdInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The physical or mental forces that the citizen has to a certain extent available and can utilize Physical forces can, for example, be in the " +
                "form of physical health and strength. Mental forces can, for example, be in the form of mental health and strength, including thoughts and ways of relating to situations and other people. !!");
    }

    public void OnClickfourthInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "The roles that are particularly important for the citizen in relation to family, work and society. !!");
    }

    public void OnClickfifthInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Regular behavior that the citizen has learned through constant repetition and execution completely or partially unconsciously. Habits are, for example, the circadian rhythm, the way to be addressed, contact with fellow human beings and relationships, the way of looking at the world.  !!");
    }

    public void OnClicksixthInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Current or previous educational and / or professional background. For example, primary school, vocational education and higher education. !!");
    }

    public void OnClickseventhInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "A description of the citizen's experience of significant events, interests and chores throughout life. !!");
    }

    public void OnClickeightInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Persons who are close to the citizen and who provide practical and / or emotional support and care for the citizen. Networks can be public or private. A public network consists of personal helpers, health professionals and other professionals primarily caregivers. Private networks are family, relatives, friends and acquaintances. !!");
    }

    public void OnClickninethInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Health information !!");
    }

    public void OnClicktenthInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Equipment, products and technology used by the citizen in daily activities, incl. those adapted or specially made for, implanted in, located on or near the person using them. (Including general items and aids and technology for personal use) !!");
    }

    public void OnClickeleventhInfoBtn (ActionEvent event){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "A description of the home's physical framework and surroundings that are important for the citizen's everyday life and ability to function. !!");
    }
}
