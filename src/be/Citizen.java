package be;

public class Citizen {
    int citizenId;
    int citizenTemplateId;

    public Citizen(int citizenId, int citizenTemplateId) {
        this.citizenId = citizenId;
        this.citizenTemplateId = citizenTemplateId;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public int getCitizenTemplateId() {
        return citizenTemplateId;
    }

    @Override
    public String toString() {
        return "Citizen{" + "citizenId=" + citizenId + ", citizenTemplateId=" + citizenTemplateId + '}';
    }
}
