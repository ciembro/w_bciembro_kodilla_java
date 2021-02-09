package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.List;
import java.util.Map;

public class FlightSearcherService {
    final static FlightRepositoryRetriever flightRepositoryRetriever = new FlightRepositoryRetriever();

    public static void main(String[] args) {
        FlightSearchRequest flightSearchRequest = new FlightSearchRequest();
        FlightRepository flightRepository = flightRepositoryRetriever.getFlightRepository();

        FlightsFromOriginCitySearcher flightsFromOriginCitySearcher =
                new FlightsFromOriginCitySearcher(flightRepository);

        List<Flight> flights = flightsFromOriginCitySearcher.findFlights(flightSearchRequest.getOriginCity());
        print(flights);

        FlightsToDestinationCitySearcher flightsToDestinationCitySearcher =
                new FlightsToDestinationCitySearcher(flightRepository);
        flights = flightsToDestinationCitySearcher.findFlights(flightSearchRequest.getDestCity());
        print(flights);

        FlightsWithMidStopSearcher flightsWithMidStopSearcher =
                new FlightsWithMidStopSearcher(flightsFromOriginCitySearcher, flightsToDestinationCitySearcher);

        Map<Flight, List<Flight>> flightMap = flightsWithMidStopSearcher.findFlights(
                flightSearchRequest.getOriginCity(), flightSearchRequest.getMidCity(), flightSearchRequest.getDestCity()); ;
        print(flightMap);
    }

    static void print(Map<Flight, List<Flight>> flights) {
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

    static void print(List<Flight> list) {
        if (list.isEmpty()) {
            System.out.println("No available flights");
        } else {
            list.forEach(System.out::println);
            System.out.println("-----------------");
        }
    }
}
