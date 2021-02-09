package com.kodilla.good.patterns.challenges.flightSearcher;

public class FlightSearchRequest {

    private final String originCity;
    private final String midCity;
    private final String destCity;

    public FlightSearchRequest(){
        originCity = "Cracow";
        midCity = "London";
        destCity = "Warsaw";
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getMidCity() {
        return midCity;
    }

    public String getDestCity() {
        return destCity;
    }
}
