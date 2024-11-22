package com.ust.Passangerinfo.controller;

import com.ust.Passangerinfo.model.Passenger;
import com.ust.Passangerinfo.service.PassangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passangerinfo")
public class PassangerController {
    @Autowired
    private PassangerService passangerService;

    @PostMapping("/passanger")
    public Passenger addPassanger(@RequestBody Passenger passanger){
        return passangerService.addPassanger(passanger);
    }
    @GetMapping("{flightNumber}")
    public List<Passenger> getPassangerInfo(@PathVariable String flightNumber){
        return passangerService.getPassangerInfo(flightNumber);
    }

}
