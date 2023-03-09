package com.vertersoft.primo.model.gun.rifle;

import com.vertersoft.primo.model.gun.rifle.enums.RifleType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@Entity
public class Rifle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private RifleType rifleType;

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

    private String rifling;

    private Integer twistRate; //Кількість канавок нарізу

    private String velocity;

    private String range;

    private String description;
}
