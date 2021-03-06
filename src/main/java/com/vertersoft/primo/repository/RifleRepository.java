package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.guns.rifle.Rifle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifleRepository extends JpaRepository<Rifle, Long> {
}
