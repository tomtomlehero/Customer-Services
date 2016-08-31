package fr.mla.framework.ws.validation;


import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public abstract class Validator<T> {

    /**
     * must be implemented by all the subclasses
     * The given ValidationErrors should be enriched in cas of validation failures
     */
    public abstract void validate(T object, ValidationErrors validationErrors) throws ValidationException;


    public void validate(T object) throws ValidationException {

        /**
         * New clear instance of ValidationErrors
         */
        ValidationErrors validationErrors = new ValidationErrors();

        /**
         * Call af the abstract method
         */
        this.validate(object, validationErrors);

        /**
         * Eventually throws a ValidationException.
         * The error message(s) can be retrieved from the exception and
         * rendered to service consumer
         */
        if (validationErrors.hasError()) {
            throw new ValidationException(validationErrors);
        }

    }


}
