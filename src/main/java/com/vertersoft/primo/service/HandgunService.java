package com.vertersoft.primo.service;

import com.vertersoft.primo.exception.AlreadyExistsException;
import com.vertersoft.primo.exception.NotFoundException;
import com.vertersoft.primo.model.gun.handgun.Handgun;
import com.vertersoft.primo.repository.HandgunRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class HandgunService {

    private final HandgunRepository handgunRepository;

    public List<Handgun> findAll() {
        return handgunRepository.findAll();
    }

    public Handgun findById(UUID id) {
        return handgunRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

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

    public void update(UUID idOfHandgunForUpdate, Handgun handgunForUpdate) {
        Handgun updatedHandgun = handgunRepository
                .findById(idOfHandgunForUpdate).orElseThrow(() -> new NotFoundException("Handgun not found"));

        BeanUtils.copyProperties(handgunForUpdate, updatedHandgun, "id");
        updatedHandgun.setModifiedAt(LocalDateTime.now());
    }

    public void delete(UUID id) {
        handgunRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);
        handgunRepository
                .deleteById(id);
    }
}
