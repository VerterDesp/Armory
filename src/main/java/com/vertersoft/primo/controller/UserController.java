package com.vertersoft.primo.controller;

import com.vertersoft.primo.model.users.User;
import com.vertersoft.primo.repository.UserRepository;
import com.vertersoft.primo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user) {
        userService.save(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.findAll();
    }
}
