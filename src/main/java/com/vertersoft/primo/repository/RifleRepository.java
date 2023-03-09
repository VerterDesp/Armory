package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.gun.rifle.Rifle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RifleRepository extends JpaRepository<Rifle, UUID> {
}
