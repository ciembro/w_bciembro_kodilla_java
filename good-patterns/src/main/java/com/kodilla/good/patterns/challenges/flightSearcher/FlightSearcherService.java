package com.kodilla.good.patterns.challenges.flightSearcher;

import java.util.List;
import java.util.Map;

public class FlightSearcherService {
    private static final FlightRepository flightRepository = new FlightRepository();

    public static void main(String[] args) {
        FlightSearchRequest flightSearchRequest = new FlightSearchRequest();

        List<Flight> list = flightRepository.findFlightsFromOriginCity(flightSearchRequest.getOriginCity());
        print(list);

        list = flightRepository.findFlightsToDestCity(flightSearchRequest.getDestCity());
        print(list);

        Map<Flight, List<Flight>> map = flightRepository.findFlightsWithMidFlight(flightSearchRequest.getOriginCity(),
                flightSearchRequest.getMidCity(), flightSearchRequest.getDestCity());
        print(map);









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
