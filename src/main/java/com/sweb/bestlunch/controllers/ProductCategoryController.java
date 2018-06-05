package com.sweb.bestlunch.controllers;

import com.sweb.bestlunch.daos.ProductCategoryRepository;
import com.sweb.bestlunch.entities.product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/productCategories")
public class ProductCategoryController {
    private ProductCategoryRepository repository;

    @Autowired
    public ProductCategoryController(ProductCategoryRepository repository){
        this.repository = repository;
    }

    @GetMapping(value={"","/"})
    public ModelAndView showProductCategoryList(){
        List<ProductCategory> categories = repository.findAll();
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
    public String addProductCategory(Model model, @ModelAttribute("product_category") ProductCategory productCategory) {

        if (productCategory.getName() != null && productCategory.getName().length() > 0) {

            repository.save(productCategory);
        } else {
            model.addAttribute("errorMessage", "fill all inputs");
            return "productForm";
        }
        return "redirect:/productCategories/";
    }

    @GetMapping("/{id}/delete")
    public String deleteProductCategory(@PathVariable("id") Long id){
        ProductCategory productCategory;
        Optional<ProductCategory> productCategoryOptional = repository.findById(id);
        if(productCategoryOptional.isPresent()){
            productCategory =  productCategoryOptional.get();

        } else {
            //TODO show popup "Category not found"
            return "redirect:/productCategories/";
        }
        if (productCategory.getProducts().size()==0) {
            repository.delete(productCategory);
        } else {
            //TODO show popup "Category can't be deleted because has references to Poducts "
        }
        return "redirect:/productCategories/";
    }
}
