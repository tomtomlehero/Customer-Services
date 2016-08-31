package fr.mla.framework.ws.validation.datavalidator;


import fr.mla.framework.ws.validation.util.ValidationErrors;

public class IntegerValidator extends AbstractDataValidator<Integer> {


    public IntegerValidator(Integer data, ValidationErrors validationErrors) {
        super(data, validationErrors);
    }


    @Override
    public IntegerValidator notNull(String message) {
        return (IntegerValidator) super.notNull(message);
    }



    public IntegerValidator gt(Integer that, String message) {
        if (this.data != null) {
            if (!(this.data > that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public IntegerValidator gte(Integer that, String message) {
        if (this.data != null) {
            if (!(this.data >= that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public IntegerValidator lt(Integer that, String message) {
        if (this.data != null) {
            if (!(this.data < that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public IntegerValidator lte(Integer that, String message) {
        if (this.data != null) {
            if (!(this.data <= that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public IntegerValidator in(Integer validValues[], String message) {
        if (this.data != null) {
            boolean ok = false;

            for (Integer validValue : validValues) {
                if (validValue.equals(this.data)) {
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
    
    public IntegerValidator sizeMax(int max, String message) {
        if (this.data != null) {
            if (!(data.toString().length() <= max)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

}
