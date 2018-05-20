package com.sweb.bestlunch.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private Order order;
    private Product product;
    private Double price;
    private int quantity;


    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
