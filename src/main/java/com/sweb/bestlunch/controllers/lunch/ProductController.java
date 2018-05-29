package com.sweb.bestlunch.controllers.lunch;

import com.sweb.bestlunch.dtos.CustomerDTO;
import com.sweb.bestlunch.entities.customer.Customer;
import com.sweb.bestlunch.entities.lunch.Product;
import com.sweb.bestlunch.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {
    private IProductService service;

    @Autowired
    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView showAllProducts() {

        List<Product> products = service.getByCustomer(new Customer("Kino", "sdfd", "2345545324"));
        Map<String, List<Product>> model = new HashMap<>();
        model.put("products", products);
        return new ModelAndView("products", model);
    }

    @PostMapping("/")
    public String addOrUpdate(Model model, @ModelAttribute("product") Product product){

        if (product.getName() != null && product.getName().length()>0
                && product.getDescription()!= null && product.getDescription().length()>0
                && product.getProductCategory() != null) {

            if (service.save(product)) {
                return "redirect:/products";
            } else {
                model.addAttribute("errorMessage","can't save product");
                return "productForm";
            }
        }
        model.addAttribute("errorMessage","fill all inputs");
        return "productForm";
    }
    @GetMapping("/add")
    public String showAddProductPage(Model model){
        model.addAttribute("product",new Product());
        return "productForm";
    }


}
