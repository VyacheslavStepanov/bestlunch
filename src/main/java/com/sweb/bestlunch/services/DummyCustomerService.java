package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyCustomerService implements ICustomerService {
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Amore","mail@amore.com", "88008008070"));
        customers.add(new Customer("Dolche vita", "mail@dolche.com","88008008080"));
        customers.add(new Customer("Georgia", "mail@georgia.com","88008008060"));

        return customers;
    }

    @Override
    public Customer getById(Long id) {
        return new Customer("Georgia", "mail@georgia.com","88008008060");
    }

    @Override
    public Boolean save(Customer customer) {
        return true;
    }

}
