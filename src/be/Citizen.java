package be;

public class Citizen {
    int citizenId;
    int citizenTemplateId;
    String citizenGeneralInformation;
    String citizenHealthConditions;
    String citizenFunctionalAbilities;

    public Citizen(int citizenId, int citizenTemplateId, String citizenGeneralInformation, String citizenHealthConditions, String citizenFunctionalAbilities) {
        this.citizenId = citizenId;
        this.citizenTemplateId = citizenTemplateId;
        this.citizenGeneralInformation = citizenGeneralInformation;
        this.citizenHealthConditions = citizenHealthConditions;
        this.citizenFunctionalAbilities = citizenFunctionalAbilities;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public int getCitizenTemplateId() {
        return citizenTemplateId;
    }

    public String getCitizenGeneralInformation() {
        return citizenGeneralInformation;
    }

    public String getCitizenHealthConditions() {
        return citizenHealthConditions;
    }

    public String getCitizenFunctionalAbilities() {
        return citizenFunctionalAbilities;
    }

    @Override
    public String toString() {
        return "Citizen{" + "citizenId=" + citizenId + ", citizenTemplateId=" + citizenTemplateId + ", citizenGeneralInformation=" + citizenGeneralInformation + ", citizenHealthConditions=" + citizenHealthConditions + ", citizenFunctionalAbilities=" + citizenFunctionalAbilities + '}';
    }
}
