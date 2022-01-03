package com.example.demo.models;

import java.time.LocalTime;

public class Offers {
    PassengersRequests request;
    String DriverName, Status;
    int Price, OfferNum;
    static int OffNum = 0;
    public LocalTime time;


    public Offers(PassengersRequests passengersRequests,String DriverName, int Price) {
        this.request = passengersRequests;
        this.DriverName = DriverName;
        this.Price = Price;
        this.Status="pending";
        this.OfferNum= ++OffNum;
        time = LocalTime.now();
    }

    public String getDriverName()
    {
        return DriverName;
    }

    public int getPrice()
    {
        return Price;
    }

    public String getStatus()
    {
        return Status;
    }

    public PassengersRequests getRequest()
    {
        return request;
    }

    public void setStatus(String res) {
        this.Status = res;
    }

    public int getOffNum() {
        return OfferNum;
    }
}
