package com.vertersoft.primo.service;

import com.vertersoft.primo.exeptions.NotFoundException;
import com.vertersoft.primo.model.guns.handgun.Handgun;
import com.vertersoft.primo.repository.HandgunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandgunService {

    private HandgunRepository handgunRepository;

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
                .orElseThrow(NotFoundException::new);
    }
}
