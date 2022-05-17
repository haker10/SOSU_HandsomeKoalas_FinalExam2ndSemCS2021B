package be;

import java.time.LocalDate;

public class FunctionalAbilitieCT {
    int functionalAbilitiesCitizenTemplateID;
    String functionalAbilitiesCitizenTemplateCategoryName;
    String functionalAbilitiesCitizenTemplateSubCategoryName;
    int functionalAbilitiesCitizenTemplateScore;
    int functionalAbilitiesCitizenTemplateExpectedScore;
    String functionalAbilitiesCitizenTemplateProfessionalNote;
    String functionalAbilitiesCitizenTemplatePerformance;
    String functionalAbilitiesCitizenTemplateLimitation;
    String functionalAbilitiesCitizenTemplateGoalsNote;
    String functionalAbilitiesCitizenTemplateObservationNote;
    LocalDate functionalAbilitiesCitizenTemplateDate;
    int citizenTemplateID;

    public FunctionalAbilitieCT(int functionalAbilitiesCitizenTemplateID, String functionalAbilitiesCitizenTemplateCategoryName, String functionalAbilitiesCitizenTemplateSubCategoryName, int functionalAbilitiesCitizenTemplateScore, int functionalAbilitiesCitizenTemplateExpectedScore, String functionalAbilitiesCitizenTemplateProfessionalNote, String functionalAbilitiesCitizenTemplatePerformance, String functionalAbilitiesCitizenTemplateLimitation, String functionalAbilitiesCitizenTemplateGoalsNote, String functionalAbilitiesCitizenTemplateObservationNote, LocalDate functionalAbilitiesCitizenTemplateDate, int citizenTemplateID) {
        this.functionalAbilitiesCitizenTemplateID = functionalAbilitiesCitizenTemplateID;
        this.functionalAbilitiesCitizenTemplateCategoryName = functionalAbilitiesCitizenTemplateCategoryName;
        this.functionalAbilitiesCitizenTemplateSubCategoryName = functionalAbilitiesCitizenTemplateSubCategoryName;
        this.functionalAbilitiesCitizenTemplateScore = functionalAbilitiesCitizenTemplateScore;
        this.functionalAbilitiesCitizenTemplateExpectedScore = functionalAbilitiesCitizenTemplateExpectedScore;
        this.functionalAbilitiesCitizenTemplateProfessionalNote = functionalAbilitiesCitizenTemplateProfessionalNote;
        this.functionalAbilitiesCitizenTemplatePerformance = functionalAbilitiesCitizenTemplatePerformance;
        this.functionalAbilitiesCitizenTemplateLimitation = functionalAbilitiesCitizenTemplateLimitation;
        this.functionalAbilitiesCitizenTemplateGoalsNote = functionalAbilitiesCitizenTemplateGoalsNote;
        this.functionalAbilitiesCitizenTemplateObservationNote = functionalAbilitiesCitizenTemplateObservationNote;
        this.functionalAbilitiesCitizenTemplateDate = functionalAbilitiesCitizenTemplateDate;
        this.citizenTemplateID = citizenTemplateID;
    }

    public String getFunctionalAbilitiesCitizenTemplateCategoryName() {
        return functionalAbilitiesCitizenTemplateCategoryName;
    }

    public String getFunctionalAbilitiesCitizenTemplateSubCategoryName() {
        return functionalAbilitiesCitizenTemplateSubCategoryName;
    }

}
