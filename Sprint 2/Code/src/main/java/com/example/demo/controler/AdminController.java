package com.example.demo.controler;


import com.example.demo.models.Offers;
import com.example.demo.models.PassengersRequests;
import com.example.demo.models.User;
import com.example.demo.services.AdminIServices;
import com.example.demo.services.AdminServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping(path = "/Admin")
@RestController
public class AdminController {
    private final AdminIServices adminServices;

    public AdminController() { adminServices = new AdminServices(); }

    @PutMapping("/suspend/{type}/{id}")
    public boolean suspend(@PathVariable String type,@PathVariable int id) { return adminServices.suspend(type,id); } //finished

    @PutMapping("/Activate/{type}/{id}")
    public boolean Activate(@PathVariable String type,@PathVariable int id) { return adminServices.Activate(type,id); } //finished

    @GetMapping("/Users")
    public ArrayList<User> viewAllUsers() { return adminServices.viewAllUsers();} //finished

    @GetMapping("/Rides")
    public ArrayList<Offers> viewAlRides() { return adminServices.viewAlRides(); } //finished

    @GetMapping("/Requests")
    public ArrayList<PassengersRequests> viewAlRequests() { return adminServices.viewAlRequests(); } //finished

    @GetMapping("/PendingUsers")
    public ArrayList<User> getPendingUsers() { return adminServices.getPendingUsers(); } //finished

    @GetMapping("/GetDiscounts")
    public ArrayList<String> getAreaDiscount() { return adminServices.getAreaDiscount(); } //finished

    @PostMapping("/{area}/AddDiscount")
    public boolean AddAreaDiscount(@PathVariable String area) { return adminServices.AddAreaDiscount(area); } //finished
}
