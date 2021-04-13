package app.exceptions;

public class CoordinateNotFoundException extends Exception {
    public CoordinateNotFoundException() {
        super("Can not locate the exact location");
    }
}
