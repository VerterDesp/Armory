package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.guns.handgun.Handgun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandgunRepository extends JpaRepository<Handgun, Long> {
}
