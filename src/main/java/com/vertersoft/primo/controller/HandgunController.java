package com.vertersoft.primo.controller;

import com.vertersoft.primo.exeptions.NotFoundException;
import com.vertersoft.primo.model.guns.handgun.Handgun;
import com.vertersoft.primo.service.HandgunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("handgun")
public class HandgunController {

    private final HandgunService handgunService;

    @Autowired
    public HandgunController(HandgunService handgunService) {
        this.handgunService = handgunService;
    }

    @GetMapping
    public List<Handgun> findAllHandguns() {
        return handgunService.findAll();
    }

    @GetMapping("{id}")
    public Handgun findOne(@PathVariable Long id) {
        return handgunService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Handgun handgun) {
        try {
            handgunService.save(handgun);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("NOOOOOOO");
        }
    }

}
