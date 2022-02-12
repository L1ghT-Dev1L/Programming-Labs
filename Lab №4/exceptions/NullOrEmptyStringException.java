package exceptions;

public class NullOrEmptyStringException extends RuntimeException {
    public NullOrEmptyStringException(String message) {
        super(message);
    }
}
