package fr.mla.customer.service.validation;

import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.datavalidator.StringValidator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class CustomerIdValidator extends Validator<String> {

    @Override
    public void validate(String s, ValidationErrors validationErrors) throws ValidationException {

        new StringValidator(s, validationErrors)
                .matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}", s + " is not a valid Customer id");

    }
}
