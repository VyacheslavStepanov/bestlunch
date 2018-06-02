package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.User;
import com.sweb.bestlunch.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrdersByRestaurant(Restaurant restaurant);
}
