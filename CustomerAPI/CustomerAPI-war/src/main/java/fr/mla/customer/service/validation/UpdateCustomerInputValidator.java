package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.*;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.datavalidator.ObjectValidator;
import fr.mla.framework.ws.validation.datavalidator.StringValidator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class UpdateCustomerInputValidator extends Validator<Customer> {


    private String id;

    public UpdateCustomerInputValidator(String id) {
        this.id = id;
    }

    @Override
    public void validate(Customer customer, ValidationErrors validationErrors) throws ValidationException {

        new StringValidator(customer.getId(), validationErrors)
                .notNull("Customer Id is missing");

        new CustomerIdValidator().validate(customer.getId(), validationErrors);

        new CustomerIdValidator().validate(id, validationErrors);

        new StringValidator(customer.getId(), validationErrors)
                .in(new String[] {this.id}, "Customer Id does not match the id provided in the request");

        new ObjectValidator(customer.getIdentity(), validationErrors)
                .notNull("Identity Fragment of the Customer is mandatory");

        if (customer.getIdentity() != null) {
            new IdentityValidator().validate(customer.getIdentity(), validationErrors);
        }

        for (ExternalID externalId : customer.getExternalIDs()) {
            new ExternalIDValidator().validate(externalId, validationErrors);
        }


    }
}
