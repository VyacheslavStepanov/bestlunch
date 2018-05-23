package com.sweb.bestlunch.services;

import com.sweb.bestlunch.daos.OrderRepository;
import com.sweb.bestlunch.entities.Customer;
import com.sweb.bestlunch.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {
    private OrderRepository orderRepository;
}
