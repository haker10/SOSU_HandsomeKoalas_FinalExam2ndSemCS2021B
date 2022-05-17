package be;

import java.time.LocalDate;

public class HealthConditionCT {
    int healthConditionsCitizenTemplateID;
    String healthConditionsCitizenTemplateCategory;
    String healthConditionsCitizenTemplateSubCategory;
    String healthConditionsCitizenTemplateColor;
    String healthConditionsCitizenTemplateProfessionalNote;
    String healthConditionsCitizenTemplateAssessmentNote;
    String healthConditionsCitizenTemplateExpectedLevel;
    String healthConditionsCitizenTemplateObservableNote;
    LocalDate healthConditionsCitizenTemplateDate;
    int citizenTemplateID;

    public HealthConditionCT(int healthConditionsCitizenTemplateID, String healthConditionsCitizenTemplateCategory, String healthConditionsCitizenTemplateSubCategory, String healthConditionsCitizenTemplateColor, String healthConditionsCitizenTemplateProfessionalNote, String healthConditionsCitizenTemplateAssessmentNote, String healthConditionsCitizenTemplateExpectedLevel, String healthConditionsCitizenTemplateObservableNote, LocalDate healthConditionsCitizenTemplateDate, int citizenTemplateID) {
        this.healthConditionsCitizenTemplateID = healthConditionsCitizenTemplateID;
        this.healthConditionsCitizenTemplateCategory = healthConditionsCitizenTemplateCategory;
        this.healthConditionsCitizenTemplateSubCategory = healthConditionsCitizenTemplateSubCategory;
        this.healthConditionsCitizenTemplateColor = healthConditionsCitizenTemplateColor;
        this.healthConditionsCitizenTemplateProfessionalNote = healthConditionsCitizenTemplateProfessionalNote;
        this.healthConditionsCitizenTemplateAssessmentNote = healthConditionsCitizenTemplateAssessmentNote;
        this.healthConditionsCitizenTemplateExpectedLevel = healthConditionsCitizenTemplateExpectedLevel;
        this.healthConditionsCitizenTemplateObservableNote = healthConditionsCitizenTemplateObservableNote;
        this.healthConditionsCitizenTemplateDate = healthConditionsCitizenTemplateDate;
        this.citizenTemplateID = citizenTemplateID;
    }

    public String getHealthConditionsCitizenTemplateCategory() {
        return healthConditionsCitizenTemplateCategory;
    }

    public String getHealthConditionsCitizenTemplateSubCategory() {
        return healthConditionsCitizenTemplateSubCategory;
    }

    public String getHealthConditionsCitizenTemplateColor() {
        return healthConditionsCitizenTemplateColor;
    }

}
