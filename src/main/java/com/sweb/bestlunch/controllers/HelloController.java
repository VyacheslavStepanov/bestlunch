package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method=RequestMethod.GET)
    public String hello(){
        Customer customer = new Customer("Orange");
        return "hello";
    }
}
