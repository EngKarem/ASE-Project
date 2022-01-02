package com.example.demo.controler;

import com.example.demo.models.FavouriteArea;
import com.example.demo.models.Offers;
import com.example.demo.models.PassengersRequests;
import com.example.demo.services.DriverIServices;
import com.example.demo.services.DriverServices;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

@RequestMapping(path = "/Driver")
@RestController
public class DriverController {
    private final DriverIServices driverServices;

    public DriverController() { driverServices = new DriverServices(); }

    @PostMapping(value = "/AddFavArea")
    public boolean addAreas(@RequestBody FavouriteArea favouriteArea) { return driverServices.addAreas(favouriteArea); } //Finished

    @PostMapping("/offer")
    public boolean AddOffer(@RequestBody Offers offer) {
       return driverServices.AddOffer(offer);
    } //Finished

    @GetMapping(value = "/{name}/FavAreas")
    public ArrayList<String> getFavAreas(@PathVariable String name) { return driverServices.getFavAreas(name); } //Finished

    @GetMapping("/{name}/UserRequests")
    public ArrayList<PassengersRequests> getUserRequests(@PathVariable String name) { return driverServices.getUserRequests(name); } //Finished

    @GetMapping("/{id}/Ratings")
    public HashMap<String, String> ResponseOffer(@PathVariable String id) { return driverServices.viewRatings(id); } //Finished

    @GetMapping("/{name}/PassengerNearby")
    public String CheckNotification(@PathVariable String name) { return driverServices.CheckNotification(name); } //Finished

    @GetMapping("/{id}/AvgRating")
    public int CalcAvgRating(@PathVariable String id){ return driverServices.CalcAvgRating(id); } //finished
}
