package exceptions;

public class UnavailableParkingSpotsException
        extends RuntimeException {
    public UnavailableParkingSpotsException(String errorMessage) {
        super(errorMessage);
    }
}
