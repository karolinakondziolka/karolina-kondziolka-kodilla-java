package com.kodilla.good.patterns.challenges.flightServices;

public class Flights {

    public String arrivalAirport;
    public String transferAirport;
    public String departureAirport;

    public Flights(String arrivalAirport, String transferAirport, String departureAirport) {
        this.arrivalAirport = arrivalAirport;
        this.transferAirport = transferAirport;
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getTransferAirport() {
        return transferAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flights flights = (Flights) o;

        if (!arrivalAirport.equals(flights.arrivalAirport)) return false;
        if (!transferAirport.equals(flights.transferAirport)) return false;
        return departureAirport.equals(flights.departureAirport);
    }

    @Override
    public int hashCode() {
        int result = arrivalAirport.hashCode();
        result = 31 * result + transferAirport.hashCode();
        result = 31 * result + departureAirport.hashCode();
        return result;
    }
}
