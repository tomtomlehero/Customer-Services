package fr.mla.customer.service.exception;

public class CustomerServiceException extends Throwable {


    public CustomerServiceException() {
        super();
    }

    public CustomerServiceException(String message) {
        super(message);
    }

    public CustomerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerServiceException(Throwable cause) {
        super(cause);
    }

}
