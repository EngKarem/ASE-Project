package com.users;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements AdminOptions {

    private final String username;
    private final String password;


    public Admin(String username, String password) {
        this.username = username;
        this.password = password;


    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public void suspend(ArrayList<Passenger> passengers,ArrayList<Driver> drivers) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the type of account: " +
                "\n1- User" +
                "\n2- Driver");

        String option = input.nextLine();
        if (option.equals("1")) {
            System.out.println("Enter the ID of User: ");
            int id = input.nextInt();
            for (Passenger user : passengers)
            {
                if(user.getID() == id)
                {
                    user.setActivateStat(false);
                    System.out.println("User Suspended");
                }
                else
                {
                    System.out.println("User not found");
                }
            }
        } else if (option.equals("2")) {
            System.out.println("Enter the ID of Driver: ");
            int id = input.nextInt();
            for (Driver driver : drivers)
            {
                if(driver.getID() == id)
                {
                    driver.setActivateStat(false);
                    System.out.println("Driver Suspended");
                }
                else
                {
                    System.out.println("User not found");
                }
            }
        }
    }

}