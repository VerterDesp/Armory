package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.guns.handgun.Handgun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface HandgunRepository extends JpaRepository<Handgun, Long> {

    boolean existsByModelAndBrand(@NotNull String model, @NotNull String brand);
}
