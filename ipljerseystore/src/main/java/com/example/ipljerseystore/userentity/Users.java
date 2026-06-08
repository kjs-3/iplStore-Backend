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
}
