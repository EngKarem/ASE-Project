package com.system;

import com.users.*;

import java.util.Scanner;

public class MainMenu {

    SystemDB db;

    static int UserID = 0,DriverID = 0;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(SystemDB db) {
        this.db = db;
        Menu();
    }

    public void Menu() {
        String option;
        while (true) {
            System.out.println("\n1- Signup" +
                    "\n2- Login" +
                    "\n3- Login As an Admin" +
                    "\n4- Exit");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("1")) {
                signUp();
            } else if (option.equalsIgnoreCase("2")) {
                login();
            } else if (option.equalsIgnoreCase("3")) {
                adminLogin();
            } else if (option.equalsIgnoreCase("4")) {
                break;
            } else {
                System.out.println("***Enter valid option***\n");
            }
        }
    }

    private void signUp() {
        String type,username, email, password, phone,drivingLicense,nationalID;

        while (true) {
            System.out.println("Enter the type of account: " +
                    "\n1- Passenger" +
                    "\n2- Driver");
            type = scanner.nextLine();
            if (type.equalsIgnoreCase("1")) {
                UserID++;
                System.out.print("Enter new username: ");
                username = scanner.nextLine();
                while(username.isEmpty())
                {
                    System.out.println("Username Can't be Empty");
                    System.out.print("Enter new username: ");
                    username = scanner.nextLine();
                }

                System.out.print("Enter new Email(Optional): ");
                email = scanner.nextLine();

                System.out.print("Enter new password: ");
                password = scanner.nextLine();
                while(password.isEmpty())
                {
                    System.out.println("password Can't be Empty");
                    System.out.print("Enter new password: ");
                    password = scanner.nextLine();
                }

                System.out.print("Enter Phone Number: ");
                phone = scanner.nextLine();
                while(phone.isEmpty())
                {
                    System.out.println("Phone Can't be Empty");
                    System.out.print("Enter Phone Number: ");
                    phone = scanner.nextLine();
                }

                db.getUsers().add(new Passenger(UserID,username, email, password, phone,"User"));
                break;

            } else if (type.equalsIgnoreCase("2")) {
                DriverID++;
                System.out.print("Enter new username: ");
                username = scanner.nextLine();
                while(username.isEmpty())
                {
                    System.out.println("Username Can't be Empty");
                    System.out.print("Enter new username: ");
                    username = scanner.nextLine();
                }

                System.out.print("Enter new Email(Optional): ");
                email = scanner.nextLine();

                System.out.print("Enter new password");
                password = scanner.nextLine();
                while(password.isEmpty())
                {
                    System.out.println("password Can't be Empty");
                    System.out.print("Enter new password: ");
                    password = scanner.nextLine();
                }

                System.out.print("Enter Phone Number: ");
                phone = scanner.nextLine();
                while(phone.isEmpty())
                {
                    System.out.println("Phone Can't be Empty");
                    System.out.print("Enter Phone Number: ");
                    phone = scanner.nextLine();
                }

                System.out.print("Enter drivingLicense: ");
                drivingLicense  = scanner.nextLine();
                while(drivingLicense.isEmpty())
                {
                    System.out.println("drivingLicense Can't be Empty");
                    System.out.print("Enter drivingLicense: ");
                    drivingLicense = scanner.nextLine();
                }

                System.out.print("Enter nationalID: ");
                nationalID = scanner.nextLine();
                while(nationalID.isEmpty())
                {
                    System.out.println("nationalID Can't be Empty");
                    System.out.print("Enter nationalID: ");
                    nationalID = scanner.nextLine();
                }
                db.getDrivers().add(new Driver(DriverID,username, email, password, phone,"Driver",drivingLicense,nationalID));
                break;
            } else {
                System.out.println("***Enter valid option***");
            }
        }
    }

    private void login() {
        String username, password;

        boolean found = false;
        System.out.print("Enter Username: ");
        username = scanner.nextLine();
        System.out.print("Enter Password: ");
        password = scanner.nextLine();
        int userIdx;
        for (Passenger user: db.getUsers()) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                found = true;
                userIdx = db.getUsers().indexOf(user);
                UserMenu userMenu = new UserMenu(db ,userIdx);
                break;
            }
        }
        for (Driver driver: db.getDrivers()) {
            if (driver.getUsername().equalsIgnoreCase(username) && driver.getPassword().equals(password)) {
                found = true;
                userIdx =db.getDrivers().indexOf(driver);
                DriverMenu driverMenu = new DriverMenu(db , userIdx);
                break;
            }
        }
        if (!found) System.out.println("Failed to login");
    }

    private void adminLogin() {
        String username, password;
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter Password: ");
        password = scanner.nextLine();
        boolean found = false;
        for (Admin admin: db.getAdmins()) {
            if (admin.getUsername().equalsIgnoreCase(username) && admin.getPassword().equalsIgnoreCase(password)) {
                found = true;
                AdminMenu adminMenu = new AdminMenu(db ,admin);
                break;
            }
        }
        if (!found) System.out.println("Failed to login");
    }

}