package com.ust.Airline.service;

import com.ust.Airline.dto.Airlinedto;
import com.ust.Airline.dto.Flightdto;
import com.ust.Airline.dto.Passengerdto;
import com.ust.Airline.dto.ResponseDto;
import com.ust.Airline.model.Airline;
import com.ust.Airline.repo.Airlinerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class Airlineserviceimpl implements AirlineService {
    @Autowired
    private Airlinerepo repo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Airline addAirline(Airline airline) {
        return repo.save(airline);
    }

    @Override
    public ResponseDto getAirline(String airlinecode) {
        ResponseDto responseDto = new ResponseDto();
        Airline airline = repo.findByAirlinecode(airlinecode)
                .orElseThrow(() -> new RuntimeException("Airline not found"));
        Airlinedto airlineDto = mapToAirline(airline);

        // Fetch flights for the airline
        List<Flightdto> flightDTOList = webClientBuilder.baseUrl("http://localhost:9098")
                .build()
                .get()
                .uri("/flights/" + airline.getAirlinecode())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Flightdto>>() {})
                .block();

        // Fetch passengers for each flight
        for (Flightdto flightDTO : flightDTOList) {
            List<Passengerdto> passengerDTOList = webClientBuilder.baseUrl("http://localhost:9099")
                    .build()
                    .get()
                    .uri("/passangerinfo/" + flightDTO.getFlightNumber())
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Passengerdto>>() {})
                    .block();

            flightDTO.setPassengerdto(passengerDTOList);
        }

        responseDto.setAirline(airlineDto);
        responseDto.setFlight(flightDTOList);

        return responseDto;
    }

    private Airlinedto mapToAirline(Airline airline) {
        Airlinedto dto = new Airlinedto();
        dto.setAirlinename(airline.getAirlinename());
        dto.setAirlinecode(airline.getAirlinecode());
        dto.setCountry(airline.getCountry());
        dto.setHeadquarters(airline.getHeadquarters());
        dto.setCeo(airline.getCeo());
        dto.setFoundedYear(airline.getFoundedYear());
        dto.setHubAirport(airline.getHubAirport());
        dto.setWebsite(airline.getWebsite());
        dto.setFleetSize(airline.getFleetSize());
        return dto;
    }
}