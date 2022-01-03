package com.example.demo.Persistence;

import com.example.demo.models.*;

import java.util.ArrayList;

public class SystemDB implements AccessDB{

    private final ArrayList<Passenger> Passengers;

    private final ArrayList<Driver> Drivers;
    private final ArrayList<Admin> Admins;
    private final ArrayList<Offers> DriverOffers;
    private final ArrayList<Rating> rates;
    private final ArrayList<PassengersRequests> Requests;
    private static volatile SystemDB db;
    private static  ArrayList<String> discountArea;
    private static  ArrayList<String> PublicHoliday;
    private static  ArrayList<FavouriteArea> FavouriteArea;

    private SystemDB(){
        Passengers = new ArrayList<>();
        Drivers = new ArrayList<>();
        Admins = new ArrayList<>();
        DriverOffers = new ArrayList<>();
        rates = new ArrayList<>();
        Requests = new ArrayList<>();
        discountArea = new ArrayList<>();
        FavouriteArea=new ArrayList<>();
        PublicHoliday = new ArrayList<>();
        PublicHoliday.add("3/3");
        PublicHoliday.add("6/10");
        Passengers.add(new Passenger(1,"Kareem", "User@example.com", "123", "1241512", "User","1/1/2000"));
        Passengers.add(new Passenger(2,"ahmed", "User@example.com", "123", "1241512", "User","4/4/2000"));
        Passengers.add(new Passenger(3,"ali", "User@example.com", "123", "1241512", "User","2/2/2000"));
        Drivers.add(new Driver(1,"Mohamed", "Driver@example.com", "123", "12526134", "Driver", "sdf","12534634634613","8/8/2000"));
        Drivers.add(new Driver(2,"hassan", "Driver@example.com", "123", "12526134", "Driver", "sdf","12534634634613","5/5/2000"));
        Admins.add(new Admin("admin", "admin"));
        rates.add(new Rating("Kareem","1",5));
        PassengersRequests request = new PassengersRequests(2,"Kareem","giza", "alex","1/1/2022");
        FavouriteArea favouriteArea = new FavouriteArea("Mohamed", "giza");
        discountArea.add("alex");
        FavouriteArea.add(favouriteArea);
        Requests.add(request);
        Requests.add(new PassengersRequests(1,"Kareem","cairo", "sharm","2/3/2022"));
        DriverOffers.add(new Offers(request,"Mohamed",30));

    }

    public static SystemDB getInstance() {
        if(db == null)
        {
            synchronized (SystemDB.class)
            {
                if (db == null)
                    db = new SystemDB();
            }
        }
        return db;
    }

    @Override
    public void AddPassengers(Passenger Passenger){
        Passengers.add(Passenger);
    }

    @Override
    public void AddDrivers(Driver Driver){
        Drivers.add(Driver);
    }

    @Override
    public void AddAdmins(Admin Admin){
        Admins.add(Admin);
    }

    @Override
    public boolean AddOffers(Offers offer){
        return DriverOffers.add(offer);
    }

    @Override
    public boolean AddRating(Rating Rating){
        return rates.add(Rating);
    }

    @Override
    public boolean AddRequests(PassengersRequests request){
       return Requests.add(request);
    }

    @Override
    public boolean AddAreaDiscounts(String area){
        return discountArea.add(area);
    }

    @Override
    public boolean AddFavArea(FavouriteArea favouriteArea){
        return FavouriteArea.add(favouriteArea);
    }

    @Override
    public ArrayList<Passenger> getPassengers() { return Passengers; }

    @Override
    public ArrayList<Driver> getDrivers() { return Drivers; }

    @Override
    public ArrayList<Admin> getAdmins() { return Admins; }

    @Override
    public ArrayList<Offers> getOffers() { return DriverOffers; }

    @Override
    public ArrayList<Rating> getRating() { return rates; }

    @Override
    public ArrayList<PassengersRequests> getRequests() { return Requests; }

    @Override
    public ArrayList<String> getAreaDiscounts() { return discountArea; }

    @Override
    public ArrayList<FavouriteArea> getFavArea() { return FavouriteArea; }

    @Override
    public ArrayList<String> getPublicHoliday() { return PublicHoliday; }
}
