package com.vertersoft.primo.service;

import com.vertersoft.primo.exception.AlreadyExistsException;
import com.vertersoft.primo.exception.NotFoundException;
import com.vertersoft.primo.model.guns.handgun.Handgun;
import com.vertersoft.primo.repository.HandgunRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        return handgunRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void save(Handgun handgun) {
        final boolean handgunExists = handgunRepository
                .existsByModelAndBrand(handgun.getModel(), handgun.getBrand());
        if (!handgunExists) {
            handgunRepository.save(handgun);
        } else {
            throw new AlreadyExistsException(String
                    .format("Item %s %s exists", handgun.getBrand(), handgun.getModel()));
        }
    }

    @Transactional
    public void update(Long idOfHandgunForUpdate, Handgun handgunForUpdate) {
        Handgun updatedHandgun = handgunRepository
                .getOne(idOfHandgunForUpdate);

        BeanUtils.copyProperties(handgunForUpdate, updatedHandgun, "id");
        updatedHandgun.setModifiedAt(LocalDateTime.now());
    }

    @Transactional
    public void delete(Long id) {
        handgunRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);
        handgunRepository
                .deleteById(id);
    }
}
