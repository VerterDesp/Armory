package com.vertersoft.primo.model.gun.shotgun;

import com.vertersoft.primo.model.gun.shotgun.enums.ShotgunType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
public class Shotgun {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ShotgunType shotgunType;

    @ToString.Exclude
    private String photo;

    private Float price;

    private Integer leftInStock;

    private String name;

    private String color;

    private String weight;

    private String totalLength;

    private String barrelLength;

    private String brand;

    private String model;

    private String serialNumber;

    private String caliber;

    private String capacity;

    private String description;
}
