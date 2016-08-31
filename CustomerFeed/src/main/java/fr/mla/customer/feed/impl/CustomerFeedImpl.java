package fr.mla.customer.feed.impl;


import fr.mla.customer.feed.CustomerFeed;
import fr.mla.customer.feed.derivatives.*;
import fr.mla.customer.feed.impl.delegate.*;

/**
 * The <i>SERIOUS</i> implementation of CustomerFeed Interface.
 */
public class CustomerFeedImpl implements CustomerFeed {

    @Override
    public CustomerDerivatives processCustomerDerivatives(String firstName, String lastName, String codeIsoLgg) {
        return CustomerDerivativesDelegate.process(firstName, lastName, codeIsoLgg);
    }

    /**
     * If the Phone Number can not be parsed to a valid international phone number, result will
     * be NULL with a rank of zero.
     * Otherwise, rank is follow:
     99 : area_code = residence country code. The standardized phone number is compatible with
     phone numbers international standards.<br/>
     90 : area_code is empty, but phone number begins by the area code & is equal with the residence
     country code. The standardized phone number is compatible with phone numbers international
     standards.<br/>
     80 : Same as 99 or 90 but the area_code is not equal with the the residence country code. The
     standardized phone number is compatible with phone numbers international standards.<br/>
     60 : No existing area code. The area code is added with the residence country code. The
     standardized phone number is compatible with phone numbers international standards.<br/>
     40 : The phone number is to short.<br/>
     0 : The number is not compatible with phone numbers international standards.
     *
     * @return a valid international formated phone number (or NULL) along with a confidence rank,
     * wrapped in a structure PhoneNumberDerivatives
     */
    @Override
    public PhoneNumberDerivatives processPhoneNumberDerivatives(String areaCode, String phoneNumber, String extension, String coutryOfResidence) {
        return PhoneNumberDerivativesDelegate.process(areaCode, phoneNumber, extension, coutryOfResidence);
    }

    /**
     * @return Hash Code computed on the string concatenated from zipCode, city and countryCode
     */
    @Override
    public AddressDerivatives processAddressDerivatives(String line1, String line2, String line3, String line4, String zipCode, String city, String countryCode) {
        return AddressDerivativesDelegate.process(zipCode, city, countryCode);
    }

    /**
     * If eMail is invalid (as per org.apache.commons.validator.routines.EmailValidator) result will be a normalized eMail NULL with a rank 0.<br/>
     * Otherwise, result will be the proper normalized eMail (trimmed + accent-striped) with a rank as follow:<br/>
     *  - eMail had NO spaces and NO accents --> rank = 99<br/>
     *  - eMail had spaces and NO accents --> rank = 80<br/>
     *  - eMail had NO spaces and accents --> rank = 30<br/>
     *  - eMail had spaces and accents --> rank = 20<br/>
     *
     * @return a valid eMail (or NULL) along with a confidence rank,
     * wrapped in a structure EmailDerivatives
     */
    @Override
    public EmailDerivatives processEmailDerivatives(String eMail) {
        return EmailDerivativesDelegate.process(eMail);
    }

    /**
     * If Card Number is invalid (contains some non special characters, accents... or the word DRIVER) result will be a normalized value NULL.<br/>
     * Otherwise, result will be the (tail and head) trimmed value of the CardNumber<br/>
     * Confident rank is as follow:<br/>
     *  - If Card Number has no value --> rank = 0<br/>
     *  - Else if Card Number contains the word DRIVER (case-incensitive) --> rank = 0<br/>
     *  - Else if Card Number contains some non alpha-numeric characters --> rank = 50<br/>
     *  - Else --> rank = 99<br/>
     *
     * @return a valid CardNumber (or NULL) along with a confidence rank,
     * wrapped in a structure CardDerivatives
     */
    @Override
    public CardDerivatives processCardDerivatives(String cardNumber) {
        return CardDerivativesDelegate.process(cardNumber);
    }

}
