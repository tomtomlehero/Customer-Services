package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.Phone;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class PhoneValidator extends Validator<Phone> {

    @Override
    public void validate(Phone phone, ValidationErrors validationErrors) throws ValidationException {

    }
}
