package com.sweb.bestlunch.entities;

import javax.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="PRODUCT_ID", unique= true, nullable=true, insertable=true, updatable=true)
    private Product product;
//    @ManyToOne (cascade=CascadeType.ALL)
//    private Order order;
    private Double price;
    private int quantity;

    public Item(){}
    public Long getId() {
        return id;
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

//    public Order getOrder() {
//        return order;
//    }
}
