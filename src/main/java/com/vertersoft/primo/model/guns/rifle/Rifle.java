package com.vertersoft.primo.model.guns.rifle;

import com.vertersoft.primo.model.guns.rifle.enums.RifleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rifle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RifleType rifleType;

    @Lob
    private Byte[] photo;

    private String price;

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

    private String twistRate; //Кількість канавок нарізу

    private String velocity;

    private String range;

    @Lob
    private String description;

}
