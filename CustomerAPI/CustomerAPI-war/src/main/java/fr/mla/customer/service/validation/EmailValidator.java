package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.Email;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class EmailValidator extends Validator<Email> {

    @Override
    public void validate(Email email, ValidationErrors validationErrors) throws ValidationException {

    }
}
