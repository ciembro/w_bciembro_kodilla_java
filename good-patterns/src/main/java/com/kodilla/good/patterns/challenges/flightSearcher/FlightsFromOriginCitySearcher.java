package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsFromOriginCitySearcher extends FlightSearcher{

    public FlightsFromOriginCitySearcher(FlightRepository flightRepository) {
        super(flightRepository);
    }

    @Override
    List<Flight> findFlights(String originCity) {

        return flightRepository.getFlightMap().entrySet().stream()
                .filter(entry -> entry.getKey().equals(originCity))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }
}
