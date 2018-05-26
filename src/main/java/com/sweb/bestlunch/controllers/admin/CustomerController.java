package com.sweb.bestlunch.controllers.admin;

import com.sweb.bestlunch.entities.Customer;
import com.sweb.bestlunch.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    private ICustomerService customerService;
    public CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ModelAndView getCustomers(){
        Map<String,List<Customer>> model = new HashMap<>();
        List<Customer> customers = customerService.getAllCustomers();
        model.put("customers", customers);
        return new ModelAndView("customers",model);
    }
}
