package com.postgresql.app.exceptions;

public class NoItinerariesFoundException extends RuntimeException {

    public NoItinerariesFoundException() {

        super("No Itineraries found");
    }
}
