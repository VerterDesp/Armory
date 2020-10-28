package com.vertersoft.primo.model.guns.handgun;


import com.vertersoft.primo.model.guns.handgun.enums.HandgunType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Handgun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private HandgunType handgunType;

    @Lob
    private Byte[] photo;

    private Float price;

    private Integer leftInStock;

    private String name;

    private String color;

    private Float weight;

    private Float totalLength;

    private Float barrelLength;

    private String brand;

    private String model;

    private String serialNumber;

    private String caliber;

    private String capacity;

    @Lob
    private String description;
}
