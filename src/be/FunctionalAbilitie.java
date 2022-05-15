package be;

import java.time.LocalDate;

public class FunctionalAbilitie {
    private int functionalAbilitiesCitizenID;
    private String functionalAbilitiesCitizenCategoryName;
    private String functionalAbilitiesCitizenSubCategoryName;
    private int functionalAbilitiesCitizenScore;
    private int functionalAbilitiesCitizenExpectedScore;
    private String functionalAbilitiesCitizenProfessionalNote;
    private String functionalAbilitiesCitizenPerformance;
    private String functionalAbilitiesCitizenLimitation;
    private String functionalAbilitiesCitizenGoalsNote;
    private String functionalAbilitiesCitizenObservationNote;
    private LocalDate functionalAbilitiesCitizenTemplateDate;
    private int citizenID;

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

    public int getFunctionalAbilitiesCitizenID() {
        return functionalAbilitiesCitizenID;
    }

    public void setFunctionalAbilitiesCitizenID(int functionalAbilitiesCitizenID) {
        this.functionalAbilitiesCitizenID = functionalAbilitiesCitizenID;
    }

    public String getFunctionalAbilitiesCitizenCategoryName() {
        return functionalAbilitiesCitizenCategoryName;
    }

    public void setFunctionalAbilitiesCitizenCategoryName(String functionalAbilitiesCitizenCategoryName) {
        this.functionalAbilitiesCitizenCategoryName = functionalAbilitiesCitizenCategoryName;
    }

    public String getFunctionalAbilitiesCitizenSubCategoryName() {
        return functionalAbilitiesCitizenSubCategoryName;
    }

    public void setFunctionalAbilitiesCitizenSubCategoryName(String functionalAbilitiesCitizenSubCategoryName) {
        this.functionalAbilitiesCitizenSubCategoryName = functionalAbilitiesCitizenSubCategoryName;
    }

    public int getFunctionalAbilitiesCitizenScore() {
        return functionalAbilitiesCitizenScore;
    }

    public void setFunctionalAbilitiesCitizenScore(int functionalAbilitiesCitizenScore) {
        this.functionalAbilitiesCitizenScore = functionalAbilitiesCitizenScore;
    }

    public int getFunctionalAbilitiesCitizenExpectedScore() {
        return functionalAbilitiesCitizenExpectedScore;
    }

    public void setFunctionalAbilitiesCitizenExpectedScore(int functionalAbilitiesCitizenExpectedScore) {
        this.functionalAbilitiesCitizenExpectedScore = functionalAbilitiesCitizenExpectedScore;
    }

    public String getFunctionalAbilitiesCitizenProfessionalNote() {
        return functionalAbilitiesCitizenProfessionalNote;
    }

    public void setFunctionalAbilitiesCitizenProfessionalNote(String functionalAbilitiesCitizenProfessionalNote) {
        this.functionalAbilitiesCitizenProfessionalNote = functionalAbilitiesCitizenProfessionalNote;
    }

    public String getFunctionalAbilitiesCitizenPerformance() {
        return functionalAbilitiesCitizenPerformance;
    }

    public void setFunctionalAbilitiesCitizenPerformance(String functionalAbilitiesCitizenPerformance) {
        this.functionalAbilitiesCitizenPerformance = functionalAbilitiesCitizenPerformance;
    }

    public String getFunctionalAbilitiesCitizenLimitation() {
        return functionalAbilitiesCitizenLimitation;
    }

    public void setFunctionalAbilitiesCitizenLimitation(String functionalAbilitiesCitizenLimitation) {
        this.functionalAbilitiesCitizenLimitation = functionalAbilitiesCitizenLimitation;
    }

    public String getFunctionalAbilitiesCitizenGoalsNote() {
        return functionalAbilitiesCitizenGoalsNote;
    }

    public void setFunctionalAbilitiesCitizenGoalsNote(String functionalAbilitiesCitizenGoalsNote) {
        this.functionalAbilitiesCitizenGoalsNote = functionalAbilitiesCitizenGoalsNote;
    }

    public String getFunctionalAbilitiesCitizenObservationNote() {
        return functionalAbilitiesCitizenObservationNote;
    }

    public void setFunctionalAbilitiesCitizenObservationNote(String functionalAbilitiesCitizenObservationNote) {
        this.functionalAbilitiesCitizenObservationNote = functionalAbilitiesCitizenObservationNote;
    }

    public LocalDate getFunctionalAbilitiesCitizenTemplateDate() {
        return functionalAbilitiesCitizenTemplateDate;
    }

    public void setFunctionalAbilitiesCitizenTemplateDate(LocalDate functionalAbilitiesCitizenTemplateDate) {
        this.functionalAbilitiesCitizenTemplateDate = functionalAbilitiesCitizenTemplateDate;
    }

    public int getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }
}
