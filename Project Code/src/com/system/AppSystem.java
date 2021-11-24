package com.system;

public class AppSystem {

    MainMenu Menu;
    SystemDB db;

    public AppSystem() {
        db = new SystemDB();
        Menu = new MainMenu(db);
    }
    public static void main(String[] args) {
        AppSystem Sys = new AppSystem();
    }
}
