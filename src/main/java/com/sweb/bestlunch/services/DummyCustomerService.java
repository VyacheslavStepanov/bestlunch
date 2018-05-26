package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DummyCustomerService implements ICustomerService {
    @Override
    public List<Customer> getAllCustomers() {
        return Arrays.asList(
                new Customer("Amore","mail@amore.com", "88008008070"),
                new Customer("Dolche vita", "mail@dolche.com","88008008080"),
                new Customer("Georgia", "mail@georgia.com","88008008060"));
    }

    @Override
    public Customer getCustomerById(int id) {
        return new Customer("Georgia", "mail@georgia.com","88008008060");
    }
}
