package com.aryan.virtualtrading.models;

import android.net.Uri;

public class UserModel {

    private String fullname, username, email, phone, password;
    private Uri profile;
    private String permissions;

    public UserModel(String fullname, String username, String email, String phone, String password, Uri profile) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profile = profile;
    }

    public UserModel(String fullname, String username, String email, String password, Uri profile) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public UserModel(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public UserModel(String email, String password, Uri profile) {
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public UserModel(Uri picture, String name,
                     String id, String email, String permissions) {
        this.profile = picture;
        this.fullname = name;
        this.email = email;
        this.permissions = permissions;
    }
    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Uri getProfile() {
        return profile;
    }

    public void setProfile(Uri profile) {
        this.profile = profile;
    }
}
