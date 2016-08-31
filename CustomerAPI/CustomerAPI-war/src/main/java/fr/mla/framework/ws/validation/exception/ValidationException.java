package fr.mla.framework.ws.validation.exception;


import fr.mla.framework.ws.validation.util.ValidationErrors;

import java.util.List;

public class ValidationException extends Exception {

    private ValidationErrors validationErrors;

    public ValidationException(ValidationErrors validationErrors) {
        this.validationErrors = validationErrors;
    }

    public List<String> getErrorMessages() {
        return validationErrors.getErrors();
    }
}
