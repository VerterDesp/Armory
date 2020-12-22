package com.vertersoft.primo.service;

import com.vertersoft.primo.exception.ItemExistsException;
import com.vertersoft.primo.exception.NotFoundException;
import com.vertersoft.primo.model.guns.handgun.Handgun;
import com.vertersoft.primo.repository.HandgunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void save(Handgun handgun) {
        final boolean handgunExists = handgunRepository
                .existsByModelAndBrand(handgun.getModel(), handgun.getBrand());
        if (!handgunExists) {
            handgunRepository.save(handgun);
        } else {
            throw new ItemExistsException(String
                    .format("Item %s %s exists", handgun.getModel(), handgun.getBrand()));
        }
    }

    @Transactional
    public Handgun update(Long idOfHandgunForUpdate, Handgun handgunForUpdate) {
        Handgun updatedHandgun = handgunRepository
                .getOne(idOfHandgunForUpdate);

        updatedHandgun.setHandgunType(handgunForUpdate.getHandgunType());
        updatedHandgun.setPhoto(handgunForUpdate.getPhoto());
        updatedHandgun.setPrice(handgunForUpdate.getPrice());
        updatedHandgun.setLeftInStock(handgunForUpdate.getLeftInStock());
        updatedHandgun.setWarranty(handgunForUpdate.getWarranty());
        updatedHandgun.setColor(handgunForUpdate.getColor());
        updatedHandgun.setWeight(handgunForUpdate.getWeight());
        updatedHandgun.setTotalLength(handgunForUpdate.getTotalLength());
        updatedHandgun.setBarrelLength(handgunForUpdate.getBarrelLength());
        updatedHandgun.setBrand(handgunForUpdate.getBrand());
        updatedHandgun.setModel(handgunForUpdate.getModel());
        updatedHandgun.setCaliber(handgunForUpdate.getCaliber());
        updatedHandgun.setCapacity(handgunForUpdate.getCapacity());
        updatedHandgun.setCountry(handgunForUpdate.getCountry());
        updatedHandgun.setDescription(handgunForUpdate.getDescription());

        return updatedHandgun;


    }
}
