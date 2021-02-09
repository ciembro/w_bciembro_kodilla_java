package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.List;

public abstract class FlightSearcher {
    FlightRepository flightRepository;

    public FlightSearcher(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    abstract List<Flight> findFlights(String city);
}
