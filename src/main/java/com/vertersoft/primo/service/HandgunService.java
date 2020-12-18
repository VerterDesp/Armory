package com.vertersoft.primo.service;

import com.vertersoft.primo.exeptions.ItemExistsException;
import com.vertersoft.primo.exeptions.NotFoundException;
import com.vertersoft.primo.model.guns.handgun.Handgun;
import com.vertersoft.primo.repository.HandgunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HandgunService {

    private final HandgunRepository handgunRepository;

    @Autowired
    public HandgunService(HandgunRepository handgunRepository) {
        this.handgunRepository = handgunRepository;
    }

    public List<Handgun> findAll() {
        return handgunRepository.findAll();
    }

    public Handgun findById(Long id) {
        return handgunRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Element with id \"%d\" not found", id)));
    }

    @Transactional
    public void save(Handgun handgun) {
        final boolean handgunExists = handgunRepository
                .existsByModelAndBrand(handgun.getModel(), handgun.getBrand());
        if (!handgunExists) {
            handgunRepository.save(handgun);
        } else {
            throw new ItemExistsException();
        }
    }
}
