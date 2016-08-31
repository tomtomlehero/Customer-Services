package fr.mla.customer.service.exception;

public class PhoneticSearchException extends CustomerServiceException {

    public PhoneticSearchException() {
        super("The firstName or lastName you provised is unsuitable for a phonetic search");
    }
}
