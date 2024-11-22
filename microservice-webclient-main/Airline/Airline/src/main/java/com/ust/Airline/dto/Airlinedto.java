package com.ust.Airline.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airlinedto {
    private String airlinename;
    private String airlinecode;
    private String country;
    private String headquarters;
    private String ceo;
    private int foundedYear;
    private String hubAirport;
    private String website;
    private int fleetSize;
}
