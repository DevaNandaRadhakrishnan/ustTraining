package com.ust.Airline.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "airlininformatio")
public class Airline {
    @Id
    private String airlinename;
    @Column(name = "airlinecode")
    private String airlinecode;
    private String country;
    private String headquarters;
    private String ceo;
    private int foundedYear;
    private String hubAirport;
    private String website;
    private int fleetSize;



}
