package be;

import java.time.LocalDate;

public class HealthCondition {
    private int healthConditionsCitizenID;
    private String healthConditionsCitizenCategory;
    private String healthConditionsCitizenSubCategory;
    private String healthConditionsCitizenColor;
    private String healthConditionsCitizenProfessionalNote;
    private String healthConditionsCitizenAssessmentNote;
    private String healthConditionsCitizenExpectedLevel;
    private String healthConditionsCitizenObservableNote;
    private LocalDate healthConditionsCitizenDate;
    private int citizenID;

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

    public int getHealthConditionsCitizenID() {
        return healthConditionsCitizenID;
    }

    public void setHealthConditionsCitizenID(int healthConditionsCitizenID) {
        this.healthConditionsCitizenID = healthConditionsCitizenID;
    }

    public String getHealthConditionsCitizenCategory() {
        return healthConditionsCitizenCategory;
    }

    public void setHealthConditionsCitizenCategory(String healthConditionsCitizenCategory) {
        this.healthConditionsCitizenCategory = healthConditionsCitizenCategory;
    }

    public String getHealthConditionsCitizenSubCategory() {
        return healthConditionsCitizenSubCategory;
    }

    public void setHealthConditionsCitizenSubCategory(String healthConditionsCitizenSubCategory) {
        this.healthConditionsCitizenSubCategory = healthConditionsCitizenSubCategory;
    }

    public String getHealthConditionsCitizenColor() {
        return healthConditionsCitizenColor;
    }

    public void setHealthConditionsCitizenColor(String healthConditionsCitizenColor) {
        this.healthConditionsCitizenColor = healthConditionsCitizenColor;
    }

    public String getHealthConditionsCitizenProfessionalNote() {
        return healthConditionsCitizenProfessionalNote;
    }

    public void setHealthConditionsCitizenProfessionalNote(String healthConditionsCitizenProfessionalNote) {
        this.healthConditionsCitizenProfessionalNote = healthConditionsCitizenProfessionalNote;
    }

    public String getHealthConditionsCitizenAssessmentNote() {
        return healthConditionsCitizenAssessmentNote;
    }

    public void setHealthConditionsCitizenAssessmentNote(String healthConditionsCitizenAssessmentNote) {
        this.healthConditionsCitizenAssessmentNote = healthConditionsCitizenAssessmentNote;
    }

    public String getHealthConditionsCitizenExpectedLevel() {
        return healthConditionsCitizenExpectedLevel;
    }

    public void setHealthConditionsCitizenExpectedLevel(String healthConditionsCitizenExpectedLevel) {
        this.healthConditionsCitizenExpectedLevel = healthConditionsCitizenExpectedLevel;
    }

    public String getHealthConditionsCitizenObservableNote() {
        return healthConditionsCitizenObservableNote;
    }

    public void setHealthConditionsCitizenObservableNote(String healthConditionsCitizenObservableNote) {
        this.healthConditionsCitizenObservableNote = healthConditionsCitizenObservableNote;
    }

    public LocalDate getHealthConditionsCitizenDate() {
        return healthConditionsCitizenDate;
    }

    public void setHealthConditionsCitizenDate(LocalDate healthConditionsCitizenDate) {
        this.healthConditionsCitizenDate = healthConditionsCitizenDate;
    }

    public int getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }
}
