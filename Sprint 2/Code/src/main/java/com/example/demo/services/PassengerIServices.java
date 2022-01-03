package com.example.demo.services;

import com.example.demo.models.PassengersRequests;
import com.example.demo.models.Rating;

import java.util.ArrayList;

public interface PassengerIServices {
    boolean requestRide(PassengersRequests request);
    boolean RateDriver(Rating rate);
    ArrayList<String> CalcDiscount(int offerNum ,int id);
    boolean ResponseOffer(int num, String res);
    ArrayList<String> getOffers(String name);
}
