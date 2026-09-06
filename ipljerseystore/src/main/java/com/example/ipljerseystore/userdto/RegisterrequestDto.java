package com.example.ipljerseystore.userdto;

public class RegisterrequestDto{
    private String userName;
    private String userEmail;
    private String userPassword;
    private Long userPhonenumber;

    public RegisterrequestDto() {
    }

    public RegisterrequestDto(String userName, String userEmail, String userPassword, long userPhonenumber) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhonenumber = userPhonenumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
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

    public Long getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(Long userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }
}
