package com.kodilla.exception.test;

public class SearchFlightRunner {

    public static void main(String[] args) {
        FlightBrowser flightBrowser = new FlightBrowser();
        Flight flight = new Flight("Luton", "Balice");

        try {
            Flight searchedFlight = flightBrowser.findFlight(flight);
            System.out.println("Found flight: ");
            System.out.println(searchedFlight.getDepartureAirport() + " -------> " + searchedFlight.getArrivalAirport());
        } catch (RouteNotFoundException e){
            System.out.println("Airport " + flight.getArrivalAirport() + " is unavailable");
        }

        flight = new Flight("Luton", "Heathrow");
        try {
            Flight searchedFlight = flightBrowser.findFlight(flight);
            System.out.println(searchedFlight.getDepartureAirport() + " ------->" + searchedFlight.getDepartureAirport());
        } catch (RouteNotFoundException e){
            System.out.println("Airport " + flight.getArrivalAirport() + " is unavailable.");
        }
    }
}
