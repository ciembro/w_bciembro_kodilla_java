package com.kodilla.good.patterns.challenges.flightSearcher;

import java.time.LocalDateTime;

public class FlightRepositoryRetriever {

    private final FlightRepository flightRepository = new FlightRepository();

    public FlightRepositoryRetriever(){

        Flight flight = new Flight("Cracow", LocalDateTime.now(),
                "Warsaw", LocalDateTime.now().plusHours(1));
        flightRepository.addFlight(flight);

        flight = new Flight("Cracow", LocalDateTime.now().minusDays(2),
                "London", LocalDateTime.now().minusDays(2).plusHours(2));
        flightRepository.addFlight(flight);

        flight = new Flight("Warsaw", LocalDateTime.now().plusDays(3).plusHours(1),
                "Frankfurt", LocalDateTime.now().plusDays(3).plusHours(3));
        flightRepository.addFlight(flight);

        flight = new Flight("London", LocalDateTime.now().plusHours(3),
                "Warsaw", LocalDateTime.now().plusHours(5));
        flightRepository.addFlight(flight);
    }

    public FlightRepository getFlightRepository() {

        return flightRepository;
    }
}
