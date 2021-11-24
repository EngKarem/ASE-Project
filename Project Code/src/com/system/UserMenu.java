package com.system;

import java.util.Scanner;

public class UserMenu{

    private final Scanner scanner = new Scanner(System.in);
    SystemDB db;
    int currentUser;

    public UserMenu(SystemDB db,int currentUser) {
        this.db = db;
        this.currentUser = currentUser;
        Menu();
    }

    public void Menu() {
        String option;
        while (true) {
            System.out.println("\n1- request a ride" +
                    "\n2- rate Driver" +
                    "\n3- Drivers offers" +
                    "\n4- Logout");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("4"))
                break;
            if (db.getUsers().get(currentUser).isActivated().equals("Activated"))
            {
                if (option.equalsIgnoreCase("1"))
                    db.getUsers().get(currentUser).requestRide(db.getRequests());
                else if (option.equalsIgnoreCase("2"))
                    db.getUsers().get(currentUser).RateDriver(db.getDrivers(),db.getRating());
                else if (option.equalsIgnoreCase("3"))
                    getOffers();
                else
                    System.out.println("***Enter valid option***\n");

            }
            else
                System.out.println("You need to be activated");
        }
        System.out.println("\nLogging out ...");
    }

    public void getOffers() {
        for (Offers offer : db.getOffers())
        {
            if(offer.PassengerName.equals(db.getUsers().get(currentUser).getUsername()))
            {
                System.out.println("Driver name: " + offer.Driver.getUsername());
                System.out.println("Mobile Number: " + offer.Driver.getMobileNumber());
                System.out.println("Avg Rate: " + offer.Driver.getAvgRate() + " *");
                System.out.println("Ride Price: " + offer.Price);
                System.out.println("=====================");
            }
        }
    }
}