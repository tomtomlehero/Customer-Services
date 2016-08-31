package fr.mla.customer.feed.impl.delegate;

import fr.mla.customer.feed.derivatives.CardDerivatives;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CardDerivativesDelegate {


    private static final ResourceBundle paramBundle = ResourceBundle.getBundle("Param");

    private static final List<String> THE_EVIL_WORDS = new ArrayList<String>();

    static {
        String evilWords = paramBundle.getString("CUST_CARD_EVIL_WORDS");

        if (! "".equals(evilWords.trim())) {
            Collections.addAll(THE_EVIL_WORDS, evilWords.split(","));
        }
    }

    private static final Pattern alphaNumPattern = Pattern.compile("[a-zA-Z0-9]*");

    public static CardDerivatives process(String cardNumber) {

        if (StringUtils.isBlank(cardNumber)) {
            return new CardDerivatives(null, 0);
        }

        String trimedCardNumber = StringUtils.trim(cardNumber);


        for (String someEvilWord : THE_EVIL_WORDS) {
            if (trimedCardNumber.toUpperCase().contains(someEvilWord.toUpperCase())) {
                return new CardDerivatives(trimedCardNumber, 10);
            }
        }


        if (alphaNumPattern.matcher(trimedCardNumber).matches()) {
            return new CardDerivatives(trimedCardNumber, 99);
        } else {
            return new CardDerivatives(trimedCardNumber, 50);
        }

    }

}
