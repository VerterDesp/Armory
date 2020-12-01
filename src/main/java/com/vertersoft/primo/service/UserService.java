package com.vertersoft.primo.service;

import com.vertersoft.primo.model.users.Customer;
import com.vertersoft.primo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Customer> getUser(Long id) {
        return userRepository
                .findById(id);
    }
}
