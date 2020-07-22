package com.kodilla.good.patterns.challenges.flightServices;

import java.util.HashMap;
import java.util.Map;

public class FlightsMap {

    public static Map<Integer, Flights> getFlightsParameters() {

        HashMap<Integer, Flights> flightsParameters = new HashMap<>();
        flightsParameters.put(0, new Flights("RZE", "KRK", "WRO"));
        flightsParameters.put(1, new Flights("KRK", "WAW", "GDK"));
        flightsParameters.put(2, new Flights("GDK", "KRK", "RZE"));
        flightsParameters.put(3, new Flights("WAW", "RZE", "KTW"));

        return flightsParameters;
    }
}
