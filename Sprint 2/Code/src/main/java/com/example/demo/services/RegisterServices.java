package com.example.demo.services;

import com.example.demo.Persistence.SystemDB;
import com.example.demo.models.Admin;
import com.example.demo.models.Driver;
import com.example.demo.models.Passenger;
import com.example.demo.models.User;

public class RegisterServices implements RegisterIServices {
    SystemDB db = SystemDB.getInstance();

    @Override
    public String login(User userRig) {
        String message = "not Found";
        for (Passenger user: db.getPassengers()) {
            if (user.getUsername().equalsIgnoreCase(userRig.getUsername()) && user.getPassword().equals(userRig.getPassword())) {
                message = "Welcome " + user.getUsername();
            }
        }
        for (Driver driver: db.getDrivers()) {
            if (driver.getUsername().equalsIgnoreCase(userRig.getUsername()) && driver.getPassword().equals(userRig.getPassword())) {
                message = "Welcome " + driver.getUsername();
                break;
            }
        }
        for (Admin admin: db.getAdmins()) {
            if (admin.getUsername().equalsIgnoreCase(userRig.getUsername()) && admin.getPassword().equalsIgnoreCase(userRig.getPassword())) {
                message = "Welcome " + admin.getUsername();
                break;
            }
        }
        return message;
    }

    @Override
    public Boolean PassengerSignUp(Passenger passenger) {
        db.AddPassengers(new Passenger(passenger.getID(), passenger.getUsername(), passenger.getEmail(), passenger.getPassword(), passenger.getMobileNumber(),"User",passenger.getBirtDate()));
        return true;
    }

    @Override
    public Boolean DriverSignUp(Driver driver) {
        db.AddDrivers(new Driver(driver.getID(), driver.getUsername(), driver.getEmail(), driver.getPassword(), driver.getMobileNumber(),"Driver",driver.getBirtDate(),driver.getDriving_license(), driver.getNationalID()));
        return true;
    }
}
