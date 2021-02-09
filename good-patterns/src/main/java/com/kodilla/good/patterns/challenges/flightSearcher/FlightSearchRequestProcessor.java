package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.List;
import java.util.Map;

public class FlightSearchRequestProcessor {
    private final FlightsFromOriginCitySearcher flightsFromOriginCitySearcher;
    private final FlightsToDestinationCitySearcher flightsToDestinationCitySearcher;
    private final FlightsWithMidStopSearcher flightsWithMidStopSearcher;


    public FlightSearchRequestProcessor() {
        FlightRepositoryRetriever flightRepositoryRetriever = new FlightRepositoryRetriever();
        FlightRepository flightRepository = flightRepositoryRetriever.getFlightRepository();
        this.flightsFromOriginCitySearcher = new FlightsFromOriginCitySearcher(flightRepository);
        this.flightsToDestinationCitySearcher = new FlightsToDestinationCitySearcher(flightRepository);
        this.flightsWithMidStopSearcher = new FlightsWithMidStopSearcher(flightsFromOriginCitySearcher,
                flightsToDestinationCitySearcher);
    }

    public void processFlightFromOrigin(String originCity){
        List<Flight> flights = flightsFromOriginCitySearcher.findFlights(originCity);
        print(flights);
    }

    public void processFlightToDest(String destinyCity){
        List<Flight> flights = flightsToDestinationCitySearcher.findFlights(destinyCity);
        print(flights);
    }

    public void processFlightWithMidStop(String originCity, String midCity, String destinyCity){
        Map<Flight, List<Flight>> flights = flightsWithMidStopSearcher.findFlights(originCity, midCity, destinyCity);
        print(flights);
    }

    void print(Map<Flight, List<Flight>> flights) {
        if (flights.isEmpty()) {
            System.out.println("No available flights");
        } else {
            for (Map.Entry<Flight, List<Flight>> entry : flights.entrySet()){
                System.out.println(entry.getKey());
                entry.getValue().forEach(System.out::println);
                System.out.println("---");
            }
            System.out.println("-----------------");
        }
    }

    void print(List<Flight> list) {
        if (list.isEmpty()) {
            System.out.println("No available flights");
        } else {
            list.forEach(System.out::println);
            System.out.println("-----------------");
        }
    }
}
