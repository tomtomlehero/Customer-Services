package fr.mla.customer.service.util;

public class MappingUtil {


    public static String booleanToYN(Boolean b) {
        return (b ? "Y" : "N");
    }


    public static Boolean ynToBoolean(String s) {

        if (s == null) {
            return null;
        }

        if ("Y".equalsIgnoreCase(s)) {
            return true;
        }
        if ("N".equalsIgnoreCase(s)) {
            return false;
        }

        return null;
    }

}
