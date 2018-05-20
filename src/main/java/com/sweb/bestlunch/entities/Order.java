package com.sweb.bestlunch.entities;

import com.sweb.bestlunch.Enums.OrderType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.LinkedHashSet;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Customer customer;
    private OrderType type;
    private Collection<Item> items = new LinkedHashSet<>();

    public Order(Customer customer, Collection<Item> items){
        this.customer = customer;
        this.type = OrderType.New;
        this.items = items;
    }
}
