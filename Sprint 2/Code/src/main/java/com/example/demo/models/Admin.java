package com.example.demo.models;


public class Admin {

    private final String username, password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void Activate(User user) { user.setActivateStat("Activated"); }

    public boolean isActivated(User user) { return user.Verified.equals("Activated"); }

}