package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.daos.OrderRepository;
import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.order.Order;
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
    private final OrderRepository repository;

    @Autowired
    public OrderController(IOrderService service, OrderRepository repository){
        this.service = service;
        this.repository = repository;
    }
    @GetMapping("/")
    public ModelAndView getOrders() {
        Restaurant restaurant = new Restaurant(1L,"A more","mail@amore.com","88008008080");
        Map<String, List<Order>> model = new HashMap<>();

        List<Order> orders = repository.findOrdersByRestaurant(restaurant);
        model.put("orders",orders);
        return new ModelAndView("restaurant_orders", model);
    }
}
