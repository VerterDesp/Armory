package com.vertersoft.primo.controller;

import com.vertersoft.primo.dto.UserDTO;
import com.vertersoft.primo.model.users.User;
import com.vertersoft.primo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDTO user) {
        userService.save(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public String userAccess() {
        return "User Content";
    }

    @GetMapping("/moder")
    public String moderAccess() {
        return "Moderator content";
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Content";
    }


}
