package com.vertersoft.primo.service;

import com.vertersoft.primo.model.users.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);
}
