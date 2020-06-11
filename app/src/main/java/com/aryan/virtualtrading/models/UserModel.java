package com.aryan.virtualtrading.models;

import android.net.Uri;

public class UserModel {

    private String fullName, username, admin, password;
    private long phone;

//    private Uri profile;
//    private String permissions;


    public UserModel(String fullName, String username, String admin, String password, long phone) {
        this.fullName = fullName;
        this.username = username;
        this.admin = admin;
        this.password = password;
        this.phone = phone;
    }

    public UserModel(long phone, String password) {
        this.phone = phone;
        this.password = password;
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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
