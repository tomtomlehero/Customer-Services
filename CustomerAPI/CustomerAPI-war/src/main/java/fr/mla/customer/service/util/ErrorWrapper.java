package fr.mla.customer.service.util;

import fr.mla.customer.api.swagger.model.Error;

public class ErrorWrapper {

    Error error;

    public ErrorWrapper(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
