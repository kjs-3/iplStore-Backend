package com.example.ipljerseystore.userdto;

public class Userresponse {
    private long userId;
    private String userName;
    private String userEmail;
    private Long userPhonenumber;
    private String role;

    public Userresponse() {
    }

    public long getUserId() {
        return userId;
    }

    public Userresponse(long userId, String userName, String userEmail, long userPhonenumber, String role, String message) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhonenumber = userPhonenumber;
        this.role = role;
        this.message = message;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public long getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(Long userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
