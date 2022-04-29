package be;

public class CitizenTemplate {
    int citizenTemplateId;
    String citizenTemplateGeneralInformation;
    String citizenTemplateHealthConditions;
    String citizenTemplateFunctionalAbilities;
    int schoolId;

    public CitizenTemplate(int citizenTemplateId, String citizenTemplateGeneralInformation, String citizenTemplateHealthConditions, String citizenTemplateFunctionalAbilities, int schoolId) {
        this.citizenTemplateId = citizenTemplateId;
        this.citizenTemplateGeneralInformation = citizenTemplateGeneralInformation;
        this.citizenTemplateHealthConditions = citizenTemplateHealthConditions;
        this.citizenTemplateFunctionalAbilities = citizenTemplateFunctionalAbilities;
        this.schoolId = schoolId;
    }

    public int getCitizenTemplateId() {
        return citizenTemplateId;
    }

    public String getCitizenTemplateGeneralInformation() {
        return citizenTemplateGeneralInformation;
    }

    public String getCitizenTemplateHealthConditions() {
        return citizenTemplateHealthConditions;
    }

    public String getCitizenTemplateFunctionalAbilities() {
        return citizenTemplateFunctionalAbilities;
    }

    public int getSchoolId() {
        return schoolId;
    }

    @Override
    public String toString() {
        return "CitizenTemplate{" + "citizenTemplateId=" + citizenTemplateId + ", citizenTemplateGeneralInformation=" + citizenTemplateGeneralInformation + ", citizenTemplateHealthConditions=" + citizenTemplateHealthConditions + ", citizenTemplateFunctionalAbilities=" + citizenTemplateFunctionalAbilities + ", schoolId=" + schoolId + '}';
    }
}
