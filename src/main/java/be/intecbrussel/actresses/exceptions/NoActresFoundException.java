package be.intecbrussel.actresses.exceptions;

public class NoActresFoundException extends Exception {
    public NoActresFoundException() {
        super();
    }

    public NoActresFoundException(String message) {
        super(message);
    }

    public NoActresFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoActresFoundException(Throwable cause) {
        super(cause);
    }
}
