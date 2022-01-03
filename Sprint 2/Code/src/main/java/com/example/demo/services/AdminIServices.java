package com.example.demo.services;

import com.example.demo.models.Offers;
import com.example.demo.models.PassengersRequests;
import com.example.demo.models.User;

import java.util.ArrayList;

public interface AdminIServices {
    boolean suspend(String type,int id);
    boolean Activate(String type,int id);
    boolean AddAreaDiscount(String area);
    ArrayList<String> getAreaDiscount();
    ArrayList<User> viewAllUsers();
    ArrayList<Offers> viewAlRides();
    ArrayList<PassengersRequests> viewAlRequests();
    ArrayList<User> getPendingUsers();
}
