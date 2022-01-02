package com.example.demo.models;

public class Rating {
    String PassengerName, driverId;
    int Rate;
    public Rating(String PassengerName,String driverId, int Rate)
    {
        this.PassengerName = PassengerName;
        this.driverId = driverId;
        this.Rate = Rate;
    }

    public String getPassengerName()
    {
        return PassengerName;
    }

    public String getDriverId()
    {
        return driverId;
    }

    public int getRate()
    {
        return Rate;
    }
}
