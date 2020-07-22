package com.kodilla.good.patterns.challenges.flightServices;

public class Application {
    public static void main(String[] args) {

        Flights flights = new Flights("KRA", "WAW", "GDK");

        FlightsFinder flightsFinder = new FlightsFinder();
        flightsFinder.arrivalAirportFinder("KRA", FlightsMap.getFlightsParameters());
        flightsFinder.transferAirportFinder("WAW", FlightsMap.getFlightsParameters());
        flightsFinder.departureAirportFinder("GDK", FlightsMap.getFlightsParameters());
    }
}
