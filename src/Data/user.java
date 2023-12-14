package Data;

import java.util.ArrayList;
import java.util.List;

public class user {
    private static List<user> userList = new ArrayList<>();
    private String fullName;
    private String username;
    private String password;
    private String email;
    private int phone;
    public user(String username, String password, String email, int phone, String fullName) {
        this.fullName = fullName;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;

        userList.add(this);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private static void addUserToDatabase(user user) {
        userList.add(user);
    }

    public static List<user> getAllUsers() {
        return userList;
    }

    
}
