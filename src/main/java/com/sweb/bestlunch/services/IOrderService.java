package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.customer.Customer;
import com.sweb.bestlunch.entities.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getOrdersByCustomer(Customer customer);
}
