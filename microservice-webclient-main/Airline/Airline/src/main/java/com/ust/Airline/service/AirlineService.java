package com.ust.Airline.service;


import com.ust.Airline.dto.ResponseDto;
import com.ust.Airline.model.Airline;

public interface AirlineService {


    Airline addAirline(Airline airline);

    ResponseDto getAirline(String airlinecode);
}