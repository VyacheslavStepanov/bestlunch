package com.sweb.bestlunch.services;

import com.sweb.bestlunch.Enums.OrderStatus;
import com.sweb.bestlunch.entities.customer.Customer;
import com.sweb.bestlunch.entities.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyOrderServiceImpl implements IOrderService {
    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setType(OrderStatus.New);
        List<Order> list = new ArrayList<>();
        list.add(order);
        //TODO refactor initialisation of list
        return list;
    }
}
