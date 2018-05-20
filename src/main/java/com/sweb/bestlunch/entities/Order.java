package com.sweb.bestlunch.entities;

import com.sweb.bestlunch.Enums.OrderType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    //private Customer customer;
    private OrderType type;
    //private Collection<Item> items = new LinkedHashSet<>();

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
