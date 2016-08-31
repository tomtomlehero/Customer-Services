package fr.mla.customer.service.delegate;

import fr.mla.customer.api.swagger.model.Customer;
import fr.mla.customer.api.swagger.model.CustomerId;
import fr.mla.customer.service.dao.*;
import fr.mla.customer.service.exception.UnparsableException;
import fr.mla.customer.service.mapping.DtoToEntityMapper;
import fr.mla.customer.service.mapping.EntityToDtoMapper;
import fr.mla.customer.service.model.*;
import fr.mla.customer.service.exception.CustomerServiceException;
import fr.mla.customer.service.exception.NotFoundException;
import fr.mla.customer.service.util.SearchCustomersInputParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDelegate {

    @Autowired
    AddressDao addressDao;

    @Autowired
    CardDao cardDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    EmailDao emailDao;

    @Autowired
    PhoneDao phoneDao;

    @Autowired
    ExternalIDDao externalIDDao;

    @Autowired
    DtoToEntityMapper dtoToEntityMapper;

    @Autowired
    EntityToDtoMapper entityToDtoMapper;

    @Transactional
    public List<Customer> search(SearchCustomersInputParameters searchParameters) throws CustomerServiceException {

        List<CustomerEntity> searchResultEnstity = customerDao.search(searchParameters);

        List<Customer> searchResult = new ArrayList<Customer>();
        entityToDtoMapper.map(searchResultEnstity, searchResult);

        return searchResult;
    }

    @Transactional
    public Customer view(String id, String view) throws CustomerServiceException, NotFoundException {

        CustomerEntity customerEntity = customerDao.find(id);

        if (customerEntity == null) {
            throw new NotFoundException();
        }

        Customer customer = new Customer();
        entityToDtoMapper.map(customerEntity, customer);

        return customer;
    }


    @Transactional
    public CustomerId create(Customer customer) throws CustomerServiceException {

        CustomerEntity customerEntity = new CustomerEntity();
        try {
            dtoToEntityMapper.map(customer, customerEntity);
        } catch (UnparsableException e) {
            throw new CustomerServiceException("unable to convert phone number to a NUMBER(15) (" + e.getPhoneNumber() + ")");
        }
        customerDao.save(customerEntity);

        for (AddressEntity addressEntity : customerEntity.getAddresses()) {
            addressDao.save(addressEntity);
        }

        for (CardEntity cardEntity : customerEntity.getCards()) {
            cardDao.save(cardEntity);
        }

        for (EmailEntity emailEntity : customerEntity.getEmails()) {
            emailDao.save(emailEntity);
        }

        for (PhoneEntity phoneEntity : customerEntity.getPhones()) {
            phoneDao.save(phoneEntity);
        }

        for (ExternalIDEntity externalIDEntity : customerEntity.getExternalIDs()) {
            externalIDDao.save(externalIDEntity);
        }

        CustomerId customerId = new CustomerId();
        customerId.setId(customerEntity.getUuidCust());

        return customerId;
    }

    @Transactional
    public void update(String id, Customer customer) throws CustomerServiceException, NotFoundException {

        CustomerEntity customerEntity = customerDao.find(id);

        if (customerEntity == null) {
            throw new NotFoundException();
        }

        try {
            dtoToEntityMapper.map(customer, customerEntity);
        } catch (UnparsableException e) {
            throw new CustomerServiceException("unable to convert phone number to a NUMBER(15) (" + e.getPhoneNumber() + ")");
        }

    }

    public void delete(String id) throws CustomerServiceException, NotFoundException {

        if (id.startsWith("f")) {
            throw new NotFoundException();
        }

    }

}
