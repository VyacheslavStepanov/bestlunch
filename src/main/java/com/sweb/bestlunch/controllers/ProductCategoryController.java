package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.entities.product.ProductCategory;
import com.sweb.bestlunch.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String addOrUpdateProductCategory(Model model, @ModelAttribute("product_category") ProductCategory productCategory) {

        if (productCategory.getName() != null && productCategory.getName().length() > 0) {

            service.saveOrUpdate(productCategory);
        } else {
            model.addAttribute("errorMessage", "fill all inputs");
            return "productForm";
        }
        return "redirect:/productCategories/";
    }

    @GetMapping("/{id}/delete")
    public String deleteProductCategory(@PathVariable("id") Long id){
        ProductCategory productCategory;
        try {
            productCategory = service.findById(id);
        } catch (IllegalArgumentException e){
            //TODO show popup "Category not found"
            return "redirect:/productCategories/";
        }
        if (productCategory.getProducts().size()==0) {
            service.delete(id);
        } else {
            //TODO show popup "Category has references to Poducts"
        }
        return "redirect:/productCategories/";
    }
}
