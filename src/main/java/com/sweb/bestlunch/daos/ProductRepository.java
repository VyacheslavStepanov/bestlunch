package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByRestaurant(Restaurant restaurant);
}
