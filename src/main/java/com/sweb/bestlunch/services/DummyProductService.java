package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.User;
import com.sweb.bestlunch.entities.lunch.Product;
import com.sweb.bestlunch.entities.lunch.ProductCategory;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyProductService implements IProductService{
    @Override
    public List<Product> getByRestaurant(Restaurant restaurant) {

        List<Product> products = new ArrayList<>();
        ProductCategory dessert = new ProductCategory("Dessert");
        ProductCategory first =  new ProductCategory("First course");
        ProductCategory main =  new ProductCategory("Main course");
        ProductCategory drinks = new ProductCategory("Drinks");


        products.add(new Product("Steake", "Tasty steake", restaurant, main));
        products.add(new Product("Orange juice", "Fresh orange juice", restaurant, drinks ));
        products.add(new Product("Potato soupe", "description for soup", restaurant, first));
        products.add(new Product("Borsch", "description for soup", restaurant, first));
        products.add(new Product("Pancake", "description for dessert", restaurant, dessert));
        products.add(new Product("Ice-cream", "Ice-cream with chocolate", restaurant, dessert));
        return products;
    }
}
