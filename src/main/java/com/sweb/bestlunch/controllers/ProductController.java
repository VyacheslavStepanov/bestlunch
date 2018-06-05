package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.daos.ProductRepository;
import com.sweb.bestlunch.daos.RestaurantRepository;
import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, RestaurantRepository restaurantRepository) {

        this.productRepository = productRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping(value={"","/"})
    public ModelAndView showAllProducts() {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(1L);
        List<Product> products;
        if (restaurantOptional.isPresent()){
            Restaurant restaurant = restaurantOptional.get();
            products = productRepository.findProductsByRestaurant(restaurant);
        } else {
            products = new ArrayList<>();
        }
        Map<String, List<Product>> model = new HashMap<>();
        model.put("products", products);
        return new ModelAndView("products", model);
    }

    @PostMapping("/")
    public String addOrUpdate(Model model, @ModelAttribute("product") Product product){

        if (product.getName() != null && product.getName().length()>0
                && product.getDescription()!= null && product.getDescription().length()>0
                && product.getProductCategory() != null) {

            productRepository.save(product);
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
