package fr.mla.customer.feed.impl.delegate;

import fr.mla.customer.feed.derivatives.PhoneNumberDerivatives;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberDerivativesDelegate {

    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    private static final ResourceBundle countryCodesBundle = ResourceBundle.getBundle("CountryCodes");

    private static final Set<String> countryCodes = new HashSet<String>();

    private static final Pattern areaCodePattern = Pattern.compile("0{0,2}(\\d*)");

    static {
        for (String key : countryCodesBundle.keySet()) {
            countryCodes.add(countryCodesBundle.getString(key));
        }
    }



    public static PhoneNumberDerivatives process(String areaCode, String nationalNumber, String extension, String coutryOfResidence) {

        Phonenumber.PhoneNumber phoneNumber = computePhoneNumber(areaCode, nationalNumber, extension, coutryOfResidence);
        String formattedPhoneNumner = (phoneNumber == null ? null : phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));

        int rank = computeRank(phoneNumber, areaCode, nationalNumber, extension, coutryOfResidence);

        return new PhoneNumberDerivatives(formattedPhoneNumner, rank);
    }


    private static Phonenumber.PhoneNumber computePhoneNumber(String areaCode, String nationalNumber, String extension, String coutryOfResidence) {

        String countryCodeOfResidence = countryCode(coutryOfResidence);

        Phonenumber.PhoneNumber[] allPhoneNumbers = parseAll(areaCode, nationalNumber, extension, coutryOfResidence);

        // No parsing was successful --> null with a rank of 0
        if (countNotNull(allPhoneNumbers) == 0) {
            return null;
        }

        // Some parsing were successful. All lead to the same result
        // --> return that result with a rank of 99 if the country code matches the country of residence, 50 otherwise
        if (countDistincts(allPhoneNumbers) == 1) {
            return firstNotNull(allPhoneNumbers);
        }

        // Some parsing were successful. Parsing results are different
        // prefer the longest of the list, preferably with the country code belonging to the given country of residence
        return prefered(allPhoneNumbers, countryCodeOfResidence);

    }


    private static int computeRank(Phonenumber.PhoneNumber phoneNumber, String areaCode, String nationalNumber, String extension, String coutryOfResidence) {


        if (phoneNumber == null) {
            return 0;
        }

        /**
         * Test #01
         * Area Code is not null ?
         */
        boolean test01 = StringUtils.isNotBlank(areaCode);

        /**
         * Test #02
         * AreaCode is a valid country code ?
         */
        boolean test02 = false;
        String countryCode = null;

        if (StringUtils.isNotBlank(areaCode)) {
            Matcher matcher = areaCodePattern.matcher(areaCode);

            if (matcher.matches()) {
                countryCode = matcher.group(1);
            }
            test02 = countryCodes.contains(countryCode);
        }


        /**
         * Test #03
         * AreaCode matches the country of residence
         */
        boolean test03 = false;
        String coutryCodeOfResidence = countryCode(coutryOfResidence);
        if (coutryCodeOfResidence != null) {
            int x = Integer.valueOf(coutryCodeOfResidence);
            test03 = (x == phoneNumber.getCountryCode());
        }

        /**
         * Test #04
         * No digits have been appended to the final result ?
         */
        String generatedPhoneNumber = String.valueOf(phoneNumber.getNationalNumber());
        boolean test04 = ! generatedPhoneNumber.endsWith(cleanGeneratedNumber(nationalNumber, phoneNumber.getCountryCode()));
        if (StringUtils.isNotBlank(extension)) {
            test04 &= ! generatedPhoneNumber.endsWith(extension);
        }
        test04 = ! test04;


        /**
         *
         */
        if (test01 && test02 && test03 && test04) {
            return 99;
        }

        if (!test01 && test03 && test04) {
            return 90;
        }

        if (!test03 && test04) {
            return 80;
        }

        if (test04) {
            return 60;
        }

        return 40;
    }




    private static final Pattern headingZerosRemover = Pattern.compile("0*(\\d*)");


    /**
     * Remove all non digits - Remove heading zeros - Remove heading country code
     */
    private static String cleanGeneratedNumber(String number, int countryCode) {

        // Remove all non digits
        String result = number.replaceAll("\\D", "");

        // Remove heading zeros
        Matcher matcher=  headingZerosRemover.matcher(result);
        if (matcher.matches()) {
            result = matcher.group(1);
        }

        String sCountryCode = String.valueOf(countryCode);
        // Remove heading country code
        if (result.startsWith(sCountryCode)) {
            result = result.substring(sCountryCode.length());
        }

        return result;
    }



    /**
     * Country Code associated with the Country of residence
     * (from the property file CountryCodes)
     */
    private static String countryCode(String coutryOfResidence) {
        try {
            return countryCodesBundle.getString(coutryOfResidence);
        } catch (MissingResourceException e) {
            return null;
        }
    }



    private static Phonenumber.PhoneNumber prefered(Phonenumber.PhoneNumber[] phoneNumbers, String countryCodeOfResidence) {

        Phonenumber.PhoneNumber prefered = null;

        for (Phonenumber.PhoneNumber current : phoneNumbers) {

            if (current != null) {

                if (prefered == null) {
                    prefered = current;
                    continue;
                }

                String preferedFormated = phoneNumberUtil.format(prefered, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                String preferedCountryCode = String.valueOf(prefered.getCountryCode());
                String currentFormated = phoneNumberUtil.format(current, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                String currentCountryCode = String.valueOf(current.getCountryCode());

                if (preferedCountryCode.equals(countryCodeOfResidence)) {
                    if (currentCountryCode.equals(countryCodeOfResidence)) {
                        if (currentFormated.length() > preferedFormated.length()) {
                            prefered = current;
                        }
                    }
                } else {
                    if (currentCountryCode.equals(countryCodeOfResidence)) {
                        prefered = current;
                    } else {
                        if (currentFormated.length() > preferedFormated.length()) {
                            prefered = current;
                        }
                    }
                }
            }
        }

        return prefered;
    }


    private static Phonenumber.PhoneNumber firstNotNull(Phonenumber.PhoneNumber[] phoneNumbers) {

        for (Phonenumber.PhoneNumber phoneNumber : phoneNumbers) {
            if (phoneNumber != null) {
                return phoneNumber;
            }
        }
        return null;
    }




    private static int countNotNull(Object[] objects) {

        int count = 0;

        for (Object o : objects) {
            if (o != null) {
                count++;
            }
        }
        return count;
    }


    private static int countDistincts(Phonenumber.PhoneNumber[] phoneNumbers) {

        HashSet<String> set = new HashSet<String>();

        for (Phonenumber.PhoneNumber phoneNumber : phoneNumbers) {
            if (phoneNumber != null) {
                set.add(phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));
            }
        }

        return set.size();
    }





    public static Phonenumber.PhoneNumber[] parseAll(String areaCode, String phoneNumber, String extension, String coutryOfResidence) {

        return new Phonenumber.PhoneNumber[]{
                parsePhoneNumber_00_PHONENUMBER(phoneNumber),
                parsePhoneNumber_00_AREACODE_PHONENUMBER(areaCode, phoneNumber),
                parsePhoneNumber_00_PHONENUMBER_EXTENSION(phoneNumber, extension),
                parsePhoneNumber_00_AREACODE_PHONENUMBER_EXTENSION(areaCode, phoneNumber, extension),
                parsePhoneNumber_ctryRes_PHONENUMBER(phoneNumber, coutryOfResidence),
                parsePhoneNumber_ctryRes_AREACODE_PHONENUMBER(areaCode, phoneNumber, coutryOfResidence),
                parsePhoneNumber_ctryRes_PHONENUMBER_EXTENSION(phoneNumber, extension, coutryOfResidence),
                parsePhoneNumber_ctryRes_AREACODE_PHONENUMBER_EXTENSION(areaCode, phoneNumber, extension, coutryOfResidence)};
    }




    /*
     * Test different mix of AREA CODE + PHONE NUMBER + EXTENSION
     * If AREA CODE or EXTENSION (or both) is blank, corresponding test is not performed
     * In this serie, test is performed only on numbers starting with '00' or '+'.
     * COUNTRY OF RESIDENCE is not used
     * Normalized PhoneNumber object is returned only if it isValidNumber()
     * Otherwise, null is returned
     */


    // Test "00" - NUMBER
    private static Phonenumber.PhoneNumber parsePhoneNumber_00_PHONENUMBER(String phoneNumber) {
        return parsePhoneNumber_00(phoneNumber);
    }

    // Test "00" - AREA CODE + NUMBER
    private static Phonenumber.PhoneNumber parsePhoneNumber_00_AREACODE_PHONENUMBER(String areaCode, String phoneNumber) {
        if (StringUtils.isBlank(areaCode)) {
            return null;
        }
        return parsePhoneNumber_00(areaCode + phoneNumber);
    }

    // Test "00" - NUMBER + EXTENSION
    private static Phonenumber.PhoneNumber parsePhoneNumber_00_PHONENUMBER_EXTENSION(String phoneNumber, String extension) {
        if (StringUtils.isBlank(extension)) {
            return null;
        }
        return parsePhoneNumber_00(phoneNumber + extension);
    }

    // Test "00" - AREA CODE + NUMBER + EXTENSION
    private static Phonenumber.PhoneNumber parsePhoneNumber_00_AREACODE_PHONENUMBER_EXTENSION(String areaCode, String phoneNumber, String extension) {
        if (StringUtils.isBlank(areaCode) || StringUtils.isBlank(extension)) {
            return null;
        }
        return parsePhoneNumber_00(areaCode + phoneNumber + extension);
    }


    /*
     * Test different mix of AREA CODE + PHONE NUMBER + EXTENSION
     * If AREA CODE or EXTENSION (or both) is blank, corresponding test is not performed
     * In this serie, test is performed with country of residence
     * Normalized PhoneNumber object is returned only if it isValidNumber()
     * Otherwise, null is returned
     */

    // Test "ctryRes" - NUMBER
    private static Phonenumber.PhoneNumber parsePhoneNumber_ctryRes_PHONENUMBER(String phoneNumber, String coutryOfResidence) {
        return parsePhoneNumber_ctryRes(phoneNumber, coutryOfResidence);
    }

    // Test "ctryRes" - AREA CODE + NUMBER
    private static Phonenumber.PhoneNumber parsePhoneNumber_ctryRes_AREACODE_PHONENUMBER(String areaCode, String phoneNumber, String coutryOfResidence) {
        if (StringUtils.isBlank(areaCode)) {
            return null;
        }
        return parsePhoneNumber_ctryRes(areaCode + phoneNumber, coutryOfResidence);
    }

    // Test "ctryRes" - NUMBER + EXTENSION
    private static Phonenumber.PhoneNumber parsePhoneNumber_ctryRes_PHONENUMBER_EXTENSION(String phoneNumber, String extension, String coutryOfResidence) {
        if (StringUtils.isBlank(extension)) {
            return null;
        }
        return parsePhoneNumber_ctryRes(phoneNumber + extension, coutryOfResidence);
    }

    // Test "ctryRes" - AREA CODE + NUMBER + EXTENSION
    private static Phonenumber.PhoneNumber parsePhoneNumber_ctryRes_AREACODE_PHONENUMBER_EXTENSION(String areaCode, String phoneNumber, String extension, String coutryOfResidence) {
        if (StringUtils.isBlank(areaCode) || StringUtils.isBlank(extension)) {
            return null;
        }
        return parsePhoneNumber_ctryRes(areaCode + phoneNumber + extension, coutryOfResidence);
    }


    /**
     * Parse a phone number with the technic of "Double 0"
     * Only numbers starting with "00" or "+" are tested. Country of residence is not used with this technic
     *
     * @param numberToParse - The phone number to be tested. It can be any combination of concatenated AREA CODE, PHONE NUMBER and EXTENSION.
     * @return - A normalized PhoneNumber object. Null if number does not start with "00", "+" or if resulting phone number is not isValidNumber()
     */
    private static Phonenumber.PhoneNumber parsePhoneNumber_00(String numberToParse) {

        if (numberToParse.startsWith("00")) {
            numberToParse = "+" + numberToParse.substring(2);
        }

        if (numberToParse.startsWith("+")) {
            try {
                Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(numberToParse, null);
                if (phoneNumberUtil.isValidNumber(phoneNumber)) {
                    return phoneNumber;
                }
                return null;
            } catch (NumberParseException e) {
                return null;
            }
        }

        return null;
    }

    /**
     * Parse a phone number along with the country of residence
     *
     * @param numberToParse     - The phone number to be tested. It can be any combination of concatenated AREA CODE, PHONE NUMBER and EXTENSION.
     * @param coutryOfResidence - the country of residence (...)
     * @return - A normalized PhoneNumber object. Null if resulting phone number is not isValidNumber()
     */
    private static Phonenumber.PhoneNumber parsePhoneNumber_ctryRes(String numberToParse, String coutryOfResidence) {

        try {
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(numberToParse, coutryOfResidence);
            if (phoneNumberUtil.isValidNumber(phoneNumber)) {
                return phoneNumber;
            }
            return null;
        } catch (NumberParseException e) {
            return null;
        }

    }

}
