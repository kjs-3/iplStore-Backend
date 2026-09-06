package com.example.ipljerseystore.userentity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="user_password")
    private String userPassword;
    @Column(name="user_phonenumber")
    private long userPhno;
    @Enumerated(EnumType.STRING)
    @Column(name="user_role")
    @Builder.Default
    private Role role=Role.user;
    @Column(name = "created_at")
    private LocalDateTime ldc=LocalDateTime.now();
    public enum Role{
        user,admin
    }
    public long getUserId() {
        return userId;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserPhno() {
        return userPhno;
    }

    public void setUserPhno(long userPhno) {
        this.userPhno = userPhno;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getLdc() {
        return ldc;
    }

    public void setLdc(LocalDateTime ldc) {
        this.ldc = ldc;
    }

}
