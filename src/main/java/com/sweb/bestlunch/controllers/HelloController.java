package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.entities.customer.Customer;
import com.sweb.bestlunch.services.ICustomerService;
import com.sweb.bestlunch.services.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    private IOrderService orderService;
    private ICustomerService customerService;

    public HelloController(IOrderService orderService, ICustomerService customerService){
        this.orderService = orderService;
        this.customerService = customerService;
    }
    @RequestMapping(method=RequestMethod.GET)
    public String hello(){
        Customer customer = customerService.getById(1L);
        return "hello";
    }
}
