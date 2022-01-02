package com.system;

import com.users.Driver;

public class Offers {
    String PassengerName;
    Driver Driver;
    int Price;


    public Offers(String PassengerName,Driver Driver, int Price)
    {
        this.PassengerName = PassengerName;
        this.Driver = Driver;
        this.Price = Price;
    }
}
