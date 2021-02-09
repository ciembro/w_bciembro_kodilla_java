package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsToDestinationCitySearcher extends FlightSearcher{

    public FlightsToDestinationCitySearcher(FlightRepository flightRepository) {
        super(flightRepository);
    }

    @Override
    List<Flight> findFlights(String destinationCity) {
        return flightRepository.getFlightMap().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(flight -> flight.getDestinationCity().equals(destinationCity))
                .collect(Collectors.toList());
    }
}
