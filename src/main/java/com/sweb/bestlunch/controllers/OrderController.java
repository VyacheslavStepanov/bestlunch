package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.entities.Customer;
import com.sweb.bestlunch.entities.Order;
import com.sweb.bestlunch.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService service;

    public OrderController(IOrderService service){
        this.service = service;
    }
    @GetMapping("/")
    public ModelAndView getOrders() {
        Customer customer = new Customer("A more","mail@amore.com","88008008080");
        Map<String, List<Order>> model = new HashMap<>();

        List<Order> orders = service.getOrdersByCustomer(customer);
        model.put("orders",orders);
        return new ModelAndView("customer_orders", model);
    }
}