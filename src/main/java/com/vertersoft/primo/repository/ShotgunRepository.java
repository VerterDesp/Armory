package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.gun.shotgun.Shotgun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShotgunRepository extends JpaRepository<Shotgun, UUID> {
}
