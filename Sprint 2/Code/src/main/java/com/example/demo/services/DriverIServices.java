package com.example.demo.services;

import com.example.demo.models.FavouriteArea;
import com.example.demo.models.Offers;
import com.example.demo.models.PassengersRequests;


import java.util.ArrayList;
import java.util.HashMap;

public interface DriverIServices {
   boolean addAreas(FavouriteArea favouriteArea);
   boolean AddOffer(Offers offer);
   String CheckNotification(String name);
   ArrayList<String> getFavAreas(String name);
   ArrayList<PassengersRequests> getUserRequests(String name);
   HashMap<String, String> viewRatings(String id);
   int CalcAvgRating(String id);
}
