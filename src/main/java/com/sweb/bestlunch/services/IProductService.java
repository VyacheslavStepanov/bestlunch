package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.customer.Customer;
import com.sweb.bestlunch.entities.lunch.Product;

import java.util.List;

public interface IProductService {
    List<Product> getByCustomer(Customer customer);
    Product getById();
    Boolean save(Product product);
    Boolean delete(Product product);
}
