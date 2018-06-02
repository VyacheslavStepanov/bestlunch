package com.sweb.bestlunch.services;

import com.sweb.bestlunch.Enums.OrderStatus;
import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.order.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyOrderService implements IOrderService {
    @Override
    public List<Order> getOrdersByRestaurant(Restaurant restaurant) {
        Order order = new Order();
        order.setRestaurant(restaurant);
        order.setType(OrderStatus.New);
        List<Order> list = new ArrayList<>();
        list.add(order);
        //TODO refactor initialisation of list
        return list;
    }
}
