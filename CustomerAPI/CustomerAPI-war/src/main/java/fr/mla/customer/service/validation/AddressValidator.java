package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.Address;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class AddressValidator extends Validator<Address> {

    @Override
    public void validate(Address address, ValidationErrors validationErrors) throws ValidationException {

    }
}
