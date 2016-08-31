package fr.mla.customer.feed.impl.delegate;

import fr.mla.customer.feed.derivatives.AddressDerivatives;

public class AddressDerivativesDelegate {

    public static AddressDerivatives process(String zipCode, String city, String countryCode) {
        String someString = concatenante(zipCode, city, countryCode);
        return new AddressDerivatives(String.valueOf(someString.hashCode()));
    }


    private static String concatenante(String... strings) {
        String result = "";
        for (String s : strings) {
            if (s != null) {
                result += s;
            }
        }
        return result;
    }

}
