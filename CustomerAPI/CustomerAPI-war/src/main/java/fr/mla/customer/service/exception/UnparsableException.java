package fr.mla.customer.service.exception;

public class UnparsableException extends Throwable {

    String phoneNumber;

    public UnparsableException(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
