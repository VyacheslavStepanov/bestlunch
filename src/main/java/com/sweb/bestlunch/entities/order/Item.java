package com.sweb.bestlunch.entities.order;

import com.sweb.bestlunch.entities.product.Product;

import javax.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", unique = true)
    private Product product;
    @ManyToOne
    private Order order;
    private Double price;
    private int quantity;

    public Item() {}

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() { return order;}

    public void setOrder(Order order) { this.order = order;}

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
