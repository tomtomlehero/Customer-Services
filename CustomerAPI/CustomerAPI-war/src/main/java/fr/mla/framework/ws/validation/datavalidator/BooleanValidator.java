package fr.mla.framework.ws.validation.datavalidator;


import fr.mla.framework.ws.validation.util.ValidationErrors;

public class BooleanValidator extends AbstractDataValidator<Boolean> {

    public BooleanValidator(Boolean data, ValidationErrors validationErrors) {
        super(data, validationErrors);
    }

    @Override
    public BooleanValidator notNull(String message) {
        return (BooleanValidator) super.notNull(message);
    }


    public BooleanValidator isTrue(String message) {
        if (this.data != null) {
            if (!this.data) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public BooleanValidator isFalse(String message) {
        if (this.data != null) {
            if (this.data) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }


}
