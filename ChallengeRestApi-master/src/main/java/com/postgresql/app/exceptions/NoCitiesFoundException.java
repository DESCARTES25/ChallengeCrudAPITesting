package com.postgresql.app.exceptions;

public class NoCitiesFoundException extends RuntimeException {

    public NoCitiesFoundException() {

        super("No Cities found");
    }
}


