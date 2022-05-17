package be;

import java.time.LocalDate;

public class HealthCondition {
    int healthConditionsCitizenID;
    String healthConditionsCitizenCategory;
    String healthConditionsCitizenSubCategory;
    String healthConditionsCitizenColor;
    String healthConditionsCitizenProfessionalNote;
    String healthConditionsCitizenAssessmentNote;
    String healthConditionsCitizenExpectedLevel;
    String healthConditionsCitizenObservableNote;
    LocalDate healthConditionsCitizenDate;
    int citizenID;

    public HealthCondition(int healthConditionsCitizenID, String healthConditionsCitizenCategory, String healthConditionsCitizenSubCategory, String healthConditionsCitizenColor, String healthConditionsCitizenProfessionalNote, String healthConditionsCitizenAssessmentNote, String healthConditionsCitizenExpectedLevel, String healthConditionsCitizenObservableNote, LocalDate healthConditionsCitizenDate, int citizenID) {
        this.healthConditionsCitizenID = healthConditionsCitizenID;
        this.healthConditionsCitizenCategory = healthConditionsCitizenCategory;
        this.healthConditionsCitizenSubCategory = healthConditionsCitizenSubCategory;
        this.healthConditionsCitizenColor = healthConditionsCitizenColor;
        this.healthConditionsCitizenProfessionalNote = healthConditionsCitizenProfessionalNote;
        this.healthConditionsCitizenAssessmentNote = healthConditionsCitizenAssessmentNote;
        this.healthConditionsCitizenExpectedLevel = healthConditionsCitizenExpectedLevel;
        this.healthConditionsCitizenObservableNote = healthConditionsCitizenObservableNote;
        this.healthConditionsCitizenDate = healthConditionsCitizenDate;
        this.citizenID = citizenID;
    }

    public String getHealthConditionsCitizenCategory() {
        return healthConditionsCitizenCategory;
    }

    public String getHealthConditionsCitizenSubCategory() {
        return healthConditionsCitizenSubCategory;
    }

    public String getHealthConditionsCitizenColor() {
        return healthConditionsCitizenColor;
    }

}
