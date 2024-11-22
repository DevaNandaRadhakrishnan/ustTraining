package com.ust.Passangerinfo.repo;

import com.ust.Passangerinfo.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Passengerrepo extends JpaRepository<Passenger,String> {
    boolean existsByPnr(String pnr);
    List<Passenger> findByFlightNumber(String flightNumber);
}
