package exceptions;

public class UnavailableParkingSpotsException
        extends Exception {
    public UnavailableParkingSpotsException(String errorMessage) {
        super(errorMessage);
    }
}
