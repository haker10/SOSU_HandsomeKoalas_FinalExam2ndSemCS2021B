package be;

public class User {
    int userId;
    int typeOfUser;
    int school;
    String name;
    String username;
    String password;

    public User(int userId, int typeOfUser, int school, String name, String username, String password) {
        this.userId = userId;
        this.typeOfUser = typeOfUser;
        this.school = school;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public int getTypeOfUser() {
        return typeOfUser;
    }

    public int getSchool() {
        return school;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", typeOfUser=" + typeOfUser + ", school=" + school + ", userName=" + name + ", username=" + username + ", password=" + password + '}';
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setUsername(String newUserName) {
        username = newUserName;
    }

    public void setSchool(Integer newSchool) {
        school = newSchool;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

}
