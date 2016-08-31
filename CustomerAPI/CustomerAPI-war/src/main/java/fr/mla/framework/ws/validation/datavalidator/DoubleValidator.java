package fr.mla.framework.ws.validation.datavalidator;


import fr.mla.framework.ws.validation.util.ValidationErrors;

public class DoubleValidator extends AbstractDataValidator<Double> {

    public DoubleValidator(Double data, ValidationErrors validationErrors) {
        super(data, validationErrors);
    }

    @Override
    public DoubleValidator notNull(String message) {
        return (DoubleValidator) super.notNull(message);
    }



    public DoubleValidator gt(Double that, String message) {
        if (this.data != null) {
            if (!(this.data > that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public DoubleValidator gte(Double that, String message) {
        if (this.data != null) {
            if (!(this.data >= that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public DoubleValidator lt(Double that, String message) {
        if (this.data != null) {
            if (!(this.data < that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public DoubleValidator lte(Double that, String message) {
        if (this.data != null) {
            if (!(this.data <= that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }



}
