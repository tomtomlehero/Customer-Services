package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.ExternalID;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.datavalidator.StringValidator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class ExternalIDValidator extends Validator<ExternalID> {

    @Override
    public void validate(ExternalID externalID, ValidationErrors validationErrors) throws ValidationException {

        new StringValidator(externalID.getUri(), validationErrors)
                .notNull("externalIDs.uri is mandatory")
                .matches("\\w{1,3}:\\w{1,3}:\\w{1,3}:\\w{1,40}", "externalIDs.uri must match: <Appli-Owner (max 3 char)>:<Appli-Code (max 3 char)>:<Obj-Class (max 3 char)>:<Obj-id (max 40 char)>");
    }
}
