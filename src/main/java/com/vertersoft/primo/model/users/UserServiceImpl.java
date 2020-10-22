package com.vertersoft.primo.model.users;

import com.vertersoft.primo.repository.UserRepository;
import com.vertersoft.primo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository
                .findById(id);
    }
}
