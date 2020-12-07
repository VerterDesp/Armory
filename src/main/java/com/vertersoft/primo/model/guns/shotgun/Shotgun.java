package com.vertersoft.primo.model.guns.shotgun;

import com.vertersoft.primo.model.guns.shotgun.enums.ShotgunType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Shotgun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShotgunType shotgunType;

    @Lob
    @ToString.Exclude
    private Byte[] photo;

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

    @Lob
    private String description;
}
