package com.sweb.bestlunch.services;

import com.sweb.bestlunch.daos.UserRepository;
import com.sweb.bestlunch.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfimationToken(confirmationToken);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
