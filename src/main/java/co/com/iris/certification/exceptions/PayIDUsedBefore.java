package co.com.iris.certification.exceptions;

public class PayIDUsedBefore extends AssertionError{

    public PayIDUsedBefore(String message,Throwable cause){
        super(message,cause);
    }
}
