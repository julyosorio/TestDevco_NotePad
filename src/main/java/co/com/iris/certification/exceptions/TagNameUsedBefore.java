package co.com.iris.certification.exceptions;

public class TagNameUsedBefore extends AssertionError {
    public TagNameUsedBefore(String message, Throwable cause) {
        super(message, cause);
    }
}
