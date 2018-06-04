package com.sweb.bestlunch.entities.order;

import com.sweb.bestlunch.Enums.OrderStatus;
import com.sweb.bestlunch.entities.Restaurant;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESTAURANT_ID", unique = true)
    private Restaurant restaurant;
    private OrderStatus status;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Collection<Item> items = new LinkedHashSet<>();

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
