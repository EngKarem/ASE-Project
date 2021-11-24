package com.users;

import java.util.ArrayList;

import java.util.Scanner;

public class Driver extends User implements DriverOptions{

    String driving_license ;
    String nationalID;
    int AvgRate;
    ArrayList<String> FavArea;

    public Driver(int id,String username, String email, String pass, String mobileNumber,String Type, String driving_license, String nationalID) {
        super(id,username, email, pass, mobileNumber,Type);
        this.driving_license = driving_license;
        this.nationalID = nationalID;
        Verified = false;
        FavArea = new ArrayList<>();
    }

    public ArrayList<String> getFavArea() {
        return FavArea;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setDriving_license(String drivingLicense) {
        this.driving_license = drivingLicense;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public void setAvgRate(int AvgRate) {
        this.AvgRate = AvgRate;
    }

    public int getAvgRate() {
        return AvgRate;
    }

    @Override
    public String toString(){
        return  "\nDriver ID: "+ getID() +
                "\n=========================================="+
                "\nUsername: "+ getUsername() +
                "\nEmail: "+ getEmail()+
                "\nPassword: "+ getPassword()+
                "\nPhone: "+ getMobileNumber()+
                "\nDrivingLicense: "+ getDriving_license()+
                "\nNationalID: "+ getNationalID()+
                "\nStatus: " + isActivated();
    }

    @Override
    public void addAreas() {
        boolean Flag =true;
        while(Flag)
        {
            System.out.println("Enter your Favourite Area");
            Scanner scanner = new Scanner(System.in);
            String area = scanner.nextLine();
            FavArea.add(area);
            System.out.println("Do you want to add another one (Y/N)");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("N")) {
                Flag = false;
            }
        }
    }
}