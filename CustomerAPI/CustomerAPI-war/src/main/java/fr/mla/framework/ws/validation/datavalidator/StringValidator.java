package fr.mla.framework.ws.validation.datavalidator;


import fr.mla.framework.ws.validation.util.ValidationErrors;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringValidator extends AbstractDataValidator<String> {

    public StringValidator(String data, ValidationErrors validationErrors) {
        super(data, validationErrors);
    }

    @Override
    public StringValidator notNull(String message) {
        return (StringValidator) super.notNull(message);
    }


    public StringValidator matches(String regex, String message) {
        if (this.data != null) {
            if (!Pattern.matches(regex, this.data)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public StringValidator sizeMin(int min, String message) {
        if (this.data != null) {
            if (!(data.length() >= min)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public StringValidator sizeMax(int max, String message) {
        if (this.data != null) {
            if (!(data.length() <= max)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public StringValidator sizeFixed(int fixed, String message) {
        if (this.data != null) {
            if (!(data.length() == fixed)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public StringValidator isUpperCase(String message) {
        if (this.data != null) {
            if (!(data.toUpperCase().equals(data))) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public StringValidator isLowerCase(String message) {
        if (this.data != null) {
            if (!(data.toLowerCase().equals(data))) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public StringValidator in(String validValues[], String message) {
        if (this.data != null) {

            boolean ok = false;

            for (String validValue : validValues) {
                if (this.data.equals(validValue)) {
                    ok = true;
                    break;
                }
            }

            if (!ok) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public AbstractDataValidator nullOrBlank(String message) {
        if (StringUtils.isNotEmpty(this.data)) {
            this.validationErrors.add(message);
        }
        return this;
    }

}
