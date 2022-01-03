package com.example.demo.services;

import com.example.demo.models.Driver;
import com.example.demo.models.Passenger;
import com.example.demo.models.User;

public interface RegisterIServices {
    String login(User user);
    Boolean PassengerSignUp(Passenger passenger);
    Boolean DriverSignUp(Driver driver);
}
