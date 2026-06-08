package com.example.ipljerseystore.session;

import jakarta.servlet.http.HttpSession;

public class Session {
    public static boolean isLoggedin(HttpSession session){
        return session.getAttribute("userId")!=null;
    } //to check who is logged in
    public static boolean isAdmin(HttpSession session){
        Object r=session.getAttribute("userRole"); //admin
        return r!=null && r.toString().equals("ADMIN");
    }
    public static  boolean isUser(HttpSession session){
        Object r=session.getAttribute("userRole"); //user
        return r!=null && r.toString().equals("USER");
    }
    public static long getuserId(HttpSession session){
        return (Long) session.getAttribute("userId");

    }



}
