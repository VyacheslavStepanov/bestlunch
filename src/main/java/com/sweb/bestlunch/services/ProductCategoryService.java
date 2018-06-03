package com.sweb.bestlunch.services;

import com.sweb.bestlunch.daos.ProductCategoryRepository;
import com.sweb.bestlunch.entities.Product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCategoryService implements IProductCategoryService {
    private ProductCategoryRepository repository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository repository){
        this.repository = repository;
    }

    @Override
    public void saveOrUpdate(ProductCategory productCategory) {
        repository.save(productCategory);
    }
}
