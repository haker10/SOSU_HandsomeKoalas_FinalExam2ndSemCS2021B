package be;

public class Citizen {
    int citizenId;
    int citizenTemplateId;
    String citizenName;

    public Citizen(int citizenId, int citizenTemplateId, String citizenName) {
        this.citizenId = citizenId;
        this.citizenTemplateId = citizenTemplateId;
        this.citizenName = citizenName;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public int getCitizenTemplateId() {
        return citizenTemplateId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    @Override
    public String toString() {
        return "Citizen{" + "citizenId=" + citizenId + ", citizenTemplateId=" + citizenTemplateId + '}';
    }
}
