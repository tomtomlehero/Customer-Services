package fr.mla.customer.feed.impl.delegate;

import fr.mla.customer.feed.derivatives.EmailDerivatives;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class EmailDerivativesDelegate {

    public static EmailDerivatives process(String eMail) {

        if (StringUtils.isBlank(eMail)) {
            return new EmailDerivatives(null, 0);
        }

        String lowerCase = eMail.toLowerCase();
        String trimed = StringUtils.trim(lowerCase);
        String accentStriped = StringUtils.stripAccents(trimed);

        boolean hasSpaces = ! StringUtils.equals(lowerCase, trimed);
        boolean hasAccents = ! StringUtils.equals(trimed, accentStriped);
        boolean isEmailValid = EmailValidator.getInstance().isValid(accentStriped);

        if (! isEmailValid) {
            return new EmailDerivatives(null, 0);
        }

        int rank;

        if (hasSpaces) {
            if (hasAccents) {
                rank = 20;
            } else {
                rank = 80;
            }
        } else {
            if (hasAccents) {
                rank = 30;
            } else {
                rank = 99;
            }
        }

        return new EmailDerivatives(accentStriped, rank);

    }

}
