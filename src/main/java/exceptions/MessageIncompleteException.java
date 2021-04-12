package exceptions;

public class MessageIncompleteException extends Exception{
    public MessageIncompleteException() {
        super("Message is incomplete");
    }
}
