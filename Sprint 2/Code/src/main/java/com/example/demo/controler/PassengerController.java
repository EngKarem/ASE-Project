package com.example.demo.controler;

import com.example.demo.models.PassengersRequests;
import com.example.demo.models.Rating;
import com.example.demo.services.PassengerIServices;
import com.example.demo.services.PassengerServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping(path = "/Passenger")
@RestController
public class PassengerController {
    private final PassengerIServices passengerServices;

    public PassengerController() { passengerServices = new PassengerServices(); }

    @PostMapping("/Request")
    public boolean requestRide(@RequestBody PassengersRequests request) {
        return passengerServices.requestRide(request);
    } //Finished

    @PostMapping("/Rate")
    public boolean RateDriver(@RequestBody Rating rate) {
        return passengerServices.RateDriver(rate);
    } //Finished

    @GetMapping("/{name}/Offers")
    ArrayList <String> getOffers(@PathVariable String name) { return passengerServices.getOffers(name); } //Finished

    @PutMapping("/{id}/{res}/Offers")
    boolean ResponseOffer(@PathVariable int id,@PathVariable String res) { return passengerServices.ResponseOffer(id,res); } //Finished

    @GetMapping("/{id}/{offerNum}/RidePrice")
    ArrayList<String> CalcDiscount(@PathVariable int id, @PathVariable int offerNum){ return passengerServices.CalcDiscount(offerNum ,id);}
}
