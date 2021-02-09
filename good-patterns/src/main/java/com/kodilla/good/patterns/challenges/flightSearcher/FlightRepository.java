package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightRepository {

    private final Map<String, HashSet<Flight>> flightMap;

    public FlightRepository(){
        FlightRepositoryRetriever flightRepositoryRetriever = new FlightRepositoryRetriever();
        flightMap = flightRepositoryRetriever.getFlightMap();
    }

    List<Flight> findFlightsFromOriginCity(String originCity) {
        return flightMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(originCity))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    List<Flight> findFlightsToDestCity(String destinationCity) {
        return flightMap.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(flight -> flight.getDestinationCity().equals(destinationCity))
                .collect(Collectors.toList());
    }

    public Map<Flight, List<Flight>> findFlightsWithMidFlight(String originCity, String midCity, String destinationCity){

        List<Flight> originCityFlights = findFlightsFromOriginCity(originCity);
        List<Flight> destinationCityFlights = findFlightsToDestCity(destinationCity);

        List<Flight> midToDestFlights = destinationCityFlights.stream()
                .filter(flight -> flight.getOriginCity().equals(midCity))
                .collect(Collectors.toList());

        List<Flight> originToMidFlights = originCityFlights.stream()
                .filter(flight -> flight.getDestinationCity().equals(midCity))
                .collect(Collectors.toList());

        return connectFlights(originToMidFlights, midToDestFlights);
    }

    private Map<Flight, List<Flight>> connectFlights(List<Flight> originToMidFlights, List<Flight> midToDestFlights){
        List<Flight> list;
        Map<Flight, List<Flight>> availableFlights = new HashMap<>();

        for (Flight originToMidFlight : originToMidFlights){

            list = midToDestFlights.stream()
                    .filter((midToDestFlight) ->
                            originToMidFlight.getArrivalTime().isBefore(midToDestFlight.getDepartureTime()))
                    .collect(Collectors.toList());

            if (!list.isEmpty()){
                availableFlights.put(originToMidFlight, list);
            }
        }
        return availableFlights;
    }

}
