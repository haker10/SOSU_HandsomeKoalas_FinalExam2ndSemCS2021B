package be;

public class CitizenTemplate {
    int citizenTemplateId;
    String citizenTemplateGeneralInformation;
    String citizenTemplateFunctionalAbilities;
    int schoolId;

    public CitizenTemplate(int citizenTemplateId, String citizenTemplateGeneralInformation, String citizenTemplateFunctionalAbilities, int schoolId) {
        this.citizenTemplateId = citizenTemplateId;
        this.citizenTemplateGeneralInformation = citizenTemplateGeneralInformation;
        this.citizenTemplateFunctionalAbilities = citizenTemplateFunctionalAbilities;
        this.schoolId = schoolId;
    }

    public int getCitizenTemplateId() {
        return citizenTemplateId;
    }

    public String getCitizenTemplateGeneralInformation() {
        return citizenTemplateGeneralInformation;
    }

    public String getCitizenTemplateFunctionalAbilities() {
        return citizenTemplateFunctionalAbilities;
    }

    public int getSchoolId() {
        return schoolId;
    }

    @Override
    public String toString() {
        return "CitizenTemplate{" + "citizenTemplateId=" + citizenTemplateId + ", citizenTemplateGeneralInformation=" + citizenTemplateGeneralInformation + ", citizenTemplateFunctionalAbilities=" + citizenTemplateFunctionalAbilities + ", schoolId=" + schoolId + '}';
    }
}
