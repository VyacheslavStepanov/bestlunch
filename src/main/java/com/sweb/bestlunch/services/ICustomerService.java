package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer getById(Long id);
    Boolean save(Customer customer);
}
