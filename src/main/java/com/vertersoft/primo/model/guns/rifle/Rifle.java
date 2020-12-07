package com.vertersoft.primo.model.guns.rifle;

import com.vertersoft.primo.model.guns.rifle.enums.RifleType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Rifle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    private RifleType rifleType;

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

    private String rifling;

    private Integer twistRate; //Кількість канавок нарізу

    private String velocity;

    private String range;

    @Lob
    private String description;

}
