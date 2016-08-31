package fr.mla.framework.ws.validation.datavalidator;


import fr.mla.framework.ws.validation.util.ValidationErrors;

public abstract class AbstractDataValidator<T> {

    protected T data;

    protected ValidationErrors validationErrors;

    public AbstractDataValidator(T data, ValidationErrors validationErrors) {
        this.data = data;
        this.validationErrors = validationErrors;
    }


    public AbstractDataValidator notNull(String message) {
        if (this.data == null) {
            this.validationErrors.add(message);
        }
        return this;
    }



}
