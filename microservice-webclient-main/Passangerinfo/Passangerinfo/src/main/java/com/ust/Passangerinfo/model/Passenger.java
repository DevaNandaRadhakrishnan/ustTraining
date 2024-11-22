package com.ust.Passangerinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="passangerinfo")
public class Passenger {
    @Id
    private String pnr;
    private String name;
    private String email;
    private String phonenumber;
    private String address;
    private String flightNumber;

}
