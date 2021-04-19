package app.exceptions;

public class DifferenteMessagesException extends Exception {
    public DifferenteMessagesException() {
        super("Messages are different");
    }
}
