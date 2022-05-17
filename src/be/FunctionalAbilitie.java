package be;

import java.time.LocalDate;

public class FunctionalAbilitie {
    int functionalAbilitiesCitizenID;
    String functionalAbilitiesCitizenCategoryName;
    String functionalAbilitiesCitizenSubCategoryName;
    int functionalAbilitiesCitizenScore;
    int functionalAbilitiesCitizenExpectedScore;
    String functionalAbilitiesCitizenProfessionalNote;
    String functionalAbilitiesCitizenPerformance;
    String functionalAbilitiesCitizenLimitation;
    String functionalAbilitiesCitizenGoalsNote;
    String functionalAbilitiesCitizenObservationNote;
    LocalDate functionalAbilitiesCitizenTemplateDate;
    int citizenID;

    public FunctionalAbilitie(int functionalAbilitiesCitizenID, String functionalAbilitiesCitizenCategoryName, String functionalAbilitiesCitizenSubCategoryName, int functionalAbilitiesCitizenScore, int functionalAbilitiesCitizenExpectedScore, String functionalAbilitiesCitizenProfessionalNote, String functionalAbilitiesCitizenPerformance, String functionalAbilitiesCitizenLimitation, String functionalAbilitiesCitizenGoalsNote, String functionalAbilitiesCitizenObservationNote, LocalDate functionalAbilitiesCitizenTemplateDate, int citizenID) {
        this.functionalAbilitiesCitizenID = functionalAbilitiesCitizenID;
        this.functionalAbilitiesCitizenCategoryName = functionalAbilitiesCitizenCategoryName;
        this.functionalAbilitiesCitizenSubCategoryName = functionalAbilitiesCitizenSubCategoryName;
        this.functionalAbilitiesCitizenScore = functionalAbilitiesCitizenScore;
        this.functionalAbilitiesCitizenExpectedScore = functionalAbilitiesCitizenExpectedScore;
        this.functionalAbilitiesCitizenProfessionalNote = functionalAbilitiesCitizenProfessionalNote;
        this.functionalAbilitiesCitizenPerformance = functionalAbilitiesCitizenPerformance;
        this.functionalAbilitiesCitizenLimitation = functionalAbilitiesCitizenLimitation;
        this.functionalAbilitiesCitizenGoalsNote = functionalAbilitiesCitizenGoalsNote;
        this.functionalAbilitiesCitizenObservationNote = functionalAbilitiesCitizenObservationNote;
        this.functionalAbilitiesCitizenTemplateDate = functionalAbilitiesCitizenTemplateDate;
        this.citizenID = citizenID;
    }

    public String getFunctionalAbilitiesCitizenCategoryName() {
        return functionalAbilitiesCitizenCategoryName;
    }

    public String getFunctionalAbilitiesCitizenSubCategoryName() {
        return functionalAbilitiesCitizenSubCategoryName;
    }

}
