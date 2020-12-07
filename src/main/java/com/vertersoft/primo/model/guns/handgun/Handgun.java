package com.vertersoft.primo.model.guns.handgun;


import com.vertersoft.primo.model.guns.handgun.enums.HandgunType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Handgun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    private HandgunType handgunType;

    @Lob
    @ToString.Exclude
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
