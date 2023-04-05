package co.com.iris.certification.exceptions;

public class UserDocumentUsedBefore extends AssertionError{
    public UserDocumentUsedBefore(String message, Throwable cause){
        super(message, cause);
    }
}
