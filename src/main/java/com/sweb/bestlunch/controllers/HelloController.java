package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.User;
import com.sweb.bestlunch.services.IRestaurantService;
import com.sweb.bestlunch.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method=RequestMethod.GET)
    public String hello(){

        return "hello";
    }
}
