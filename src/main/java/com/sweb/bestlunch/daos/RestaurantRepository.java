package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
