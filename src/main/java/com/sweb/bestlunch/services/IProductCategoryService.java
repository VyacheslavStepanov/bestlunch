package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.Product.ProductCategory;
import org.springframework.stereotype.Service;

@Service
public interface IProductCategoryService {
    void saveOrUpdate(ProductCategory productCategory);

}
