package com.example.demo.controler;

import com.example.demo.models.Driver;
import com.example.demo.models.Passenger;
import com.example.demo.models.User;
import com.example.demo.services.RegisterIServices;
import com.example.demo.services.RegisterServices;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegisterController {
    private final RegisterIServices registerServices;

    public RegisterController() { registerServices = new RegisterServices(); }

    @GetMapping("/Login")
    String getOffers(@RequestBody User user) { return registerServices.login(user); } //Finished

    @PostMapping("/Signup/Passenger")
    public boolean Signup(@RequestBody Passenger passenger) {
        return registerServices.PassengerSignUp(passenger);
    } //Finished

    @PostMapping("/Signup/Driver")
    public boolean Signup(@RequestBody Driver driver) {
        return registerServices.DriverSignUp(driver);
    } //Finished

}
