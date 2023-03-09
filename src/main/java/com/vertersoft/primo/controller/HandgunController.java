package com.vertersoft.primo.controller;

import com.vertersoft.primo.model.gun.handgun.Handgun;
import com.vertersoft.primo.service.HandgunService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("handgun")
@RequiredArgsConstructor
public class HandgunController {

    private final HandgunService handgunService;

    @GetMapping
    public List<Handgun> findAllHandguns() {
        return handgunService.findAll();
    }

    @GetMapping("{id}")
    public Handgun findOne(@PathVariable String id) {
        return handgunService.findById(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody @Valid Handgun handgun) {
        handgunService.save(handgun);
        return "OK";
    }

    @PutMapping("{id}")
    public String update(@PathVariable String id, @RequestBody @Valid Handgun handgun) {
        handgunService.update(UUID.fromString(id), handgun);
        return "Update of " +handgun.getModel()+ " successful";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable UUID id) {
        handgunService.delete(id);
        return "Deleted successful";
    }
}
