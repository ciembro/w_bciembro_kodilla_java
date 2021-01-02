package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightBrowser {
    Map<String, Boolean> flights ;

    public FlightBrowser(){
        flights = new HashMap<>();
        flights.put("Balice", true);
        flights.put("Lotnisko Chopina W-wa", true);
        flights.put("Lotnisko w Radomiu", false);
    }

    public Flight findFlight(Flight flight) throws RouteNotFoundException {

        if (flights.containsKey(flight.getArrivalAirport()) && flights.get(flight.getArrivalAirport()))
            return flight;
        else
            throw new RouteNotFoundException();
    }
}
