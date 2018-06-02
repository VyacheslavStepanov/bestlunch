package com.sweb.bestlunch.entities.lunch;

import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Restaurant restaurant;
    private Double costPrice;
    @ManyToOne
    private ProductCategory productCategory;
    @ManyToMany(mappedBy = "products")
    private List<LunchSet> lunchSets= new ArrayList<>();

    public Product(){}
    public Product(String name, String description, Restaurant restaurant, ProductCategory productCategory) {
        this.name = name;
        this.restaurant = restaurant;
        this.description = description;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
