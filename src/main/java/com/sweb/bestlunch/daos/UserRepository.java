package com.sweb.bestlunch.daos;

import com.sweb.bestlunch.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByConfimationToken(String confirmationToken);
}
