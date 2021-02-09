package com.kodilla.good.patterns.challenges.flightSearcher;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FlightRepositoryRetriever {

    private final Map<String, HashSet<Flight>> flightMap = new HashMap<>();

    public FlightRepositoryRetriever(){

        Flight flight = new Flight("Cracow", LocalDateTime.now(),
                "Warsaw", LocalDateTime.now().plusHours(1));
        addFlight(flight);

        flight = new Flight("Cracow", LocalDateTime.now().minusDays(2),
                "London", LocalDateTime.now().minusDays(2).plusHours(2));
        addFlight(flight);

        flight = new Flight("Warsaw", LocalDateTime.now().plusDays(3).plusHours(1),
                "Frankfurt", LocalDateTime.now().plusDays(3).plusHours(3));
        addFlight(flight);

        flight = new Flight("London", LocalDateTime.now().plusHours(3),
                "Warsaw", LocalDateTime.now().plusHours(5));
        addFlight(flight);
    }

    public Map<String, HashSet<Flight>> getFlightMap() {
        return flightMap;
    }

    private void addFlight(Flight flight){
        String originCity = flight.getOriginCity();
        if (!flightMap.containsKey(originCity)) {
            flightMap.put(originCity, new HashSet<>());
        }
        flightMap.get(originCity).add(flight);
    }
}
