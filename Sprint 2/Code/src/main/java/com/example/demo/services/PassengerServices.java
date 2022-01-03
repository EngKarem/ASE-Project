package com.example.demo.services;

import com.example.demo.Persistence.SystemDB;
import  com.example.demo.models.*;

import java.util.ArrayList;
import java.util.Objects;

public class PassengerServices implements PassengerIServices{

    SystemDB db = SystemDB.getInstance();

    @Override
    public boolean requestRide(PassengersRequests request) {
        System.out.println(request.toString());
        return db.AddRequests(request);
    }

    @Override
    public boolean RateDriver(Rating rate) {
        System.out.println(rate.getPassengerName());
        System.out.println(rate.getDriverId());
        System.out.println(rate.getRate());
        return db.AddRating(rate);
    }

    @Override
    public ArrayList<String> CalcDiscount(int offerNum ,int id) {
        ArrayList<String> Messages = new ArrayList<>();
        int price = 0;
        for (Offers offer: db.getOffers())
        {
            if(offer.getOffNum()==offerNum)
            {
                int cont = 0;
                price = offer.getPrice();
                /*Destination Discount*/
                for(PassengersRequests PassengersRequest : db.getRequests())
                    if(Objects.equals(PassengersRequest.getPassengerName(), db.getPassengers().get(id-1).getUsername()) )
                        cont++;

                if(db.getAreaDiscounts().contains(offer.getRequest().getDestName()))
                {
                    price = price - (price*10) /100;
                    Messages.add("You hava A discount 10% for this ride Destination");
                }
                /*First Ride Discount*/
                if(cont==1)
                {
                    price = price - (price*10) /100;
                    Messages.add("You hava A discount 10% for the First Ride");
                }
                /*Two Passenger Discount*/
                if(offer.getRequest().getPassengerNum()>=2)
                {
                    price = price - (price*5) /100;
                    Messages.add("You hava A discount 5% for two Passenger");
                }
            }
        }
        Messages.add("Total Cost " +String.valueOf(price));
        return Messages;
    }

    @Override
    public boolean ResponseOffer(int num, String res) {

        for (Offers offer : db.getOffers()) {
            if (offer.getOffNum() == num)
            {
                offer.setStatus(res);
                System.out.println(offer.getStatus());
                if(res.equals("Accepted"))
                {
                    offer.getRequest().setStat("Arrived");
                    db.getFavArea().removeIf(favouriteArea -> favouriteArea.name.equals(offer.getDriverName()));
                    return true;
                }else
                    offer.getRequest().setStat("Cancelled");
            }
        }
        return false;
    }

    @Override
    public ArrayList <String> getOffers(String name) {
        ArrayList <String> offers = new ArrayList<>();
        for (Offers offer : db.getOffers())
        {
            if (offer.getRequest().getPassengerName().equals(name) && offer.getStatus().equals("pending"))
            {

                offers.add("Offer Number " +String.valueOf(offer.getOffNum()));
                offers.add("Driver Name " +offer.getDriverName());
                offers.add("Price " +String.valueOf(offer.getPrice()));
            }
        }
        return offers;
    }

}
