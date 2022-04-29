package be;

public class User {
    int userId;
    String typeOfUser;
    String school;
    String name;
    String username;
    String password;

    public User(int userId, String typeOfUser, String school, String name, String username, String password) {
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

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public String getSchool() {
        return school;
    }

    public String getUserName() {
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
}
