package co.com.iris.certification.exceptions;

public class PayIDNotFound extends AssertionError {

    public PayIDNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
