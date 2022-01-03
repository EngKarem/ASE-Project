package com.example.demo.services;

import com.example.demo.Persistence.SystemDB;
import com.example.demo.models.FavouriteArea;
import com.example.demo.models.Offers;
import com.example.demo.models.PassengersRequests;
import com.example.demo.models.Rating;

import java.util.ArrayList;
import java.util.HashMap;

public class DriverServices implements DriverIServices {
    SystemDB db = SystemDB.getInstance();

    @Override
    public boolean addAreas(FavouriteArea favouriteArea) {
        return db.AddFavArea(favouriteArea);
    }

    @Override
    public boolean AddOffer(Offers offer) {

        return db.AddOffers(offer);
    }

    @Override
    public ArrayList<String> getFavAreas(String name) {
        ArrayList<String> favouriteAreas = new ArrayList<>();
        for(FavouriteArea favouriteArea: db.getFavArea())
        {
            if(favouriteArea.name.equals(name))
            {
                favouriteAreas.add(favouriteArea.Area);
            }
        }

        return favouriteAreas;
    }

    @Override
    public ArrayList<PassengersRequests> getUserRequests(String name) {
        ArrayList<PassengersRequests> requests = new ArrayList<>();
        for (PassengersRequests Request : db.getRequests())
        {
            System.out.println(1);
            for (FavouriteArea favouriteArea: db.getFavArea())
            {
                System.out.println(2);
                if(favouriteArea.name.equals(name))
                {
                    System.out.println(3);
                    if(favouriteArea.Area.equals(Request.getSrcName()))
                    {
                        System.out.println(4);
                        requests.add(Request);
                    }
                }
            }
        }

        return requests;
    }

    @Override
    public HashMap<String, String> viewRatings(String id) {
        var map = new HashMap<String, String>();
        for (Rating rate : db.getRating())
        {
            System.out.println(rate.getDriverId());
            System.out.println(id);
            if(rate.getDriverId().equals(id))
                map.put(rate.getPassengerName(), String.valueOf(rate.getRate()));
        }
        return map;
    }

    @Override
    public int CalcAvgRating(String id) {
        int idx =Integer.parseInt(id);
        int avg = 0, cont = 0,sum = 0;
        for (Rating rate : db.getRating())
        {
            if(rate.getDriverId().equals(id))
            {
                ++cont;
                sum = sum + rate.getRate();
                avg = sum/cont;
            }
        }
        db.getDrivers().get(idx-1).setAvgRate(avg);
        System.out.println(db.getDrivers().get(idx-1).getUsername());
        System.out.println(db.getDrivers().get(idx-1).getEmail());
        System.out.println(db.getDrivers().get(idx-1).getAvgRate());
        return avg;
    }

    @Override
    public String CheckNotification(String name) {
        for(FavouriteArea favouriteArea: db.getFavArea())
            if(favouriteArea.name.equals(name))
                for (PassengersRequests Request:db.getRequests())
                    if(Request.getSrcName().equals(favouriteArea.Area))
                        return "There Passenger nearby";
        return "No Passenger nearby";
    }
}
