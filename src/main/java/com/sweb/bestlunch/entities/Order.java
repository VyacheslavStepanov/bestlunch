package com.sweb.bestlunch.entities;

import com.sweb.bestlunch.Enums.OrderStatus;
import com.sweb.bestlunch.entities.customer.Customer;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID", unique = true)
    private Customer customer;
    private OrderStatus status;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Collection<Item> items = new LinkedHashSet<>();

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void deleteItem(Item item) {
        this.items.remove(item);
    }

    public void setType(OrderStatus status) {
        this.status = status;
    }
}
