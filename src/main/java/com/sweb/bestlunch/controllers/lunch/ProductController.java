package com.sweb.bestlunch.controllers.lunch;

import com.sweb.bestlunch.daos.ProductRepository;
import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.User;
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
    private ProductRepository repository;

    @Autowired
    public ProductController(IProductService service, ProductRepository repository) {

        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/")
    public ModelAndView showAllProducts() {

        List<Product> products = service.getByRestaurant(new Restaurant("Kino", "sdfd", "2345545324"));
        Map<String, List<Product>> model = new HashMap<>();
        model.put("products", products);
        return new ModelAndView("products", model);
    }

    @PostMapping("/")
    public String addOrUpdate(Model model, @ModelAttribute("product") Product product){

        if (product.getName() != null && product.getName().length()>0
                && product.getDescription()!= null && product.getDescription().length()>0
                && product.getProductCategory() != null) {

            repository.save(product);
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
