package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.lunch.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
