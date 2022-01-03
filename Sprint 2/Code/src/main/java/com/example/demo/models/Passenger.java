package com.example.demo.models;

public class Passenger extends User{


    public Passenger(int id,String name, String email, String pass, String mobileNumber, String Type) {
        super(id,name,email,pass,mobileNumber,Type);
    }
    @Override
    public String toString(){
        return  "\nPassenger ID: "+ getID() +
                "\n=========================================="+
                "\nUsername: "+ getUsername() +
                "\nEmail: "+ getEmail()+
                "\nPassword: "+ getPassword()+
                "\nPhone: "+ getMobileNumber()+
                "\nStatus: " + Verified;
    }
}