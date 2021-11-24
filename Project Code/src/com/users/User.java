package com.users;

public class User {
    int userid;
    String username;
    String mobileNumber;
    String email;
    String password;
    String type;
    boolean Verified;

    public User(int id,String name, String email, String pass, String mobileNumber, String Type) {
        this.userid = id;
        this.username = name;
        this.email = email;
        this.password = pass;
        this.mobileNumber = mobileNumber;
        this.type = Type;
        Verified = true;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getID()
    {
        return userid;
    }

    public void setActivateStat(boolean stat) {
        Verified = stat;
    }

    public String isActivated() {
        if(Verified)
        {
            return "Activated";
        }else
            return "Pending";
    }
}
