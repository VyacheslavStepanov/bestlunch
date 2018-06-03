package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.entities.Product.ProductCategory;
import com.sweb.bestlunch.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product_categories")
public class ProductCategoryController {
    private ProductCategoryService service;

    @Autowired
    public ProductCategoryController(ProductCategoryService service){
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView showProductCategoryList(){
        List<ProductCategory> categories = service.findAllProductCategories();
        Map<String,List<ProductCategory>> model = new HashMap<>();
        model.put("categories", categories);
        return new ModelAndView("product_categories", model);
    }
}
