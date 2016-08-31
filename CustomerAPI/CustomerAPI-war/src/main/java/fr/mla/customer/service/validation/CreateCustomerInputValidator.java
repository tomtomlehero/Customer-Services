package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.*;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.datavalidator.ObjectValidator;
import fr.mla.framework.ws.validation.datavalidator.StringValidator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class CreateCustomerInputValidator extends Validator<Customer> {

    @Override
    public void validate(Customer customer, ValidationErrors validationErrors) throws ValidationException {

        new StringValidator(customer.getId(), validationErrors)
                .nullOrBlank("Customer id must not be filled for a creation");


        new ObjectValidator(customer.getIdentity(), validationErrors)
                .notNull("Identity Fragment of the Customer is mandatory");

        if (customer.getIdentity() != null) {
            new IdentityValidator().validate(customer.getIdentity(), validationErrors);
        }

        for (Address address : customer.getAddresses()) {
            new StringValidator(address.getId(), validationErrors)
                    .nullOrBlank("Address id must not be filled for a creation");
            new AddressValidator().validate(address, validationErrors);
        }

        for (Card card : customer.getCards()) {
            new StringValidator(card.getId(), validationErrors)
                    .nullOrBlank("Card id must not be filled for a creation");
            new CardValidator().validate(card, validationErrors);
        }

        for (Email email : customer.getEmails()) {
            new StringValidator(email.getId(), validationErrors)
                    .nullOrBlank("Email id must not be filled for a creation");
            new EmailValidator().validate(email, validationErrors);
        }

        for (Phone phone : customer.getPhones()) {
            new StringValidator(phone.getId(), validationErrors)
                    .nullOrBlank("Phone id must not be filled for a creation");
            new PhoneValidator().validate(phone, validationErrors);
        }

        for (ExternalID externalId : customer.getExternalIDs()) {
            new ExternalIDValidator().validate(externalId, validationErrors);
        }


    }
}
