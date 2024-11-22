package com.example.swiggy_driver.controller;

import com.example.swiggy_driver.service.DriverLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DriverLocationController {

    @Autowired
    DriverLocationService driverLocService;

    @PutMapping("/locations")
    public ResponseEntity<Map<String, Object>> updateLocation() throws InterruptedException {
        int range = 100;
        while(range > 0) {
            //System.out.println(Math.random() + " , " + Math.random());
            driverLocService.updateLocation(Math.random() + " , " + Math.random());
            Thread.sleep(100);
            range--;
        }
        return new ResponseEntity<Map<String, Object>>(Map.of("message", "Location Updated!"), HttpStatus.OK);

    }
}
