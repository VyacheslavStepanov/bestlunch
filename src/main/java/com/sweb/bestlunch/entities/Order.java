package com.sweb.bestlunch.entities;

import com.sweb.bestlunch.Enums.OrderType;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

@Entity
public class Order {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="CUSTOMER_ID", unique= true, nullable=true, insertable=true, updatable=true)
//    private Customer customer;
    private OrderType type;
//    @OneToMany(mappedBy="order")
//    private Collection<Item> items = new LinkedHashSet<>();

//    public Order(Customer customer, Collection<Item> items){
//        this.customer = customer;
//        this.type = OrderType.New;
//        this.items = items;
//    }
    public Order(){
        this.setType(OrderType.New);
    }

    public Long getId() {
        return id;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}
