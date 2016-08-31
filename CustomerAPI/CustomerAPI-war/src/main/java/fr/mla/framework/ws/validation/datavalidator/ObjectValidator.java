package fr.mla.framework.ws.validation.datavalidator;

import fr.mla.framework.ws.validation.util.ValidationErrors;

public class ObjectValidator extends AbstractDataValidator<Object>  {


    public ObjectValidator(Object data, ValidationErrors validationErrors) {
        super(data, validationErrors);
    }


    @Override
    public ObjectValidator notNull(String message) {
        return (ObjectValidator) super.notNull(message);
    }

}
