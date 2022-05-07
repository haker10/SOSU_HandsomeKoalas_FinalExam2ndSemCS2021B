package be;

public class CitizenTemplate {
    int citizenTemplateId;
    int schoolId;

    public CitizenTemplate(int citizenTemplateId, int schoolId) {
        this.citizenTemplateId = citizenTemplateId;
        this.schoolId = schoolId;
    }

    public int getCitizenTemplateId() {
        return citizenTemplateId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    @Override
    public String toString() {
        return "CitizenTemplate{" + "citizenTemplateId=" + citizenTemplateId + ", schoolId=" + schoolId + '}';
    }
}
