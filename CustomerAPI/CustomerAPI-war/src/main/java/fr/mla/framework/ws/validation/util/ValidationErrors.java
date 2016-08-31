package fr.mla.framework.ws.validation.util;


import java.util.ArrayList;
import java.util.List;

public class ValidationErrors {

    private List<String> errors;

    public ValidationErrors() {
        errors = new ArrayList<String>();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void add(String error) {
        this.errors.add(error);
    }

    public boolean hasError() {
        return (this.errors.size() > 0);
    }


}
