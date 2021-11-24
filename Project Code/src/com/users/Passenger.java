package com.users;

import com.system.PassengersRequests;
import com.system.Rating;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger extends User implements PassengerOptions{

    static int ReqNum = 0;
    public Passenger(int id,String name, String email, String pass, String mobileNumber, String Type) {
        super(id,name,email,pass,mobileNumber,Type);
    }

    @Override
    public String toString(){
        return  "\nPassenger ID: "+ getID() +
                "\n=========================================="+
                "\nUsername: "+ getUsername() +
                "\nEmail: "+ getEmail()+
                "\nPassword: "+ getPassword()+
                "\nPhone: "+ getMobileNumber()+
                "\nStatus: " + isActivated();
    }

    @Override
    public void requestRide(ArrayList<PassengersRequests> Requests) {
        ReqNum++;
        System.out.println("Enter the Source");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("Enter the Destination");
        String des = scanner.nextLine();

        Requests.add(new PassengersRequests(this.username,src,des,ReqNum));

        System.out.println("Your Request added Successfully");

    }

    @Override
    public void RateDriver(ArrayList<Driver> drivers,ArrayList<Rating> rates) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        for (Driver driver : drivers)
        {
            if(driver.isActivated().equals("Activated"))
            {
                found = true;
                System.out.println("Driver ID: "+ driver.getID());
                System.out.println("Username: "+ driver.getUsername());
                System.out.println("Email: "+ driver.getEmail());
                System.out.println("Phone: "+ driver.getMobileNumber());
                System.out.println("====================================");
            }
        }
        if(found)
        {
            System.out.println("Enter the ID of the driver you want to rate");

            int id = scanner.nextInt();
            System.out.println("Rate the Driver 1..5 *");
            int userRate = scanner.nextInt();

            if(userRate>=1 && userRate <=5)
            {
                rates.add(new Rating(this.username,id,userRate));

                System.out.println("Thanks for Rating");
            }
            else {
                System.out.println("***Enter valid Rating***\n");
            }
        }
        else
            System.out.println("There are no available drivers");
    }
}