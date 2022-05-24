package gui.controller;

import be.FunctionalAbilitieCT;
import be.HealthConditionCT;
import gui.model.CitizenTemplateModel;
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
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherEditCitizenTemplateController implements Initializable{

    //Health Conditions
    @FXML
    private ComboBox<String> relevanceComboBox;
    @FXML
    private TextArea currentAssessmentTxt;
    @FXML
    private TableColumn<HealthConditionCT, String> hCCategoryColumn;
    @FXML
    private ComboBox<String> hCCategoryComboBox;
    @FXML
    private ComboBox<String> hCExpectedLevelComboBox;
    @FXML
    private TextArea hCObservationNoteTxt;
    @FXML
    private TableColumn<HealthConditionCT, String> hCRelevanceColumn;
    @FXML
    private TableColumn<HealthConditionCT, String> hCSubCategoryColumn;
    @FXML
    private ComboBox<String> hCSubCategoryComboBox;
    @FXML
    private DatePicker hCdatePicker;
    @FXML
    private TextArea hCprofessionalNoteTxt;
    @FXML
    private TableView<HealthConditionCT> healthConditionTV;

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
    private TableColumn<FunctionalAbilitieCT, String> fACategoryColumn;
    @FXML
    private ComboBox<String> fACategoryComboBox;
    @FXML
    private DatePicker fADatePicker;
    @FXML
    private TextArea fAProfNoteTxt;
    @FXML
    private TableColumn<FunctionalAbilitieCT, String> fASubCategoryColumn;
    @FXML
    private ComboBox<String> faSubCategoryComboBox;
    @FXML
    private TableView<FunctionalAbilitieCT> functionalAbilitiesTV;

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

    String info;
    private double xoffset;
    private double yoffset;

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
    ArrayList<String> healthConditions = new ArrayList<>(6);
    CitizenTemplateModel citizenTemplateModel;

    public TeacherEditCitizenTemplateController(){
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
        Platform.runLater(() -> {
            Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
            int citizenTemplateID = (int) currentStage.getUserData();

            //general information
            masteryTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(0)));
            motivationTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(1)));
            resourcesTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(2)));
            rollerTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(3)));
            habitsTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(4)));
            enJTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(5)));
            lifeStoryTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(6)));
            networkTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(7)));
            healthInfoTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(8)));
            assistiveDevicesTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(9)));
            interiorOfHomeTxt.setText(citizenTemplateModel.getGeneralInfoCitizenTemplate(citizenTemplateID, generalInfoName.get(10)));

            updateCitizenTemplateTableView();
            clearFA();
            clearHC();
            try {
                OnDoubleClickTableViewRow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void updateCitizenTemplateTableView(){
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenTemplateID = (int) currentStage.getUserData();
        hCCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("healthConditionsCitizenTemplateCategory"));
        hCSubCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("healthConditionsCitizenTemplateSubCategory"));
        hCRelevanceColumn.setCellValueFactory(new PropertyValueFactory<>("healthConditionsCitizenTemplateColor"));
        fACategoryColumn.setCellValueFactory(new PropertyValueFactory<>("functionalAbilitiesCitizenTemplateCategoryName"));
        fASubCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("functionalAbilitiesCitizenTemplateSubCategoryName"));
        try {
            healthConditionTV.setItems(citizenTemplateModel.getAllHealthConditionTemplate(citizenTemplateID));
            functionalAbilitiesTV.setItems(citizenTemplateModel.getALlFunctionalAbilitiesTemplate(citizenTemplateID));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OnDoubleClickTableViewRow() throws Exception{
        healthConditionTV.setRowFactory(tv -> {
            TableRow<HealthConditionCT> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    hCCategoryComboBox.setDisable(false);
                    hCSubCategoryComboBox.setDisable(false);
                    hCCategoryComboBox.getSelectionModel().clearSelection();
                    hCSubCategoryComboBox.getSelectionModel().clearSelection();
                    HealthConditionCT rowData = row.getItem();
                    Stage currentStage = (Stage) hCCategoryComboBox.getScene().getWindow();
                    int citizenTemplateID = (int) currentStage.getUserData();
                    try{
                        healthConditions = (ArrayList<String>) citizenTemplateModel.getHealthConditionCitizenTemplate(rowData.getHealthConditionsCitizenTemplateCategory(), rowData.getHealthConditionsCitizenTemplateSubCategory(), citizenTemplateID);
                        hCCategoryComboBox.setValue(rowData.getHealthConditionsCitizenTemplateCategory());
                        hCSubCategoryComboBox.setValue(rowData.getHealthConditionsCitizenTemplateSubCategory());
                        relevanceComboBox.setValue(rowData.getHealthConditionsCitizenTemplateColor());
                        hCprofessionalNoteTxt.setText(healthConditions.get(1));
                        currentAssessmentTxt.setText(healthConditions.get(2));
                        hCExpectedLevelComboBox.setValue(healthConditions.get(3));
                        hCObservationNoteTxt.setText(healthConditions.get(4));
                        hCdatePicker.setValue(LocalDate.parse(healthConditions.get(5)));
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
            TableRow<FunctionalAbilitieCT> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    fACategoryComboBox.setDisable(false);
                    faSubCategoryComboBox.setDisable(false);
                    fACategoryComboBox.getSelectionModel().clearSelection();
                    faSubCategoryComboBox.getSelectionModel().clearSelection();
                    FunctionalAbilitieCT rowData = row.getItem();
                    Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
                    int citizenTemplateID = (int) currentStage.getUserData();
                    try{
                        functionalAbilities = (ArrayList<String>) citizenTemplateModel.getFunctionalInformationCitizenTemplate(rowData.getFunctionalAbilitiesCitizenTemplateCategoryName(),rowData.getFunctionalAbilitiesCitizenTemplateSubCategoryName(), citizenTemplateID);
                        fACategoryComboBox.setValue(rowData.getFunctionalAbilitiesCitizenTemplateCategoryName());
                        faSubCategoryComboBox.setValue(rowData.getFunctionalAbilitiesCitizenTemplateSubCategoryName());
                        presentLevelComboBox.setValue(Integer.valueOf(functionalAbilities.get(0)));
                        expectedLevelComboBox.setValue(Integer.valueOf(functionalAbilities.get(1)));
                        fAProfNoteTxt.setText(functionalAbilities.get(2));
                        performanceComboBox.setValue(functionalAbilities.get(3));
                        meaningOfPerformanceComboBox.setValue(functionalAbilities.get(4));
                        wishesNGoalsTxt.setText(functionalAbilities.get(5));
                        observationNoteTxt.setText(functionalAbilities.get(6));
                        fADatePicker.setValue(LocalDate.parse(functionalAbilities.get(7)));
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }

    //Health Conditions
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

    public void OnClickedHCSubCategory(ActionEvent actionEvent) throws Exception {
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenTemplateID = (int) currentStage.getUserData();
        if (hCCategoryComboBox.getValue() != null) {
            try {
                hCdatePicker.setDisable(false);
                healthConditions = (ArrayList<String>) citizenTemplateModel.getHealthConditionCitizenTemplate(hCCategoryComboBox.getSelectionModel().getSelectedItem(), hCSubCategoryComboBox.getSelectionModel().getSelectedItem(), citizenTemplateID);
                relevanceComboBox.setValue(healthConditions.get(0));
                hCprofessionalNoteTxt.setText(healthConditions.get(1));
                currentAssessmentTxt.setText(healthConditions.get(2));
                hCExpectedLevelComboBox.setValue(healthConditions.get(3));
                hCObservationNoteTxt.setText(healthConditions.get(4));
                hCdatePicker.setValue(LocalDate.parse(healthConditions.get(5)));
                hCCategoryComboBox.setDisable(true);
                hCSubCategoryComboBox.setDisable(true);
                relevanceComboBox.setDisable(false);
            } catch (NullPointerException e) {
                throw new Exception("Does not exist");
            }
        }
    }

    public void OnClickedHCRelevance(ActionEvent actionEvent) {
        Stage currentStage = (Stage) hCCategoryComboBox.getScene().getWindow();
        int citizenTemplateID = (int) currentStage.getUserData();
        hCdatePicker.setDisable(false);

        healthConditions = (ArrayList<String>) citizenTemplateModel.getHealthConditionCitizenTemplate(hCCategoryComboBox.getSelectionModel().getSelectedItem(), hCSubCategoryComboBox.getSelectionModel().getSelectedItem(), citizenTemplateID);
        if(hCSubCategoryComboBox.getValue() != null) {
            if (relevanceComboBox.getSelectionModel().getSelectedItem().equals("Not relevant") && relevanceComboBox.getSelectionModel().getSelectedItem().equals(healthConditions.get(0))) {
                hCprofessionalNoteTxt.setDisable(true);
                currentAssessmentTxt.setDisable(true);
                hCObservationNoteTxt.setDisable(true);
                hCExpectedLevelComboBox.setDisable(true);
                hCdatePicker.setDisable(true);
                hCdatePicker.setValue(LocalDate.now());
            } else if (relevanceComboBox.getSelectionModel().getSelectedItem().equals("Not relevant") && relevanceComboBox.getSelectionModel().getSelectedItem() != healthConditions.get(0)) {
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

            if ((relevanceComboBox.getSelectionModel().getSelectedItem().equals("Relevant") && relevanceComboBox.getSelectionModel().getSelectedItem().equals(healthConditions.get(0))) || (relevanceComboBox.getSelectionModel().getSelectedItem().equals("Relevant") && healthConditions.get(0).equals("Not relevant") && relevanceComboBox.getSelectionModel().getSelectedItem() != healthConditions.get(0))) {
                hCprofessionalNoteTxt.setDisable(false);
                currentAssessmentTxt.setDisable(true);
                hCObservationNoteTxt.setDisable(true);
                hCExpectedLevelComboBox.setItems(expectedLevelList);
                hCExpectedLevelComboBox.setDisable(true);
                hCdatePicker.setDisable(true);
            } else if (relevanceComboBox.getSelectionModel().getSelectedItem().equals("Relevant") && relevanceComboBox.getSelectionModel().getSelectedItem() != healthConditions.get(0) && healthConditions.get(0).equals("Very relevant")) {
                currentAssessmentTxt.setDisable(true);
                currentAssessmentTxt.setText("");
                hCdatePicker.setValue(LocalDate.now());
                hCObservationNoteTxt.setDisable(true);
                hCObservationNoteTxt.setText("");
                hCExpectedLevelComboBox.setItems(expectedLevelList);
                hCExpectedLevelComboBox.setDisable(true);
                hCdatePicker.setDisable(true);
            }

            if (relevanceComboBox.getSelectionModel().getSelectedItem().equals("Very relevant")) {
                hCprofessionalNoteTxt.setDisable(false);
                currentAssessmentTxt.setDisable(false);
                hCObservationNoteTxt.setDisable(false);
                hCExpectedLevelComboBox.setItems(expectedLevelList);
                hCExpectedLevelComboBox.setDisable(false);
            }
        }
    }

    public void clearHC(){

        hCCategoryComboBox.getSelectionModel().clearSelection();
        hCSubCategoryComboBox.getSelectionModel().clearSelection();
        relevanceComboBox.getSelectionModel().clearSelection();
        hCprofessionalNoteTxt.clear();
        currentAssessmentTxt.clear();
        hCExpectedLevelComboBox.getSelectionModel().clearSelection();
        hCObservationNoteTxt.clear();
        hCdatePicker.setValue(LocalDate.now());

        hCCategoryComboBox.setDisable(false);
        hCSubCategoryComboBox.setDisable(false);

        relevanceComboBox.setDisable(true);
        hCprofessionalNoteTxt.setDisable(true);
        currentAssessmentTxt.setDisable(true);
        hCObservationNoteTxt.setDisable(true);
        hCExpectedLevelComboBox.setDisable(true);
        hCdatePicker.setDisable(true);

    }

    public void OnClickSaveRelevance(ActionEvent actionEvent) {
        JFrame frame = new JFrame();

        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenTemplateID = (int) currentStage.getUserData();

        String selectedCategory = hCCategoryComboBox.getSelectionModel().getSelectedItem();
        String selectedSubCategory = hCSubCategoryComboBox.getSelectionModel().getSelectedItem();
        String relevance = relevanceComboBox.getSelectionModel().getSelectedItem();
        String professionalNote = hCprofessionalNoteTxt.getText();
        String currentAssessment = currentAssessmentTxt.getText();
        String expectedLevel = hCExpectedLevelComboBox.getSelectionModel().getSelectedItem();
        String observationNote = hCObservationNoteTxt.getText();
        LocalDate date = hCdatePicker.getValue();

        if (citizenTemplateModel.checkHealthConditionsTemplateId(selectedCategory, selectedSubCategory, citizenTemplateID) == false){
            citizenTemplateModel.createHealthConditionsCitizenTemplate(selectedCategory, selectedSubCategory, relevance, professionalNote, currentAssessment, expectedLevel, observationNote, date, citizenTemplateID);
        }
        else {
            citizenTemplateModel.updateHealthConditionsCitizenTemplate(selectedCategory, selectedSubCategory, relevance, professionalNote, currentAssessment, expectedLevel, observationNote, date, citizenTemplateID);
        }
        clearHC();
        JOptionPane.showMessageDialog(frame, "Saved");
        updateCitizenTemplateTableView();
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
        int citizenTemplateID = (int) currentStage.getUserData();

        fADatePicker.setDisable(false);
        observationNoteTxt.setDisable(false);
        wishesNGoalsTxt.setDisable(false);
        meaningOfPerformanceComboBox.setDisable(false);
        performanceComboBox.setDisable(false);
        fAProfNoteTxt.setDisable(false);
        expectedLevelComboBox.setDisable(false);
        presentLevelComboBox.setDisable(false);
        if (fACategoryComboBox.getValue() != null) {
            try {
                functionalAbilities = (ArrayList<String>) citizenTemplateModel.getFunctionalInformationCitizenTemplate(fACategoryComboBox.getSelectionModel().getSelectedItem(), faSubCategoryComboBox.getSelectionModel().getSelectedItem(), citizenTemplateID);
                presentLevelComboBox.setValue(Integer.valueOf(functionalAbilities.get(0)));
                expectedLevelComboBox.setValue(Integer.valueOf(functionalAbilities.get(1)));
                fAProfNoteTxt.setText(functionalAbilities.get(2));
                performanceComboBox.setValue(functionalAbilities.get(3));
                meaningOfPerformanceComboBox.setValue(functionalAbilities.get(4));
                wishesNGoalsTxt.setText(functionalAbilities.get(5));
                observationNoteTxt.setText(functionalAbilities.get(6));
                fADatePicker.setValue(LocalDate.parse(functionalAbilities.get(7)));
            } catch (NullPointerException e) {
                throw new Exception("Does not exist");
            }
        }
    }

    public void OnClickSaveFunctionalAbilities(ActionEvent actionEvent) {
        JFrame frame = new JFrame();
        Stage currentStage = (Stage) fACategoryComboBox.getScene().getWindow();
        int citizenTemplateID = (int) currentStage.getUserData();



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

        if(citizenTemplateModel.checkFunctionalAbilitiesTemplateId(selectedCategory, selectedSubCategory, citizenTemplateID) == false){
            citizenTemplateModel.createFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateID);
        }
        else{
            citizenTemplateModel.updateFunctionalAbilitiesCitizenTemplate(selectedCategory, selectedSubCategory, selectedPresentLevel, selectedExpectedLevel, professionalNote, selectedPerformance, selectedMeaningOfPerformance, wishesNGoals, observationNote, date, citizenTemplateID);
        }
        clearFA();
        updateCitizenTemplateTableView();
        JOptionPane.showMessageDialog(frame, "Saved");
    }

    public void OnClickPopImage(ActionEvent actionEvent) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/view/imageView.fxml"));
            Stage stage = new Stage();
            root.setOnMousePressed(event -> {
                xoffset = event.getSceneX();
                yoffset = event.getSceneY();

            });
            root.setOnMouseDragged(e->{
                stage.setX(e.getSceneX()- xoffset);
                stage.setY(e.getScreenY() - yoffset);
            });

            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setUserData(info);
            stage.show();
            scene.setFill(Color.TRANSPARENT);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void clearFA(){
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

        fACategoryComboBox.setDisable(false);
        faSubCategoryComboBox.setDisable(false);

        presentLevelComboBox.setDisable(true);
        expectedLevelComboBox.setDisable(true);
        fAProfNoteTxt.setDisable(true);
        performanceComboBox.setDisable(true);
        meaningOfPerformanceComboBox.setDisable(true);
        wishesNGoalsTxt.setDisable(true);
        observationNoteTxt.setDisable(true);
        fADatePicker.setDisable(true);
    }

    //General Information
    public void OnClickSaveGeneralInfo(ActionEvent actionEvent) {
        JFrame frame = new JFrame();

        Stage currentStage = (Stage) masteryTxt.getScene().getWindow();
        int citizenTemplateID = (int) currentStage.getUserData();

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

            citizenTemplateModel.updateGeneralInfoCitizenTemplate(generalInfoName.get(i), generalInfoEditable.get(i), citizenTemplateID);
        }
        JOptionPane.showMessageDialog(frame, "Saved");
    }

    public void OnClickXBtn(ActionEvent actionEvent) {
        Stage currentStage = (Stage) masteryTxt.getScene().getWindow();
        currentStage.close();
    }
}
