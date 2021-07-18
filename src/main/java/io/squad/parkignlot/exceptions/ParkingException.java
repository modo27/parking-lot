package io.squad.parkignlot.exceptions;

public class ParkingException extends Exception {

    public ParkingException() {
    }

    public ParkingException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ParkingException(String message) {
        super(message);
    }

    public ParkingException(Throwable throwable) {
        super(throwable);
    }
}
