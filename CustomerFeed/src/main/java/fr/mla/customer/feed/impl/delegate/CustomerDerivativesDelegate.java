package fr.mla.customer.feed.impl.delegate;

import fr.mla.customer.feed.derivatives.CustomerDerivatives;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.StringUtils;

public class CustomerDerivativesDelegate {

    private static Soundex soundex = Soundex.US_ENGLISH;
    private static DoubleMetaphone doubleMetaphone = new DoubleMetaphone();


    public static CustomerDerivatives process(String firstName, String lastName, String codeIsoLgg) {

        String normalizedFistName = StringUtils.stripAccents(firstName);
        String normalizedLastName = StringUtils.stripAccents(lastName);

        String nmlzdCodIsoLgg = (codeIsoLgg == null || "".equals(codeIsoLgg.trim()) ? null : codeIsoLgg);
        String codTypCvly = null;

        int soundexFault = 0;

        String soundexEncodedLastName;
        try {
            soundexEncodedLastName = soundex.soundex(normalizedLastName);
        } catch (IllegalArgumentException e) {
            soundexFault++;
            soundexEncodedLastName = null;
        }

        String soundexEncodedFirstName;
        try {
            soundexEncodedFirstName = soundex.soundex(normalizedFistName);
        } catch (IllegalArgumentException e) {
            soundexFault++;
            soundexEncodedFirstName = null;
        }

        // this will map 0 to 99, 1 to 50, 2 to 0
        int degCfdcPhntcAlgo1 = Math.min(99, 100 - 50 * soundexFault);

        String metaphone1EncodedLastName = doubleMetaphone.doubleMetaphone(normalizedLastName, false);
        String metaphone1EncodedFirstName = doubleMetaphone.doubleMetaphone(normalizedFistName, false);

        String metaphone2EncodedLastName = doubleMetaphone.doubleMetaphone(normalizedLastName, true);
        String metaphone2EncodedFirstName = doubleMetaphone.doubleMetaphone(normalizedFistName, true);

        int degCfdcPhntcAlgo2 = 99;

        return new CustomerDerivatives(
                nmlzdCodIsoLgg,
                codTypCvly,
                soundexEncodedLastName,
                soundexEncodedFirstName,
                degCfdcPhntcAlgo1,
                metaphone1EncodedLastName,
                metaphone1EncodedFirstName,
                metaphone2EncodedLastName,
                metaphone2EncodedFirstName,
                degCfdcPhntcAlgo2);
    }

}
