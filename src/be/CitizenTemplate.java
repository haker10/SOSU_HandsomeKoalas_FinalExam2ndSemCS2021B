package be;

public class CitizenTemplate {
    int citizenTemplateId;
    int schoolId;
    String citizenTemplateName;

    public CitizenTemplate(int citizenTemplateId, int schoolId, String citizenTemplateName) {
        this.citizenTemplateId = citizenTemplateId;
        this.schoolId = schoolId;
        this.citizenTemplateName = citizenTemplateName;
    }

    public int getCitizenTemplateId() {
        return citizenTemplateId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public String getCitizenTemplateName() {
        return citizenTemplateName;
    }

    @Override
    public String toString() {
        return "CitizenTemplate{" + "citizenTemplateId=" + citizenTemplateId + ", schoolId=" + schoolId + '}';
    }
}
