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
    public int setSchool(int school1){ school = school1; return 0; }

    public String getName() {
        return name;
    }
    public String setName(String name1){
        name = name1;
        return null;
    }

    public String getUsername() {
        return username;
    }
    public String setUsername(String username1) {
        username = username1;
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", typeOfUser=" + typeOfUser + ", school=" + school + ", userName=" + name + ", username=" + username + ", password=" + password + '}';
    }


}
