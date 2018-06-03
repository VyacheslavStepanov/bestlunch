package com.sweb.bestlunch.services;

import com.sweb.bestlunch.daos.ProductCategoryRepository;
import com.sweb.bestlunch.daos.ProductRepository;
import com.sweb.bestlunch.entities.Product.Product;
import com.sweb.bestlunch.entities.Product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductCategoryService implements IProductCategoryService {
    private ProductCategoryRepository repository;
    private ProductRepository productRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository repository, ProductRepository productRepository){
        this.repository = repository;
        this.productRepository = productRepository;
    }

    public ProductCategory findById(Long id) throws IllegalArgumentException {
        Optional<ProductCategory> productCategoryOptional = repository.findById(id);
        if (!productCategoryOptional.isPresent()) {
            throw new IllegalArgumentException();
        }
        return productCategoryOptional.get();
    }

    @Override
    public void saveOrUpdate(ProductCategory productCategory) {
        repository.save(productCategory);
    }

    public List<ProductCategory> findAllProductCategories(){
        return repository.findAll();
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }
}
