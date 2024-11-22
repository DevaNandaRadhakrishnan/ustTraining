package com.ust.Passangerinfo.service;

import com.ust.Passangerinfo.model.Passenger;
import com.ust.Passangerinfo.repo.Passengerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassangerService {
    @Autowired
    private Passengerrepo repo;
    @Autowired
    private PnrGenerationService pnrGenerationService;

    public Passenger addPassanger(Passenger passenger) {
        passenger.setPnr(pnrGenerationService.generatePnr());
        return repo.save(passenger);
    }

    public List<Passenger> getPassangerInfo(String flightNumber) {
        return repo.findByFlightNumber(flightNumber);
    }
}
