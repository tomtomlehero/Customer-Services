package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.Identity;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.datavalidator.StringValidator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class IdentityValidator extends Validator<Identity> {

    @Override
    public void validate(Identity identity, ValidationErrors validationErrors) throws ValidationException {


//        "firstName": "Alphonsine",
        new StringValidator(identity.getFirstName(), validationErrors)
                .notNull("identity.firsName is mandatory")
                .sizeMin(1, "identity.firsName is mandatory")
                .sizeMax(30, "identity.firstName must not exceed 30 characters");

//        "lastName": "Bluetooth",
        new StringValidator(identity.getLastName(), validationErrors)
                .notNull("identity.lastName is mandatory")
                .sizeMin(1, "identity.firsName is mandatory")
                .sizeMax(30, "identity.lastName must not exceed 30 characters");

//        "dateOfBirth": "1982-04-28", PROBLEMS WIRTH DATES

//        "gender": "F", PROBLEM WITH ENUMS

//        "civility": "Mme.",
        new StringValidator(identity.getCivility(), validationErrors)
                .sizeMax(35, "identity.civility must not exceed 35 characters");

//        "countryOfResidenceCd": "FR",
        new StringValidator(identity.getCountryOfResidenceCd(), validationErrors)
                .matches("[A-Z]{2}", "identity.countryOfResidenceCd must be exactly 2 letters in uppercase");

//        "countryOfResidenceLb": "France", IGNORED

//        "languageCd": "FR-fr",
        new StringValidator(identity.getLanguageCd(), validationErrors)
                .sizeMax(5, "identity.languageCd must not exceed 5 characters");

//        "prevLanguageCd": "TU"
        new StringValidator(identity.getPrevLanguageCd(), validationErrors)
                .sizeMax(2, "identity.prevLanguageCd must not exceed 2 characters");






    }


}
