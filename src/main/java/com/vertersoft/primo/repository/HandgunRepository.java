package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.gun.handgun.Handgun;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HandgunRepository extends JpaRepository<Handgun, UUID> {

    boolean existsByModelAndBrand(@NotNull String model, @NotNull String brand);
}
