package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.lunch.LunchSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchSetRepository extends JpaRepository<LunchSet, Long> {
}
