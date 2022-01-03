package com.example.demo.services;

import com.example.demo.Persistence.SystemDB;
import com.example.demo.models.*;

import java.util.ArrayList;

public class AdminServices implements AdminIServices {
    SystemDB db = SystemDB.getInstance();

    public AdminServices() {}

    @Override
    public boolean suspend(String type,int id) {
        if (type.equals("Passenger")) {

            for (Passenger user : db.getPassengers())
            {
                if(user.getID() == id)
                {
                     user.setActivateStat("Pending");
                     System.out.println(user);
                     return true;
                }
            }
        } else if (type.equals("Driver")) {
            for (Driver driver : db.getDrivers())
            {
                if(driver.getID() == id)
                {
                    driver.setActivateStat("Pending");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean AddAreaDiscount(String area) {
//        System.out.println("Enter Area for Discount");
//        String area = input.next();
        return db.AddAreaDiscounts(area);
    }

    @Override
    public ArrayList<String> getAreaDiscount(){
        return db.getAreaDiscounts();
    }

    @Override
    public ArrayList<User> viewAllUsers() {
        ArrayList<User> Users = new ArrayList<>();
        Users.addAll(db.getDrivers());
        Users.addAll(db.getPassengers());
        return Users;
    }

    @Override
    public ArrayList<Offers> viewAlRides() {
        return db.getOffers();
    }

    @Override
    public ArrayList<User> getPendingUsers() {
        ArrayList<User> PendingUsers = new ArrayList<>();
        for (Driver driver : db.getDrivers())
        {
            if(!db.getAdmins().get(0).isActivated(driver))
            {
                PendingUsers.add(driver);
            }
        }

        for (Passenger passenger : db.getPassengers()) {
            if(!db.getAdmins().get(0).isActivated(passenger))
            {
                PendingUsers.add(passenger);
            }
        }
        return PendingUsers;
    }
}
