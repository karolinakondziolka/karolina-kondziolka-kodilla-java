package com.kodilla.good.patterns.challenges.flightServices;

public class Application {
    public static void main(String[] args) {

        String airport = "GDK";

        FlightsFinder flightsFinder = new FlightsFinder();
        System.out.println("Flights from/to/through:" +airport);
        flightsFinder.arrivalAirportFinder(airport, FlightsMap.getFlightsParameters());
        flightsFinder.transferAirportFinder(airport, FlightsMap.getFlightsParameters());
        flightsFinder.departureAirportFinder(airport, FlightsMap.getFlightsParameters());
    }
}
