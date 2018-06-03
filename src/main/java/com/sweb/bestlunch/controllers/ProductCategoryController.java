package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.entities.Product.ProductCategory;
import com.sweb.bestlunch.services.ProductCategoryService;
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
@RequestMapping("/productCategories")
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
        model.put("product_categories", categories);
        return new ModelAndView("productCategories", model);
    }

    @GetMapping("/add")
    public String showProductCategoryForm(Model model){
        ProductCategory productCategory = new ProductCategory();
        model.addAttribute("product_category",productCategory);
        return "productCategoryForm";
    }

    @PostMapping("/")
    public String addOrUpdate(Model model, @ModelAttribute("product_category") ProductCategory productCategory) {

        if (productCategory.getName() != null && productCategory.getName().length() > 0) {

            service.saveOrUpdate(productCategory);
        } else {
            model.addAttribute("errorMessage", "fill all inputs");
            return "productForm";
        }
        return "redirect:/productCategories/";
    }
}
