package com.homework.mateakademy.service;

import com.homework.mateakademy.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService {
        List<User> getAllUsers();

    User getByUsername(String username);

    void saveUser(User user);
}
