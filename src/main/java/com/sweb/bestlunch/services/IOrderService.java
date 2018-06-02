package com.sweb.bestlunch.services;

import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.order.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getOrdersByRestaurant(Restaurant restaurant);
}
