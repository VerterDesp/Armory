package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.guns.shotgun.Shotgun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShotgunRepository extends JpaRepository<Shotgun, Long> {
}
