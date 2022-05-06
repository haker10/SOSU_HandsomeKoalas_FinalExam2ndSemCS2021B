package be;

public class School {
    int schoolID;
    String school;

    public School(int schoolID, String school) {
        this.schoolID = schoolID;
        this.school = school;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return school;
    }
}