package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.customer.Customer;
import com.sweb.bestlunch.entities.lunch.Product;
import com.sweb.bestlunch.entities.lunch.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyProductService implements IProductService{
    @Override
    public List<Product> getByCustomer(Customer customer) {

        List<Product> products = new ArrayList<>();
        ProductCategory dessert = new ProductCategory("Dessert");
        ProductCategory first =  new ProductCategory("First course");
        ProductCategory main =  new ProductCategory("Main course");
        ProductCategory drinks = new ProductCategory("Drinks");

        products.add(new Product("Steake", "Tasty steake", customer, main));
        products.add(new Product("Orange juice", "Fresh orange juice", customer, drinks ));
        products.add(new Product("Potato soupe", "description for soup", customer, first));
        products.add(new Product("Borsch", "description for soup", customer, first));
        products.add(new Product("Pancake", "description for dessert", customer, dessert));
        products.add(new Product("Ice-cream", "Ice-cream with chocolate", customer, dessert));
        return products;
    }

    @Override
    public Product getById() {
        ProductCategory main = new ProductCategory("Main course");
        Customer customer = new Customer("Kongo","test@email.com","9600702290");
        return new Product("Steake", "Tasty steake", customer, main);
    }

    @Override
    public Boolean save(Product product) {
        return true;
    }
    @Override
    public Boolean delete(Product product) {
        return true;
    }
}
