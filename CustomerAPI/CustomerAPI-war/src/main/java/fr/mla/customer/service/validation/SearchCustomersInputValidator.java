package fr.mla.customer.service.validation;

import fr.mla.customer.service.util.SearchCustomersInputParameters;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.datavalidator.IntegerValidator;
import fr.mla.framework.ws.validation.datavalidator.StringValidator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;
import org.apache.commons.lang3.StringUtils;

public class SearchCustomersInputValidator extends Validator<SearchCustomersInputParameters> {

    @Override
    public void validate(SearchCustomersInputParameters searchParameters, ValidationErrors validationErrors) throws ValidationException {

        if (StringUtils.isBlank(searchParameters.getFirstName())
                && StringUtils.isBlank(searchParameters.getLastName())
                && StringUtils.isBlank(searchParameters.getPhone())
                && StringUtils.isBlank(searchParameters.getEmail())
                && StringUtils.isBlank(searchParameters.getExtId())) {
            validationErrors.add("At least one search parameter has to be filled (firstName, lastName, phone, email, extId)");
        }

        new StringValidator(searchParameters.getFirstName(), validationErrors)
                .sizeMin(3, "Parameter firstName must have at least 3 characters");

        new StringValidator(searchParameters.getLastName(), validationErrors)
                .sizeMin(3, "Parameter lastName must have at least 3 characters");

        new StringValidator(searchParameters.getPhone(), validationErrors)
                .matches("[0-9]{5,20}", "Parameter phone must have 5 to 20 digits (no spaces)");

        new StringValidator(searchParameters.getEmail(), validationErrors)
                .sizeMin(10, "Parameter email must have at least 10 characters");

        new StringValidator(searchParameters.getExtId(), validationErrors)
                .matches("\\w{1,3}:\\w{1,3}:\\w{1,3}:\\w{1,40}", "Parameter extId must match: <Appli-Owner (max 3 char)>:<Appli-Code (max 3 char)>:<Obj-Class (max 3 char)>:<Obj-id (max 40 char)>");

        new IntegerValidator(searchParameters.getAlgo(), validationErrors)
                .in(new Integer[] {1, 2}, "Parameter algo must take value 1 or 2");

        if ((searchParameters.getSoundex() != null) && searchParameters.getSoundex()) {
            if (searchParameters.getAlgo() == null) {
                validationErrors.add("for a phonetic search (soundex = true), the algorithm must be specified (algo = 1 or 2)");
            }
            if (StringUtils.isBlank(searchParameters.getFirstName()) && StringUtils.isBlank(searchParameters.getLastName())) {
                validationErrors.add("for a phonetic search (soundex = true), at least firstName or lastName must be specified");
            }
        }


    }
}
