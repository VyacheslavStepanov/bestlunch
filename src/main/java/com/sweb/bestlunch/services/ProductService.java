package com.sweb.bestlunch.services;

import com.sweb.bestlunch.daos.ProductRepository;
import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.User;
import com.sweb.bestlunch.entities.lunch.Product;
import com.sweb.bestlunch.entities.lunch.ProductCategory;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getByRestaurant(Restaurant restaurant) {
        return null;
    }
}
