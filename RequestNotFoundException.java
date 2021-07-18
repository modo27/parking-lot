public class RequestNotFoundException extends Exception {

    public RequestNotFoundException() {
    }

    public RequestNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RequestNotFoundException(String message) {
        super(message);
    }

    public RequestNotFoundException(Throwable throwable) {
        super(throwable);
    }
}