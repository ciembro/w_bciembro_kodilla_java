package com.kodilla.good.patterns.challenges.flightSearcher;

import java.time.LocalDateTime;

public class Flight {

    private final String originCity;
    private final LocalDateTime departureTime;
    private final String destinationCity;
    private final LocalDateTime arrivalTime;

    public Flight(String originCity, LocalDateTime departureTime, String destinationCity, LocalDateTime arrivalTime) {
        this.originCity = originCity;
        this.departureTime = departureTime;
        this.destinationCity = destinationCity;
        this.arrivalTime = arrivalTime;
    }

    public String getOriginCity() {
        return originCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!getOriginCity().equals(flight.getOriginCity())) return false;
        if (!getDepartureTime().equals(flight.getDepartureTime())) return false;
        if (!getDestinationCity().equals(flight.getDestinationCity())) return false;
        return getArrivalTime().equals(flight.getArrivalTime());
    }

    @Override
    public int hashCode() {
        int result = getOriginCity().hashCode();
        result = 31 * result + getDepartureTime().hashCode();
        result = 31 * result + getDestinationCity().hashCode();
        result = 31 * result + getArrivalTime().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return originCity +
                "(" + departureTime.getDayOfMonth() + "." + departureTime.getMonth() + "." +  departureTime.getYear() + " " +
                departureTime.getHour() + ":" + departureTime.getMinute() +  ") -->" +
                destinationCity +
                "(" + arrivalTime.getDayOfMonth() + "." + arrivalTime.getMonth() + "." +  arrivalTime.getYear() + " " +
                arrivalTime.getHour() + ":" + arrivalTime.getMinute() +")";
    }
}
