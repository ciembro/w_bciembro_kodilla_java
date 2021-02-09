package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;

public class FlightRepository {

    private final Map<String, HashSet<Flight>> flightMap = new HashMap<>();

    public void addFlight(Flight flight){
        String originCity = flight.getOriginCity();
        if (!flightMap.containsKey(originCity)) {
            flightMap.put(originCity, new HashSet<>());
        }
        flightMap.get(originCity).add(flight);
    }

    public Map<String, HashSet<Flight>> getFlightMap() {
        return flightMap;
    }
}
