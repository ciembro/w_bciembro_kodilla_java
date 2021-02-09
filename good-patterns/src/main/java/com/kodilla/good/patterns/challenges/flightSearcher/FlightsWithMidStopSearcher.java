package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightsWithMidStopSearcher {

    private final FlightsFromOriginCitySearcher flightsFromOriginCitySearcher;
    private final FlightsToDestinationCitySearcher flightsToDestinationCitySearcher;

    public FlightsWithMidStopSearcher(FlightsFromOriginCitySearcher flightsFromOriginCitySearcher,
                                      FlightsToDestinationCitySearcher flightsToDestinationCitySearcher) {
        this.flightsFromOriginCitySearcher = flightsFromOriginCitySearcher;
        this.flightsToDestinationCitySearcher = flightsToDestinationCitySearcher;
    }

    public Map<Flight, List<Flight>> findFlights(String originCity, String midCity, String destinationCity){

        List<Flight> originCityFlights = flightsFromOriginCitySearcher.findFlights(originCity);
        List<Flight> destinationCityFlights = flightsToDestinationCitySearcher.findFlights(destinationCity);

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
