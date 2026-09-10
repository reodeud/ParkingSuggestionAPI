package com.instantsystem.parkingaroundme.exception;


public class CityNotSupportedException extends RuntimeException {
    public CityNotSupportedException(String city) {
        super("The City '" + city + "' is not supported.");
    }
}
