package com.vertersoft.primo.service;

import com.vertersoft.primo.model.users.Customer;
import com.vertersoft.primo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final CustomerRepository customerRepository;

    @Autowired
    public UserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getUser(Long id) {
        return customerRepository
                .findById(id);
    }
}
