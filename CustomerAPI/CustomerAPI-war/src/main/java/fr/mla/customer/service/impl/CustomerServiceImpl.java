package fr.mla.customer.service.impl;

import fr.mla.customer.api.swagger.model.Card;
import fr.mla.customer.api.swagger.model.Customer;
import fr.mla.customer.api.swagger.model.CustomerId;
import fr.mla.customer.service.CustomerService;
import fr.mla.customer.service.delegate.CustomerDelegate;
import fr.mla.customer.service.exception.CustomerServiceException;
import fr.mla.customer.service.exception.NotFoundException;
import fr.mla.customer.service.util.SearchCustomersInputParameters;
import fr.mla.customer.service.validation.CreateCustomerInputValidator;
import fr.mla.customer.service.validation.CustomerIdValidator;
import fr.mla.customer.service.validation.SearchCustomersInputValidator;
import fr.mla.customer.service.validation.UpdateCustomerInputValidator;
import fr.mla.framework.ws.utils.ResponseUtil;
import fr.mla.framework.ws.validation.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDelegate customerDelegate;


    @Override
    public Response searchCustomers(String firstName, String lastName, String phone, String email, String extId, Boolean soundex, Integer algo, String view) {

        SearchCustomersInputParameters searchParameters = new SearchCustomersInputParameters(firstName, lastName, phone, email, extId, soundex, algo, view);

        try {
            new SearchCustomersInputValidator().validate(searchParameters);
        } catch (ValidationException e) {
            return ResponseUtil.errorResponse(e);
        }

        try {
            List<Customer> searchResult = customerDelegate.search(searchParameters);
            return ResponseUtil.okResponse(searchResult);
        } catch (CustomerServiceException e) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "XX", e.getMessage());
        } catch (Throwable t) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "tech", "technical error", t.getMessage());
        }
    }

    @Override
    public Response createCustomer(Customer customer) {

        try {
            new CreateCustomerInputValidator().validate(customer);
        } catch (ValidationException e) {
            return ResponseUtil.errorResponse(e);
        }

        try {
            CustomerId customerId = customerDelegate.create(customer);
            return ResponseUtil.okResponse(customerId);
        } catch (CustomerServiceException e) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "tech", "", e.getMessage());
        } catch (Throwable t) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "tech", "technical error", t.getMessage());
        }
    }

    @Override
    public Response deleteCustomer(String id) {

        try {
            new CustomerIdValidator().validate(id);
        } catch (ValidationException e) {
            return ResponseUtil.errorResponse(e);
        }

        try {
            customerDelegate.delete(id);
        } catch (CustomerServiceException e) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "XX", e.getMessage());
        } catch (NotFoundException e) {
            return ResponseUtil.errorResponse(Response.Status.NOT_FOUND, "not_found", "Customer with id " + id + " does not exist");
        } catch (Throwable t) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "tech", "technical error", t.getMessage());
        }

        return ResponseUtil.okResponse(null);
    }

    @Override
    public Response viewCustomer(String id, String view) {

        try {
            new CustomerIdValidator().validate(id);
        } catch (ValidationException e) {
            return ResponseUtil.errorResponse(e);
        }

        try {
            Customer customer = customerDelegate.view(id, view);
            return ResponseUtil.okResponse(customer);
        } catch (CustomerServiceException e) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "XX", e.getMessage());
        } catch (NotFoundException e) {
            return ResponseUtil.errorResponse(Response.Status.NOT_FOUND, "not_found", "Customer with id " + id + " does not exist");
        } catch (Throwable t) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "tech", "technical error", t.getMessage());
        }
    }

    @Override
    public Response updateCustomer(String id, Customer customer) {

        try {
            new UpdateCustomerInputValidator(id).validate(customer);
        } catch (ValidationException e) {
            return ResponseUtil.errorResponse(e);
        }

        try {
            customerDelegate.update(id, customer);
        } catch (CustomerServiceException e) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "XX", e.getMessage());
        } catch (NotFoundException e) {
            return ResponseUtil.errorResponse(Response.Status.NOT_FOUND, "not_found", "Customer with id " + id + " does not exist");
        } catch (Throwable t) {
            return ResponseUtil.errorResponse(Response.Status.INTERNAL_SERVER_ERROR, "tech", "technical error", t.getMessage());
        }

        return ResponseUtil.okResponse(customer);
    }

    @Override
    public Response createCustomerCard(String id, Card card) {
        return ResponseUtil.errorResponse(Response.Status.BAD_REQUEST, "XX", "Service is not yet implemented");
    }

    @Override
    public Response deleteCustomerCard(String id, String cardId) {
        return ResponseUtil.errorResponse(Response.Status.BAD_REQUEST, "XX", "Service is not yet implemented");
    }

    @Override
    public Response updateCustomerCard(String id, String cardId, Card card) {
        return ResponseUtil.errorResponse(Response.Status.BAD_REQUEST, "XX", "Service is not yet implemented");
    }

}
