package com.sweb.bestlunch.controllers.admin;

import com.sweb.bestlunch.dtos.CustomerDTO;
import com.sweb.bestlunch.entities.customer.Customer;
import com.sweb.bestlunch.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    private static List<Customer> customers = new ArrayList<>();

    private String errorMessage = "Заполните все поля";
    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService){
        this.customerService = customerService;
        customers =  customerService.getAll();
    }

    @GetMapping("/")
    public ModelAndView getCustomers(){
        Map<String,List<Customer>> model = new HashMap<>();
        model.put("customers", customers);
        return new ModelAndView("customers",model);
    }

    @GetMapping("/add")
    public String showAddCustomerPage(Model model){
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("customerDTO",customerDTO);
        return "customerForm";
    }

    @PostMapping("/")
    public String saveOrUpdateCustomer(Model model, //
        @ModelAttribute("customerDTO") CustomerDTO customerDTO){
        Long id = customerDTO.getId();
        String name = customerDTO.getName();
        String email = customerDTO.getEmail();
        String phoneNumber = customerDTO.getPhoneNumber();

        if (name != null && name.length()>0
                && email != null && email.length()>0
                && phoneNumber != null && phoneNumber.length()>0) {
            Customer customer;
            if (id == 0) {
                customer = new Customer(name, email, phoneNumber);
                customers.add(customer);
            } else {
                customer = customerService.getById(id);
                customer.setEmail(email);
                customer.setName(name);
                customer.setPhoneNumber(phoneNumber);
            }
            if (customerService.save(customer)) {
                return "redirect:/customer";
            } else {
                model.addAttribute("errorMessage",errorMessage);
                return "customerForm";
            }
        }
        model.addAttribute("errorMessage",errorMessage);
        return "customerForm";
    }

    @GetMapping("/{id}/update")
    public String showUpdateUserForm(@PathVariable("id") Long id, Model model){
        Customer customer = customerService.getById(id);
        if (customer==null) return "error";
        CustomerDTO customerDTO = new CustomerDTO(customer);
        model.addAttribute("customerDTO",customerDTO);
        return "customerForm";
    }
}
