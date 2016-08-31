package fr.mla.customer.feed.impl;

import fr.mla.customer.feed.CustomerFeed;
import fr.mla.customer.feed.derivatives.*;

/**
 * A <i>DUMMY</i> implementation of CustomerFeed Interface.
 * All data returned are dummy, hard coded values
 */
public class DummyCustomerFeedImpl implements CustomerFeed {

    @Override
    public CustomerDerivatives processCustomerDerivatives(String firstName, String lastName, String codeIsoLgg) {
        return new CustomerDerivatives(
                "FR-fr",
                "X",
                "FZO9BPA0",
                "KET6NCX9",
                50,
                "DAW1QQA4",
                "FOE5NGJ7",
                "SDF9RDS7",
                "POI4NJU6",
                75);
    }

    @Override
    public PhoneNumberDerivatives processPhoneNumberDerivatives(String areaCode, String phoneNumber, String extension, String coutryOfResidence) {
        return new PhoneNumberDerivatives(
                "+33 6 87 54 96 21",
                25);
    }

    @Override
    public AddressDerivatives processAddressDerivatives(String line1, String line2, String line3, String line4, String zipCode, String city, String countryCode) {
        return new AddressDerivatives("1472605917");
    }

    @Override
    public EmailDerivatives processEmailDerivatives(String eMail) {
        return new EmailDerivatives("celestine.duval@somedomain.fr", 80);
    }

    @Override
    public CardDerivatives processCardDerivatives(String cardNumber) {
        return new CardDerivatives("123456WXYZ00", 99);
    }

}
