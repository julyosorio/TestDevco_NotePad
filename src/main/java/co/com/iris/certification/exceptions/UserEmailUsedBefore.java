package co.com.iris.certification.exceptions;

public class UserEmailUsedBefore extends AssertionError{

    public UserEmailUsedBefore(String message, Throwable cause){
        super(message,cause);
    }
}
