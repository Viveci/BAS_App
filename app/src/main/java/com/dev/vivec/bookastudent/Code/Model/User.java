package com.dev.vivec.bookastudent.Code.Model;

/**
 * Created by user on 1/6/2016.
 */
public class User {

    private String username;
    private String CPR;
    private String email;
    private String role;

    public User(String username, String CPR, String email, String role) {
        this.username = username;
        this.CPR = CPR;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
