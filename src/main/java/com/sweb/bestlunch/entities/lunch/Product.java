package com.sweb.bestlunch.entities.lunch;

import com.sweb.bestlunch.entities.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Customer customer;
    private Double costPrice;
    @ManyToOne
    private ProductCategory productCategory;
    @ManyToMany(mappedBy = "products")
    private List<LunchSet> lunchSets= new ArrayList<>();

    public Product(String name, String description, Customer customer, ProductCategory productCategory) {
        this.name = name;
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
