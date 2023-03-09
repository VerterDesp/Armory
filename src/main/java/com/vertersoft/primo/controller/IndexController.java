package com.vertersoft.primo.controller;

import com.vertersoft.primo.model.client.Client;
import com.vertersoft.primo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final ClientService clientService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/client")
    public String userAccess() {
        return "Client Content";
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
