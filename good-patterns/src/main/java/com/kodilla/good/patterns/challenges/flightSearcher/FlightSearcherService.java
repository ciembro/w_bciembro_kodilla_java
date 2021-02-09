package com.kodilla.good.patterns.challenges.flightSearcher;

public class FlightSearcherService {


    public static void main(String[] args) {

        FlightSearchRequest flightSearchRequest = new FlightSearchRequest();
        FlightSearchRequestProcessor flightSearchRequestProcessor = new FlightSearchRequestProcessor();

        flightSearchRequestProcessor.processFlightFromOrigin(flightSearchRequest.getOriginCity());

        flightSearchRequestProcessor.processFlightToDest(flightSearchRequest.getDestCity());

        flightSearchRequestProcessor.processFlightWithMidStop(flightSearchRequest.getOriginCity(),
                flightSearchRequest.getMidCity(), flightSearchRequest.getDestCity());

    }
}
