package com.vertersoft.primo.controller;

import com.vertersoft.primo.model.guns.handgun.Handgun;
import com.vertersoft.primo.service.HandgunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<String> save(@RequestBody @Valid Handgun handgun) {
        handgunService.save(handgun);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody @Valid Handgun handgun) {
        handgunService.update(id, handgun);
        return new ResponseEntity<>("Update of " +handgun.getModel()+ " successful", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        handgunService.delete(id);
        return new ResponseEntity<>("Deleted successful", HttpStatus.OK);
    }




}
