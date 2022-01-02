package com.system;

import com.users.*;

import java.util.ArrayList;

public class SystemDB {

    ArrayList<Passenger> Passengers;
    ArrayList<Driver> Drivers;
    ArrayList<Admin> Admins;
    ArrayList<Offers> DriverOffers;
    ArrayList<Rating> rates;
    ArrayList<PassengersRequests> Requests;

    public SystemDB(){
        Passengers = new ArrayList<>();
        Drivers = new ArrayList<>();
        Admins = new ArrayList<>();
        DriverOffers = new ArrayList<>();
        rates = new ArrayList<>();
        Requests = new ArrayList<>();

        Passengers.add(new Passenger(1,"Kareem", "User@example.com", "123", "1241512", "User"));
        Passengers.add(new Passenger(2,"ahmed", "User@example.com", "123", "1241512", "User"));
        Passengers.add(new Passenger(3,"ali", "User@example.com", "123", "1241512", "User"));
        Drivers.add(new Driver(1,"Mohamed", "Driver@example.com", "123", "12526134", "Driver", "sdf","12534634634613"));
        Drivers.add(new Driver(2,"hassan", "Driver@example.com", "123", "12526134", "Driver", "sdf","12534634634613"));
        Admins.add(new Admin("admin", "admin"));
    }

    public ArrayList<Passenger> getUsers()
    {
        return Passengers;
    }

    public ArrayList<Driver> getDrivers()
    {
        return Drivers;
    }

    public ArrayList<Admin> getAdmins()
    {
        return Admins;
    }

    public ArrayList<Offers> getOffers()
    {
        return DriverOffers;
    }

    public ArrayList<Rating> getRating()
    {
        return rates;
    }

    public ArrayList<PassengersRequests> getRequests()
    {
        return Requests;
    }

}
