package fr.mla.customer.feed;

import fr.mla.customer.feed.derivatives.*;

/**
 * Contract of Interface defining the operations of data normalization in Customer Repository.<br/>
 * Typical use is as follow:<br/>
 *  - Raw data is retrieved from existing records (ex: Phone area code + phone number + phone extension
 * + country of residence)<br/>
 *  - A normalization work is performed with the raw data (ex: is this phone number a valid
 * number given the country of residence? What is the standard international format?...)<br/>
 *  - At the end of the process, a structure is returned with the normalized data along with a confidence rank
 * saying wether or not we can trus the normalized data (ex: intl. format is '+33 6 12 34 56 78' with a confidence rank of 75%)<br/>
 * <br/>
 * Operations of normalization exist for <i>Customers (phonetic indexation for fist name and last name)</i>, <i>Phone Numbers</i>, <i>Addresses</i> and <i>EMails</i>
 */
public interface CustomerFeed {

    /**
     * Compute the normalized data given the raw data for Customers
     * (see returning type for more details)
     * @return a CustomerDerivatives wraping normalized data
     */
    CustomerDerivatives processCustomerDerivatives(String firstName, String lastName, String codeIsoLgg);

    /**
     * Compute the normalized data given the raw data for Phone Numbers
     * (see returning type for more details)
     * @return a PhoneNumberDerivatives wraping normalized data
     */
    PhoneNumberDerivatives processPhoneNumberDerivatives(String areaCode, String phoneNumber, String extension, String coutryOfResidence);

    /**
     * Compute the normalized data given the raw data for Addresses
     * (see returning type for more details)
     * @return a AddressDerivatives wraping normalized data
     */
    AddressDerivatives processAddressDerivatives(String line1, String line2, String line3, String line4, String zipCode, String city, String countryCode);

    /**
     * Compute the normalized data given the raw data for Emails
     * (see returning type for more details)
     * @return a EmailDerivatives wraping normalized data
     */
    EmailDerivatives processEmailDerivatives(String eMail);

    /**
     * Compute the normalized data given the raw data for Card
     * (see returning type for more details)
     * @return a CardDerivatives wraping normalized data
     */
    CardDerivatives processCardDerivatives(String cardNumber);

}
