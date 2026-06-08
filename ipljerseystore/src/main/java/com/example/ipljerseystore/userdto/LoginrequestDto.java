package com.example.ipljerseystore.userdto;

public class LoginrequestDto {
    private String userEmail;
    private String userPassword;

    public LoginrequestDto() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LoginrequestDto(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
