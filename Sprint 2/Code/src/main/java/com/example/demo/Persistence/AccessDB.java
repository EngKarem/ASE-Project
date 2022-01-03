package com.example.demo.Persistence;

import com.example.demo.models.*;

import java.util.ArrayList;

 interface AccessDB {

    void AddPassengers(Passenger Passenger);
    ArrayList<Passenger> getPassengers();

    void AddDrivers(Driver Driver);
    ArrayList<Driver> getDrivers();

    void AddAdmins(Admin Admin);
    ArrayList<Admin> getAdmins();

    boolean AddOffers(Offers offer);
    ArrayList<Offers> getOffers();

    boolean AddRating(Rating Rating);
    ArrayList<Rating> getRating();

    boolean AddRequests(PassengersRequests request);
    ArrayList<PassengersRequests> getRequests();

    boolean AddAreaDiscounts(String area);
    ArrayList<String> getAreaDiscounts();

    boolean AddFavArea(FavouriteArea favouriteArea);
    ArrayList<FavouriteArea> getFavArea();

    ArrayList<String> getPublicHoliday();
}
