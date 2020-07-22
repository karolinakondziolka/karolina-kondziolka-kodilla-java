package com.kodilla.good.patterns.challenges.flightServices;

import java.util.HashMap;
import java.util.Map;

public class FlightsFinder {

    public void arrivalAirportFinder(String arrivalAirport, Map<Integer, Flights> FlightsParameters){
        FlightsParameters.entrySet().stream()
                .filter(e->e.getValue().getArrivalAirport().equals(arrivalAirport))
                .forEach(System.out::println);


    }
    public void transferAirportFinder(String transferAirport, Map<Integer, Flights> FlightsParameters){
        FlightsParameters.entrySet().stream()
                .filter(e->e.getValue().getTransferAirport().equals(transferAirport))
                .forEach(System.out::println);


    }
    public void departureAirportFinder(String departureAirport, Map<Integer, Flights> FlightsParameters){
        FlightsParameters.entrySet().stream()
                .filter(e->e.getValue().getDepartureAirport().equals(departureAirport))
                .forEach(System.out::println);


    }


}
