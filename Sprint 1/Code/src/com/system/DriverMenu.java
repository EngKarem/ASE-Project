package com.system;

import java.util.Scanner;

public class DriverMenu{

    private final Scanner scanner = new Scanner(System.in);
    SystemDB db;
    int currentDriver;

    public DriverMenu(SystemDB db,int currentDriver) {
        this.db = db;
        this.currentDriver = currentDriver;
        Menu();
    }

    public void Menu() {
        String option;
        CalcAvgRating();
        while (true) {
            if(CheckNotification())
            {
                System.out.println("There are passengers nearby, Check notification");
            }
            System.out.println("\n1- add Favourite areas" +
                    "\n2- View Favourite areas" +
                    "\n3- View User ratings" +
                    "\n4- View All Requests" +
                    "\n5- Notifications" +
                    "\n6- Logout");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("6"))
                break;
            if (db.getDrivers().get(currentDriver).isActivated().equals("Activated"))
            {
                if (option.equalsIgnoreCase("1"))
                    db.getDrivers().get(currentDriver).addAreas();
                else if (option.equalsIgnoreCase("2"))
                    getFavAreas();
                else if (option.equalsIgnoreCase("3"))
                    viewRatings();
                else if (option.equalsIgnoreCase("4"))
                    getUserRequests();
                else if (option.equalsIgnoreCase("5"))
                    getNotified();
                else
                    System.out.println("***Enter valid option***\n");
            }
            else
                System.out.println("You need to be activated");
        }
        System.out.println("\nLogging out ...");
    }

    public void getFavAreas() {
        for(int i=0;i< db.getDrivers().get(currentDriver).getFavArea().size();i++)
        {
            System.out.println((i+1)+"- "+db.getDrivers().get(currentDriver).getFavArea().get(i));
        }
    }


    public void getUserRequests() {
        int cont=0;
        for (PassengersRequests Request : db.getRequests())
        {
            System.out.println("Request Num: "+ ++cont);
            System.out.println("============================");
            System.out.println("Passenger Name: " + Request.PassengerName);
            System.out.println("Source: " +Request.SrcName);
            System.out.println("Destination: " +Request.DestName);
        }
        System.out.println("Do you want to add offer(Y/N)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Enter The Request Number");
            int ReqNum = scanner.nextInt();
            System.out.println("Enter Your Price");
            int price = scanner.nextInt();
            for (PassengersRequests Request : db.getRequests())
            {
                if (Request.getRequestNum()==ReqNum)
                {
                    db.getOffers().add(new Offers(Request.PassengerName,db.getDrivers().get(currentDriver),price));
                    System.out.println("Your Offer added Successfully");
                }

            }
        }
    }


    public void getNotified() {
        for(int i=0;i< db.getDrivers().get(currentDriver).getFavArea().size();i++)
        {
            for (PassengersRequests Request : db.getRequests())
            {
                if(Request.SrcName.equals(db.getDrivers().get(currentDriver).getFavArea().get(i)))
                {
                    System.out.println("============================");
                    System.out.println("Passenger Name: " + Request.PassengerName);
                    System.out.println("Source: " +Request.SrcName);
                    System.out.println("Destination: " +Request.DestName);
                }
            }
        }
    }


    public boolean CheckNotification() {
        for(int i=0;i< db.getDrivers().get(currentDriver).getFavArea().size();i++)
        {
            for (PassengersRequests Request : db.getRequests())
            {
                if(Request.SrcName.equals(db.getDrivers().get(currentDriver).getFavArea().get(i)))
                {
                    return true;
                }
            }
        }
        return false;
    }


    public void viewRatings() {

        for (Rating rate : db.getRating())
        {
            if(rate.driverId==db.getDrivers().get(currentDriver).getID())
            {
                System.out.print(rate.PassengerName +" ");
                for(int i = 0; i<rate.Rate; i++)
                {
                    System.out.print("* ");
                    if (i==rate.Rate-1)
                    {
                        System.out.print("\n");
                    }
                }
                System.out.println("==============");
            }
        }
    }

    public void CalcAvgRating() {
        int avg = 0, cont = 0,sum = 0;
        for (Rating rate : db.getRating())
        {
            if(rate.driverId==db.getDrivers().get(currentDriver).getID())
            {
                ++cont;
                sum = sum + rate.Rate;
                avg = sum/cont;
            }
        }
        db.getDrivers().get(currentDriver).setAvgRate(avg);
    }

}

