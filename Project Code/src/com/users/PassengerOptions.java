package com.users;

import com.system.PassengersRequests;
import com.system.Rating;

import java.util.ArrayList;

public interface PassengerOptions {
    void requestRide(ArrayList<PassengersRequests> Requests);
    void RateDriver(ArrayList<Driver> drivers,ArrayList<Rating> rates);
}

