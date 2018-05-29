package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.lunch.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}