package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
}
