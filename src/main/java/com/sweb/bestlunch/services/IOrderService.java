package com.sweb.bestlunch.services;


import com.sweb.bestlunch.entities.Item;
import com.sweb.bestlunch.entities.Order;

import java.util.Collection;

public interface IOrderService {
    void createOrder(Collection<Item> items);

}
