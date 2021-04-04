package com.vertersoft.primo.controller;

import com.vertersoft.primo.model.users.User;
import com.vertersoft.primo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
