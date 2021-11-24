package com.system;

import com.users.*;

import java.util.Scanner;

public class AdminMenu{

    Admin admin;
    SystemDB db;
    private final Scanner input = new Scanner(System.in);

    private final Scanner scanner = new Scanner(System.in);

    public AdminMenu(SystemDB db,Admin admin) {
        this.db = db;
        this.admin = admin;
        Menu();
    }

    public void Menu() {
        label:
        while (true) {
            System.out.println("\n1-View All Users");
            System.out.println("2-View Pending Users");
            System.out.println("3-Suspend User");
            System.out.println("4-Logout");

            String option = input.nextLine();
            switch (option) {
                case "1":
                    viewAllUsers();
                    break;
                case "2":
                    getPendingUsers();
                    break;
                case "3":
                    db.getAdmins().get(0).suspend(db.getUsers(), db.getDrivers());
                    break;
                case "4":
                    break label;
            }
        }
        System.out.println("Logging out ...");
    }


    public void viewAllUsers() {

        for (Driver driver : db.getDrivers())
        {
            System.out.println(driver.toString());
        }

        for (Passenger user :  db.getUsers())
        {
            System.out.println(user.toString());
        }
    }


    public void getPendingUsers() {
        for (Driver driver : db.getDrivers())
        {
            if(driver.isActivated().equals("Pending"))
            {
                System.out.println(driver.toString());
                System.out.println("Activate current User? (Y/N)");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    driver.setActivateStat(true);
                    System.out.println("\nUser activated");
                }
            }
        }

        for (Passenger user : db.getUsers()) {
            if(user.isActivated().equals("Pending"))
            {
                System.out.println(user.toString());
                System.out.println("Activate current User? (Y/N)");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    user.setActivateStat(true);
                    System.out.println("\nUser activated");
                }
            }
        }
    }

}
