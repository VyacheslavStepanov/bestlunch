package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.Customer;
import com.sweb.bestlunch.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrdersByCustomer(Customer customer);
}
