package com.ust.Airline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Flightdto {
    private Long id;
    private String flightNumber;
    private String airline;
    private String departureLocation;
    private String arrivalLocation;
    private String departureTime;
    private String arrivalTime;
    private int duration; // Duration in minutes
    private double price;
    private String airlinecode;
    private List<Passengerdto> passengerdto;
}
