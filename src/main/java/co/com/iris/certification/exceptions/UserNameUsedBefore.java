package co.com.iris.certification.exceptions;

public class UserNameUsedBefore extends AssertionError{
    public UserNameUsedBefore(String message,Throwable cause){
        super(message, cause);
    }
}
