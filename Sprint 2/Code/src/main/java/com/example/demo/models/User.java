package com.example.demo.models;

public class User {

    int userid;
    String username, mobileNumber, email, password, type, Verified;
    public User(int id,String name, String email, String pass, String mobileNumber, String Type) {
        this.userid = id;
        this.username = name;
        this.email = email;
        this.password = pass;
        this.mobileNumber = mobileNumber;
        this.type = Type;
        Verified = "Activated";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getID()
    {
        return userid;
    }

    public void setActivateStat(String stat) {
        Verified = stat;
    }

}
