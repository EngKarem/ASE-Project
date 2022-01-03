package com.example.demo.models;

public class Driver extends User{

    String driving_license ,nationalID;
    int AvgRate;

    public Driver(int id,String username, String email, String pass, String mobileNumber,String Type, String driving_license, String nationalID) {
        super(id,username, email, pass, mobileNumber,Type);
        this.driving_license = driving_license;
        this.nationalID = nationalID;
        Verified = "Pending";

    }

    public String getNationalID() {
        return nationalID;
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
                "\nStatus: " + Verified;
    }

}