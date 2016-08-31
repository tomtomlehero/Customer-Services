package fr.mla.customer.service.util;

import org.apache.commons.lang3.StringUtils;

public class StringCleaner {

    public static String cleanName(String s) {

        if (s == null) {
            return null;
        }
        return StringUtils.stripAccents(StringUtils.trim(s.toUpperCase()));
    }

}
